/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.managed.bean;

import com.jaimelarin.model.Estado;
import com.jaimelarin.model.Pais;
import com.jaimelarin.service.ManttoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author jaimelarin
 */
@ManagedBean(name = "estadoMB")
@ViewScoped
public class EstadoMB implements Serializable {

    @ManagedProperty(value = "#{manttoService}")
    ManttoService manttoService;
    private Estado newEstado;
    private Estado selectedEstado;
    List<Estado> estadoList;
    List<Pais> paisList;
    private int id_pais;

    //Contructor
    public EstadoMB() {
        newEstado = new Estado();
        selectedEstado = new Estado();
    }

    //getters y setters
    public ManttoService getManttoService() {
        return manttoService;
    }

    public void setManttoService(ManttoService manttoService) {
        this.manttoService = manttoService;
    }

    public Estado getNewEstado() {
        return newEstado;
    }

    public void setNewEstado(Estado newEstado) {
        this.newEstado = newEstado;
    }

    public Estado getSelectedEstado() {
        return selectedEstado;
    }

    public void setSelectedEstado(Estado selectedEstado) {
        this.selectedEstado = selectedEstado;
    }

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    //Métodos
    public void addEstado() {
        try {
            Pais p = new Pais();
            p.setIdPais(id_pais);
            newEstado.setPais(p);

            getManttoService().addEstado(newEstado);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updateEstado() {
        try {
            getManttoService().updateEstado(selectedEstado);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteEstado(int id_estado) {
        try {
            Estado es = new Estado();
            es.setIdEstado(id_estado);

            getManttoService().deleteEstado(es);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void resetEstado() {
        newEstado.setCodEstado("");
        newEstado.setEstado("");
    }

    public List<Estado> getEstadoList() {
        try {
            estadoList = new ArrayList<>();
            estadoList.addAll(getManttoService().getEstados());

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return estadoList;
    }

    public void getEstadoById(int id_estado) {
        try {
            getManttoService().getEstadoById(id_estado);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Pais> getPaisList() {
        try {
            paisList = new ArrayList<>();
            paisList.addAll(getManttoService().getPaises());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return paisList;
    }
}
