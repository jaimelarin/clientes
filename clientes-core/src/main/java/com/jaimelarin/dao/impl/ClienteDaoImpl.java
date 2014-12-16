/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.dao.impl;

import com.jaimelarin.dao.ClienteDao;
import com.jaimelarin.model.Cliente;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaimelarin
 */
@Repository(value = "clienteDao")
public class ClienteDaoImpl implements ClienteDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCliente(Cliente cliente) {
        getSessionFactory().getCurrentSession().save(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        getSessionFactory().getCurrentSession().update(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        getSessionFactory().getCurrentSession().delete(cliente);
    }

    @Override
    public Cliente getClienteById(int id_cliente) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Cliente where id_cliente=?")
                .setParameter(0, id_cliente).list();
        return (Cliente) list.get(0);
    }

    @Override
    public List<Cliente> getClientes() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Cliente").list();
        return list;
    }

    @Override
    public List<Cliente> getClientesByIdRegion(int id_region) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Cliente where id_region=?")
                .setParameter(0, id_region).list();
        return list;

    }

    @Override
    public List<Cliente> getClientesByIdPais(int id_pais) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Cliente where id_pais=?")
                .setParameter(0, id_pais).list();
        return list;
    }

    @Override
    public List<Cliente> getClientesByIdEstado(int id_estado) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Cliente where id_estado=?")
                .setParameter(0, id_estado).list();
        return list;
    }

}
