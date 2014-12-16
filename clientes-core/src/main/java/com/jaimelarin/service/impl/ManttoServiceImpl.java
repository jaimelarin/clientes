/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.service.impl;

import com.jaimelarin.dao.ClienteDao;
import com.jaimelarin.dao.EstadoDao;
import com.jaimelarin.dao.PaisDao;
import com.jaimelarin.dao.RegionDao;
import com.jaimelarin.model.Cliente;
import com.jaimelarin.model.Estado;
import com.jaimelarin.model.Pais;
import com.jaimelarin.model.Region;
import com.jaimelarin.service.ManttoService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jaimelarin
 */
@Service(value = "manttoService")
@Transactional(readOnly = true)
public class ManttoServiceImpl implements ManttoService {

    //Inyeccion de dependencias de ClienteDaoImpl
    @Resource(name = "clienteDao")
    ClienteDao clienteDaoImpl;

    //Inyeccion de dependecias de EstadoDaoImpl
    @Resource(name = "estadoDao")
    EstadoDao estadoDaoImpl;

    //Inyeccion de dependecias de PaisDaoImpl
    @Resource(name = "paisDao")
    PaisDao paisDaoImpl;

    //Inyeccion de dependecias de RegionDaoImpl
    @Resource(name = "regionDao")
    RegionDao regionDaoImpl;

    //getters y setters de (ClienteDao clienteDaoImpl)
    public ClienteDao getClienteDaoImpl() {
        return clienteDaoImpl;
    }

    public void setClienteDaoImpl(ClienteDao clienteDaoImpl) {
        this.clienteDaoImpl = clienteDaoImpl;
    }

    //getters y setters de (EstadoDao estadoDaoImpl)
    public EstadoDao getEstadoDaoImpl() {
        return estadoDaoImpl;
    }

    public void setEstadoDaoImpl(EstadoDao estadoDaoImpl) {
        this.estadoDaoImpl = estadoDaoImpl;
    }

    //getters y setters de (PaisDao paisDaoImpl)
    public PaisDao getPaisDaoImpl() {
        return paisDaoImpl;
    }

    public void setPaisDaoImpl(PaisDao paisDaoImpl) {
        this.paisDaoImpl = paisDaoImpl;
    }

    //getters y setters de (RegionDao regionDaoImpl)
    public RegionDao getRegionDaoImpl() {
        return regionDaoImpl;
    }

    public void setRegionDaoImpl(RegionDao regionDaoImpl) {
        this.regionDaoImpl = regionDaoImpl;
    }

    //metodos
    @Transactional(readOnly = false)
    @Override
    public void addRegion(Region region) {
        getRegionDaoImpl().addRegion(region);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateRegion(Region region) {
        getRegionDaoImpl().updateRegion(region);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteRegion(Region region) {
        getRegionDaoImpl().deleteRegion(region);
    }

    @Override
    public Region getRegionById(int id_region) {
        return getRegionDaoImpl().getRegionById(id_region);
    }

    @Override
    public List<Region> getRegiones() {
        return getRegionDaoImpl().getRegiones();
    }

    @Transactional(readOnly = false)
    @Override
    public void addPais(Pais pais) {
        getPaisDaoImpl().addPais(pais);
    }

    @Transactional(readOnly = false)
    @Override
    public void updatePais(Pais pais) {
        getPaisDaoImpl().updatePais(pais);
    }

    @Transactional(readOnly = false)
    @Override
    public void deletePais(Pais pais) {
        getPaisDaoImpl().deletePais(pais);
    }

    @Override
    public Pais getPaisById(int id_pais) {
        return getPaisDaoImpl().getPaisById(id_pais);
    }

    @Override
    public List<Pais> getPaises() {
        return getPaisDaoImpl().getPaises();
    }

    @Override
    public List<Pais> getPaisesByIdRegion(int id_region) {
        return getPaisDaoImpl().getPaisesByIdRegion(id_region);
    }

    @Transactional(readOnly = false)
    @Override
    public void addEstado(Estado estado) {
        getEstadoDaoImpl().addEstado(estado);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateEstado(Estado estado) {
        getEstadoDaoImpl().updateEstado(estado);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteEstado(Estado estado) {
        getEstadoDaoImpl().deleteEstado(estado);
    }

    @Override
    public Estado getEstadoById(int id_estado) {
        return getEstadoDaoImpl().getEstadoById(id_estado);
    }

    @Override
    public List<Estado> getEstados() {
        return getEstadoDaoImpl().getEstados();
    }

    @Override
    public List<Estado> getEstadosByIdPais(int id_pais) {
        return getEstadoDaoImpl().getEstadosByIdPais(id_pais);
    }

    @Transactional(readOnly = false)
    @Override
    public void addCliente(Cliente cliente) {
        getClienteDaoImpl().addCliente(cliente);
    }

    @Transactional(readOnly = false)
    @Override
    public void updateCliente(Cliente cliente) {
        getClienteDaoImpl().updateCliente(cliente);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteCliente(Cliente cliente) {
        getClienteDaoImpl().deleteCliente(cliente);
    }

    @Override
    public Cliente getClienteById(int id_cliente) {
        return getClienteDaoImpl().getClienteById(id_cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return getClienteDaoImpl().getClientes();
    }

    @Override
    public List<Cliente> getClientesByIdRegion(int id_region) {
        return getClienteDaoImpl().getClientesByIdRegion(id_region);
    }

    @Override
    public List<Cliente> getClientesByIdPais(int id_pais) {
        return getClienteDaoImpl().getClientesByIdPais(id_pais);
    }

    @Override
    public List<Cliente> getClientesByIdEstado(int id_estado) {
        return getClienteDaoImpl().getClientesByIdEstado(id_estado);
    }

}
