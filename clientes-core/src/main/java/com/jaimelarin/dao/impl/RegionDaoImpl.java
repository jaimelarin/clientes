/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.dao.impl;

import com.jaimelarin.dao.RegionDao;
import com.jaimelarin.model.Region;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaimelarin
 */
@Repository(value = "regionDao")
public class RegionDaoImpl implements RegionDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRegion(Region region) {
        getSessionFactory().getCurrentSession().save(region);
    }

    @Override
    public void updateRegion(Region region) {
        getSessionFactory().getCurrentSession().update(region);
    }

    @Override
    public void deleteRegion(Region region) {
        getSessionFactory().getCurrentSession().delete(region);
    }

    @Override
    public Region getRegionById(int id_region) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Region where id_region=?")
                .setParameter(0, id_region).list();
        return (Region) list;
    }

    @Override
    public List<Region> getRegiones() {
        List list = getSessionFactory().getCurrentSession().createQuery("from Region").list();
        return list;
    }

}
