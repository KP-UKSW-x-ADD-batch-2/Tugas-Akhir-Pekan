/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
public class Country {
    private String countryID;
    private String countryName;
    private String regionID;
    
    public Country(String countryID, String countryname, String regionID) {
        this.countryID = countryID;
        this.countryName = countryname;
        this.regionID = regionID;
    }

    public Country() {}

    public Country(String text) {}

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getCountryname() {
        return countryName;
    }

    public void setCountryname(String countryname) {
        this.countryName = countryName;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }
   
}
