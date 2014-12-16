/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.managed.bean;

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
@ManagedBean(name = "regionMB")
@ViewScoped
public class RegionMB implements Serializable {

    @ManagedProperty(value = "#{manttoService}")
    ManttoService manttoService;
    private Region newRegion;
    private Region selectedRegion;
    List<Region> regionList;

    public RegionMB() {
        newRegion = new Region();
        selectedRegion = new Region();
    }

    //getters y setters
    public ManttoService getManttoService() {
        return manttoService;
    }

    public void setManttoService(ManttoService manttoService) {
        this.manttoService = manttoService;
    }

    public Region getNewRegion() {
        return newRegion;
    }

    public void setNewRegion(Region newRegion) {
        this.newRegion = newRegion;
    }

    public Region getSelectedRegion() {
        return selectedRegion;
    }

    public void setSelectedRegion(Region selectedRegion) {
        this.selectedRegion = selectedRegion;
    }

    //Metodos
    public void addRegion() {
        try {
            getManttoService().addRegion(newRegion);
        } catch (DataAccessException e) {
        }
    }

    public void updateRegion() {
        try {
            getManttoService().updateRegion(selectedRegion);
        } catch (DataAccessException e) {
        }
    }

    public void deleteRegion(int id_region) {
        try {
            Region rg = new Region();
            rg.setIdRegion(id_region);

            getManttoService().deleteRegion(rg);
        } catch (DataAccessException e) {
        }
    }

    public void resetRegion() {
        newRegion.setCodRegion("");
        newRegion.setRegion("");
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

    public void getRegionById(int id_region) {
        try {
            getManttoService().getRegionById(id_region);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

}
