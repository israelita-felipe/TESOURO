package br.com.tesouro.controll;

import br.com.tesouro.model.PossuiPermissao;
import br.com.tesouro.controll.facade.Facade;
import br.com.tesouro.controll.util.JsfUtil;
import br.com.tesouro.controll.util.PaginationHelper;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("possuiPermissaoController")
@SessionScoped
public class PossuiPermissaoController implements Serializable {

    private PossuiPermissao current;
    private DataModel items = null;
    private br.com.tesouro.controll.facade.Facade<PossuiPermissao> ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public PossuiPermissaoController() {
        this.ejbFacade = new Facade<>(PossuiPermissao.class);
    }

    public PossuiPermissao getSelected() {
        if (current == null) {
            current = new PossuiPermissao();
            current.setPossuiPermissaoPK(new br.com.tesouro.model.PossuiPermissaoPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private Facade<PossuiPermissao> getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (PossuiPermissao) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new PossuiPermissao();
        current.setPossuiPermissaoPK(new br.com.tesouro.model.PossuiPermissaoPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getPossuiPermissaoPK().setUsuarioId(current.getUsuario1().getId());
            current.getPossuiPermissaoPK().setPermissaoId(current.getPermissao().getId());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PossuiPermissaoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (PossuiPermissao) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getPossuiPermissaoPK().setUsuarioId(current.getUsuario1().getId());
            current.getPossuiPermissaoPK().setPermissaoId(current.getPermissao().getId());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PossuiPermissaoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (PossuiPermissao) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PossuiPermissaoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public PossuiPermissao getPossuiPermissao(br.com.tesouro.model.PossuiPermissaoPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = PossuiPermissao.class)
    public static class PossuiPermissaoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PossuiPermissaoController controller = (PossuiPermissaoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "possuiPermissaoController");
            return controller.getPossuiPermissao(getKey(value));
        }

        br.com.tesouro.model.PossuiPermissaoPK getKey(String value) {
            br.com.tesouro.model.PossuiPermissaoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new br.com.tesouro.model.PossuiPermissaoPK();
            key.setUsuarioId(Integer.parseInt(values[0]));
            key.setPermissaoId(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(br.com.tesouro.model.PossuiPermissaoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getUsuarioId());
            sb.append(SEPARATOR);
            sb.append(value.getPermissaoId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PossuiPermissao) {
                PossuiPermissao o = (PossuiPermissao) object;
                return getStringKey(o.getPossuiPermissaoPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + PossuiPermissao.class.getName());
            }
        }

    }

}
