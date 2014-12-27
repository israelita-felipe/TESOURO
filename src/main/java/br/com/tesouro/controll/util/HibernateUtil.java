/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.controll.util;

// IMPORTS
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Israel Araújo
 */
public class HibernateUtil {

    /**
     * ATRIBUTOS
     */
    private static final SessionFactory sessionFactory;

    /**
     * construtor estático da fábrica de sessões
     */
    static {
        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }

    }

    /**
     * metodo estático que retorna um fábria de sessão
     *
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
