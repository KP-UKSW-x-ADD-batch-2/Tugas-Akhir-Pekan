/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Yosef Febrianes
 */
public class RegionModel {
    
    private String regionId;
    private String regionName;

    public RegionModel(){}
    
    public RegionModel(String text){}
    
    public RegionModel(String regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
    
    
}
