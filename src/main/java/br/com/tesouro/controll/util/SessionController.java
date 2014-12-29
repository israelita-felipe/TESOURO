/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.controll.util;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Session;

/**
 *
 * @author Israel Araújo
 */
@Named
@SessionScoped
public class SessionController implements Serializable{

    @Inject
    private SessionFactoryController factory;
    private Session session;

    public Session getSession() {
        if (session == null) {
            session = factory.getSessionFactory().openSession();
        }
        return session;
    }
}
