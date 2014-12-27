/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.controll.facade;

import br.com.tesouro.controll.util.FacesContextUtil;
import javax.enterprise.inject.Produces;
import org.hibernate.Session;

/**
 *
 * @author Israel Araújo
 * @param <T>
 */
public class Facade<T> extends AbstractFacade<T> {

    @Override
    protected Session getSession() {
        return FacesContextUtil.getRequestSession();
    }

    public Facade(Class<T> clazz) {
        super(clazz);
    }

    @Produces
    public Facade<T> getInstance() {
        return this;
    }
}
