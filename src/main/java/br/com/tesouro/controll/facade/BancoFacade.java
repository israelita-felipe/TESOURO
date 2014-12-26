/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.controll.facade;

import br.com.tesouro.Banco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cliente
 */
@Stateless
public class BancoFacade extends AbstractFacade<Banco> {
    @PersistenceContext(unitName = "br.com_Tesouro_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BancoFacade() {
        super(Banco.class);
    }
    
}
