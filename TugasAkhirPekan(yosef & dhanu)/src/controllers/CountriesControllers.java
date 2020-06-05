/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mysql.jdbc.Connection;
import controllers.icontrollers.ICountriesControllers;
import daos.CountryDao;
import java.util.List;
import javax.swing.JOptionPane;
import models.Country;
import daos.idaos.ICountryDao;

/**
 *
 * @author User
 */
public class CountriesControllers implements ICountriesControllers {
    private ICountryDao icoundao;
    public CountriesControllers(Connection connnection) {
        icoundao = new CountryDao(connnection) ;
    }

    @Override
    public List<Country> getAll() {
        if (icoundao.getAll().isEmpty()) {
            System.out.println("Data Kosong");
            return null;
        } else {
            System.out.println(icoundao.getAll());
        }
        return null;    
    }

    @Override
    public String insert(Country c) {
        String result;
        Country countries = new Country(c.getCountryID(), c.getCountryname(), c.getRegionID());
        if (icoundao.insert(countries)) {
            result = "Data berhasil Disimpan";
        } else  {
            result = "Data gagal disimpan";
        }
        return result;    }

    @Override
    public String update(Country c) {
       Country countries = new Country(c.getCountryID(), c.getCountryname(), c.getRegionID());
       String result;
        if (icoundao.update(c)) {
            result = "Data Berhasil Diubah";
        } else {
            result = "Data gagal Diubah";
        }
        return result;    
    }

    @Override
    public String delete(String countryId) {
        String result;
         Country countries = new Country();
         countries.getCountryID();
         if (icoundao.delete(countryId)) {
             result = "Data berhasil dihapus";
        } else {
             result = "Data gagal dihapus";
         }
         return result;    }

    @Override
    public List<Country> search(String countryId) {
        String result;
        if (icoundao.search(countryId).isEmpty()) {
            System.out.println("Data yang dicari kosong");
            result = "Data tidak ditemukan";
            return null;
        } else {
            search(countryId);
            result = "Data ditemukan";
        }
        return icoundao.search(countryId);    
    }
    
}
