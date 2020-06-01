/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.icontrollers.IRegionController;
import daos.RegionDao;
import daos.idaos.IRegionDao;
import java.sql.Connection;
import java.util.List;
import models.RegionModel;

/**
 *
 * @author Yosef Febrianes
 */
public class RegionController implements IRegionController {

    private IRegionDao irdao;

    public RegionController(Connection connection) {
        irdao = new RegionDao(connection);
    }

    @Override
    public List<RegionModel> getAll() {
        if (irdao.getAll().isEmpty()) {
            System.out.println("Data yang dicari kosong");
            return null;
        } else {
            getAll();
        }
        return irdao.getAll();
    }

    @Override
    public String insert(RegionModel r) {
        String result;
        RegionModel region = new RegionModel(r.getRegionId(), r.getRegionName());
        if (irdao.insert(region)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(RegionModel r) {
        String result;
        RegionModel region = new RegionModel();
        region.getRegionId();
        region.getRegionName();
        if (irdao.update(r)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(String regionId) {
        String result;
        RegionModel region = new RegionModel();
        region.getRegionId();
        if (irdao.delete(regionId)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Data gagal dihapus";
        }
        return result;
    }

    @Override
    public List<RegionModel> search(String regionId) {
        String result;
        if (irdao.search(regionId).isEmpty()) {
            System.out.println("Data yang dicari kosong");
            result = "Data tidak ditemukan";
            return null;
        } else {
            search(regionId);
            result = "Data ditemukan";
        }
        return irdao.search(regionId);
    }

    /**
     * @param args the command line arguments
     */
}
