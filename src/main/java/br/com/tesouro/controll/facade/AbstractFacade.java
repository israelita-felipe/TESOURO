/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.controll.facade;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Cliente
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract Session getSession();

    public void create(T entity) {
        getSession().persist(entity);
    }

    public void edit(T entity) {
        getSession().merge(entity);
    }

    public void remove(T entity) {
        getSession().delete(getSession().merge(entity));
    }

    public T find(Serializable id) {
        return (T) getSession().load(entityClass, id);
    }

    public List<T> findAll() {
        DetachedCriteria query = DetachedCriteria.forClass(entityClass);
        return getEntitiesByDetachedCriteria(query);
    }

    public List<T> findRange(int[] range) {
        Criteria q = getSession().createCriteria(entityClass);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.list();
    }

    public int count() {
        return findAll().size();
    }

    public T getEntityByDetachedCriteria(DetachedCriteria criteria) {
        return (T) criteria.getExecutableCriteria(getSession()).uniqueResult();
    }

    public List<T> getEntitiesByDetachedCriteria(DetachedCriteria criteria) {
        return (List<T>) criteria.getExecutableCriteria(getSession()).list();
    }
}
