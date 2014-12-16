/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.dao;

import com.jaimelarin.model.Pais;
import java.util.List;

/**
 *
 * @author jaimelarin
 */
public interface PaisDao {

    public void addPais(Pais pais);

    public void updatePais(Pais pais);

    public void deletePais(Pais pais);

    public Pais getPaisById(int id_pais);

    public List<Pais> getPaises();

    public List<Pais> getPaisesByIdRegion(int id_region);

}
