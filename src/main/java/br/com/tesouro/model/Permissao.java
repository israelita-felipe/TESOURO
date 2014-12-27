/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cliente
 */
@Entity
@Table(name = "permissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p"),
    @NamedQuery(name = "Permissao.findById", query = "SELECT p FROM Permissao p WHERE p.id = :id"),
    @NamedQuery(name = "Permissao.findByPermissao", query = "SELECT p FROM Permissao p WHERE p.permissao = :permissao"),
    @NamedQuery(name = "Permissao.findByUsuario", query = "SELECT p FROM Permissao p WHERE p.usuario = :usuario")})
public class Permissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "permissao")
    private String permissao;
    @Column(name = "usuario")
    private Integer usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissao")
    private List<PossuiPermissao> possuiPermissaoList;

    public Permissao() {
    }

    public Permissao(Integer id) {
        this.id = id;
    }

    public Permissao(Integer id, String permissao) {
        this.id = id;
        this.permissao = permissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<PossuiPermissao> getPossuiPermissaoList() {
        return possuiPermissaoList;
    }

    public void setPossuiPermissaoList(List<PossuiPermissao> possuiPermissaoList) {
        this.possuiPermissaoList = possuiPermissaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tesouro.Permissao[ id=" + id + " ]";
    }
    
}
