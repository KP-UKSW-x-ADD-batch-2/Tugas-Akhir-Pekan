/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.icontrollers.ILocationController;
import daos.LocationDao;
import daos.idaos.ILocationDao;
import java.sql.Connection;
import java.util.List;
import models.Location;
/**
 *
 * @author Yosef Febrianes
 */
public class LocationController implements ILocationController {

    private ILocationDao ildao;

    public LocationController(Connection connection) {
        ildao = new LocationDao(connection);
    }

    @Override
    public List<Location> getAll() {
            if (ildao.getAll().isEmpty()) {
            System.out.println("Data yang dicari kosong");
            return null;
        } else {
            getAll();
        }
        return ildao.getAll();    
    }

    @Override
    public String insert(Location r) {
        String result;
        Location Location = new Location(r.getLocationId(), r.getStreetAddress(), r.getPostalCode(), r.getCity(),r.getStateProvince(), r.getCountryId());
        if (ildao.insert(Location)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(Location r) {
            String result;
        Location location = new Location();
        location.getLocationId();
        location.getStreetAddress();
        location.getPostalCode();
        location.getCity();
        location.getStateProvince();
        location.getCountryId();
        
        if (ildao.update(r)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Data gagal diupdate";
        }
        return result;    
    }

    @Override
    public String delete(String locationId) {
              String result;
        Location location = new Location();
        location.getLocationId();
        if (ildao.delete(locationId)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Data gagal dihapus";
        }
        return result;}

    @Override
    public List<Location> search(String locationId) {
            String result;
        if (ildao.search(locationId).isEmpty()) {
            System.out.println("Data yang dicari kosong");
            result = "Data tidak ditemukan";
            return null;
        } else {
            search(locationId);
            result = "Data ditemukan";
        }
        return ildao.search(locationId);    
    }
    
    
    
}
