/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.managed.bean;

import com.jaimelarin.model.Cliente;
import com.jaimelarin.model.Estado;
import com.jaimelarin.model.Pais;
import com.jaimelarin.model.Region;
import com.jaimelarin.service.ManttoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.ViewScoped;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author jaimelarin
 */
@ManagedBean(name = "clienteMB")
@ViewScoped
public class ClienteMB implements Serializable {

    @ManagedProperty(value = "#{manttoService}")
    ManttoService manttoService;
    private Cliente newCliente;
    private Cliente selectedCliente;
    List<Region> regionList;
    List<Pais> paisList;
    List<Estado> estadoList;
    List<Cliente> clienteList;
    List<Pais> paisListByIdRegion;
    List<Estado> estadoListByIdPais;
    private String region;
    private String pais;
    private String estado;
    private HashMap regiones;
    private HashMap paises;
    private HashMap estados;
    private int id_cliente;

    //Constructor
    public ClienteMB() {
        newCliente = new Cliente();
        selectedCliente = new Cliente();
    }

    public ClienteMB(ManttoService manttoService, Cliente newCliente, Cliente selectedCliente, List<Region> regionList, List<Pais> paisList, List<Estado> estadoList, List<Cliente> clienteList, List<Pais> paisListByIdRegion, List<Estado> estadoListByIdPais, String region, String pais, String estado, HashMap regiones, HashMap paises, HashMap estados, int id_region, int id_pais, int id_estado) {
        this.manttoService = manttoService;
        this.newCliente = newCliente;
        this.selectedCliente = selectedCliente;
        this.regionList = regionList;
        this.paisList = paisList;
        this.estadoList = estadoList;
        this.clienteList = clienteList;
        this.paisListByIdRegion = paisListByIdRegion;
        this.estadoListByIdPais = estadoListByIdPais;
        this.region = region;
        this.pais = pais;
        this.estado = estado;
        this.regiones = regiones;
        this.paises = paises;
        this.estados = estados;
        this.id_cliente = id_cliente;
    }

    @PostConstruct
    public void init() {
        regionList = new ArrayList<>();
        regionList.addAll(getManttoService().getRegiones());

        regiones = new HashMap();

        for (int i = 0; i < regionList.size(); i++) {
            regiones.put(regionList.get(i).getRegion(), regionList.get(i).getIdRegion().toString());
        }
    }

    //getters y setters
    public ManttoService getManttoService() {
        return manttoService;
    }

    public void setManttoService(ManttoService manttoService) {
        this.manttoService = manttoService;
    }

    public Cliente getNewCliente() {
        return newCliente;
    }

    public void setNewCliente(Cliente newCliente) {
        this.newCliente = newCliente;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

    public List<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }

    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    public List<Pais> getPaisListByIdRegion() {
        return paisListByIdRegion;
    }

    public void setPaisListByIdRegion(List<Pais> paisListByIdRegion) {
        this.paisListByIdRegion = paisListByIdRegion;
    }

    public List<Estado> getEstadoListByIdPais() {
        return estadoListByIdPais;
    }

    public void setEstadoListByIdPais(List<Estado> estadoListByIdPais) {
        this.estadoListByIdPais = estadoListByIdPais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public HashMap getRegiones() {
        return regiones;
    }

    public void setRegiones(HashMap regiones) {
        this.regiones = regiones;
    }

    public HashMap getPaises() {
        return paises;
    }

    public void setPaises(HashMap paises) {
        this.paises = paises;
    }

    public HashMap getEstados() {
        return estados;
    }

    public void setEstados(HashMap estados) {
        this.estados = estados;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    //Métodos
    public void onRegionChange() {
        if (region != null && !region.equals("")) {
            paisListByIdRegion = new ArrayList<>();
            paisListByIdRegion.addAll(getManttoService().getPaisesByIdRegion(Integer.valueOf(region)));

            paises = new HashMap();

            for (int i = 0; i < paisListByIdRegion.size(); i++) {
                paises.put(paisListByIdRegion.get(i).getPais(), paisListByIdRegion.get(i).getIdPais());

            }

        } else {
            paisListByIdRegion = new ArrayList<>();
            paises = new HashMap();
        }
    }

    public void onPaisChange() {
        if (pais != null && !pais.equals("")) {
            estadoListByIdPais = new ArrayList<>();
            estadoListByIdPais.addAll(getManttoService().getEstadosByIdPais(Integer.valueOf(pais)));

            estados = new HashMap();

            for (int i = 0; i < estadoListByIdPais.size(); i++) {
                estados.put(estadoListByIdPais.get(i).getEstado(), estadoListByIdPais.get(i).getIdEstado());

            }

        } else {
            estadoListByIdPais = new ArrayList<>();
            estados = new HashMap();
        }
    }

    public void addCliente() {
        try {
            Region rg = new Region();
            rg.setIdRegion(Integer.valueOf(region));
            newCliente.setRegion(rg);

            Pais p = new Pais();
            p.setIdPais(Integer.valueOf(pais));
            newCliente.setPais(p);

            Estado es = new Estado();
            es.setIdEstado(Integer.valueOf(estado));
            newCliente.setEstado(es);

            getManttoService().addCliente(newCliente);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateCliente() {
        try {
            Region rg = new Region();
            rg.setIdRegion(Integer.valueOf(region));
            selectedCliente.setRegion(rg);

            Pais p = new Pais();
            p.setIdPais(Integer.valueOf(pais));
            selectedCliente.setPais(p);

            Estado es = new Estado();
            es.setIdEstado(Integer.valueOf(estado));
            selectedCliente.setEstado(es);

            getManttoService().updateCliente(selectedCliente);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(int id_cliente) {
        try {
            Cliente cl = new Cliente();
            cl.setIdCliente(id_cliente);

            getManttoService().deleteCliente(cl);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void resetCliente() {
        newCliente.setCodCliente("");
        newCliente.setNombres("");
        newCliente.setApellidos("");
        newCliente.setFechaNac(null);
        newCliente.setDomicilio("");
        newCliente.setRegion(null);
        newCliente.setPais(null);
        newCliente.setEstado(null);
    }

    public List<Cliente> getClienteList() {
        try {
            clienteList = new ArrayList<>();
            clienteList.addAll(getManttoService().getClientes());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return clienteList;
    }

    public void getClienteById(int id_cliente) {
        try {
            getManttoService().getClienteById(id_cliente);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

}
