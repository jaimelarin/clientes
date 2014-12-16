/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.dao;

import com.jaimelarin.model.Cliente;
import java.util.List;

/**
 *
 * @author jaimelarin
 */
public interface ClienteDao {

    public void addCliente(Cliente cliente);

    public void updateCliente(Cliente cliente);

    public void deleteCliente(Cliente cliente);

    public Cliente getClienteById(int id_cliente);

    public List<Cliente> getClientes();

    public List<Cliente> getClientesByIdRegion(int id_region);

    public List<Cliente> getClientesByIdPais(int id_pais);

    public List<Cliente> getClientesByIdEstado(int id_estado);
}
