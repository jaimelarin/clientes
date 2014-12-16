/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.dao;

import com.jaimelarin.model.Estado;
import java.util.List;

/**
 *
 * @author jaimelarin
 */
public interface EstadoDao {

    public void addEstado(Estado estado);

    public void updateEstado(Estado estado);

    public void deleteEstado(Estado estado);

    public Estado getEstadoById(int id_estado);

    public List<Estado> getEstados();

    public List<Estado> getEstadosByIdPais(int id_pais);

}
