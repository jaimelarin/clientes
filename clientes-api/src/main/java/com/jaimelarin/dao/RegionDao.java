/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaimelarin.dao;

import com.jaimelarin.model.Region;
import java.util.List;

/**
 *
 * @author jaimelarin
 */
public interface RegionDao {

    public void addRegion(Region region);

    public void updateRegion(Region region);

    public void deleteRegion(Region region);

    public Region getRegionById(int id_region);

    public List<Region> getRegiones();

}
