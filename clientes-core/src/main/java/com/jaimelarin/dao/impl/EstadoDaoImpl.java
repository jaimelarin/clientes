/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.dao.impl;

import com.jaimelarin.dao.EstadoDao;
import com.jaimelarin.model.Estado;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaimelarin
 */
@Repository(value = "estadoDao")
public class EstadoDaoImpl implements EstadoDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEstado(Estado estado) {
        getSessionFactory().getCurrentSession().save(estado);
    }

    @Override
    public void updateEstado(Estado estado) {
        getSessionFactory().getCurrentSession().update(estado);
    }

    @Override
    public void deleteEstado(Estado estado) {
        getSessionFactory().getCurrentSession().delete(estado);
    }

    @Override
    public Estado getEstadoById(int id_estado) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Estado where id_estado=?")
                .setParameter(0, id_estado).list();
        return (Estado) list;

    }

    @Override
    public List<Estado> getEstados() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Estado").list();
        return list;
    }

    @Override
    public List<Estado> getEstadosByIdPais(int id_pais) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Estado where id_pais=?")
                .setParameter(0, id_pais).list();
        return list;
    }

}
