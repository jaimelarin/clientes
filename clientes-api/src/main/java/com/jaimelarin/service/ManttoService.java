/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.service;

import com.jaimelarin.model.Cliente;
import com.jaimelarin.model.Estado;
import com.jaimelarin.model.Pais;
import com.jaimelarin.model.Region;
import java.util.List;

/**
 *
 * @author jaimelarin
 */
public interface ManttoService {

    //Mantenimiento a Region
    public void addRegion(Region region);

    public void updateRegion(Region region);

    public void deleteRegion(Region region);

    public Region getRegionById(int id_region);

    public List<Region> getRegiones();

    //Mantenimiento a Pais
    public void addPais(Pais pais);

    public void updatePais(Pais pais);

    public void deletePais(Pais pais);

    public Pais getPaisById(int id_pais);

    public List<Pais> getPaises();

    public List<Pais> getPaisesByIdRegion(int id_region);

    //Mantenimiento a Estado
    public void addEstado(Estado estado);

    public void updateEstado(Estado estado);

    public void deleteEstado(Estado estado);

    public Estado getEstadoById(int id_estado);

    public List<Estado> getEstados();

    public List<Estado> getEstadosByIdPais(int id_pais);

    //Mantenimiento a Cliente
    public void addCliente(Cliente cliente);

    public void updateCliente(Cliente cliente);

    public void deleteCliente(Cliente cliente);

    public Cliente getClienteById(int id_cliente);

    public List<Cliente> getClientes();

    public List<Cliente> getClientesByIdRegion(int id_region);

    public List<Cliente> getClientesByIdPais(int id_pais);

    public List<Cliente> getClientesByIdEstado(int id_estado);

}
