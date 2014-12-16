/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.dao.impl;

import com.jaimelarin.dao.PaisDao;
import com.jaimelarin.model.Pais;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaimelarin
 */
@Repository(value = "paisDao")
public class PaisDaoImpl implements PaisDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPais(Pais pais) {
        getSessionFactory().getCurrentSession().save(pais);
    }

    @Override
    public void updatePais(Pais pais) {
        getSessionFactory().getCurrentSession().update(pais);
    }

    @Override
    public void deletePais(Pais pais) {
        getSessionFactory().getCurrentSession().delete(pais);
    }

    @Override
    public Pais getPaisById(int id_pais) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Pais where id_pais=?")
                .setParameter(0, id_pais).list();
        return (Pais) list;
    }

    @Override
    public List<Pais> getPaises() {
        List list = getSessionFactory().getCurrentSession().createQuery("from Pais").list();
        return list;
    }

    @Override
    public List<Pais> getPaisesByIdRegion(int id_region) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Pais where id_region=?")
                .setParameter(0, id_region).list();
        return list;
    }

}
