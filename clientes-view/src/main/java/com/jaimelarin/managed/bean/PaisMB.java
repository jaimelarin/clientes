/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.managed.bean;

import com.jaimelarin.model.Pais;
import com.jaimelarin.model.Region;
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
@ManagedBean(name = "paisMB")
@ViewScoped
public class PaisMB implements Serializable {

    @ManagedProperty(value = "#{manttoService}")
    ManttoService manttoService;
    private Pais newPais;
    private Pais selectedPais;
    List<Pais> paisList;
    List<Region> regionList;
    private int id_region;

    //Constructor
    public PaisMB() {
        newPais = new Pais();
        selectedPais = new Pais();
    }

    //getters y setters
    public ManttoService getManttoService() {
        return manttoService;
    }

    public void setManttoService(ManttoService manttoService) {
        this.manttoService = manttoService;
    }

    public Pais getNewPais() {
        return newPais;
    }

    public void setNewPais(Pais newPais) {
        this.newPais = newPais;
    }

    public Pais getSelectedPais() {
        return selectedPais;
    }

    public void setSelectedPais(Pais selectedPais) {
        this.selectedPais = selectedPais;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    //Métodos
    public void addPais() {
        try {
            Region rg = new Region();
            rg.setIdRegion(id_region);
            newPais.setRegion(rg);

            getManttoService().addPais(newPais);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updatePais() {
        try {
            getManttoService().updatePais(selectedPais);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void deletePais(int id_pais) {
        try {
            Pais p = new Pais();
            p.setIdPais(id_pais);

            getManttoService().deletePais(p);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void resetPais() {
        newPais.setCodPais("");
        newPais.setPais("");
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

    public void getPaisById(int id_pais) {
        try {
            getManttoService().getPaisById(id_pais);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Region> getRegionList() {
        try {
            regionList = new ArrayList<>();
            regionList.addAll(getManttoService().getRegiones());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return regionList;
    }

}
