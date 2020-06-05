/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import daos.idaos.IRegionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;
import tests.RegionTest;

/**
 *
 * @author Yosef Febrianes
 */
public class RegionDao implements IRegionDao {

    private Connection connection;

    public RegionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Region> getAll() {
        List<Region> listRegion = new ArrayList<>();
        String query = "SELECT * FROM regions";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Region r = new Region(resultSet.getString(1), resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRegion;
    }

    @Override
    public boolean insert(Region r) {
        boolean result = false;
        
        String query = "INSERT INTO regions (region_id, region_name) VALUES (?,?);";
        
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, r.getRegionId());
            preparedStatement.setString(2, r.getRegionName());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Region r) {
        boolean result = false;
        
        String query = "UPDATE regions SET region_name = ? WHERE regions.region_id = ?;";
        
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, r.getRegionName());
            preparedStatement.setString(2, r.getRegionId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(String regionId) {
        boolean result = false;
        
        String query = "DELETE  FROM regions WHERE regions.region_id = ?;";
        
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, regionId);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

    @Override
    public List<Region> search(String regionId) {

        List<Region> listRegion = new ArrayList<Region>();
        String query = "select * from regions where region_id like '%" + regionId + "%'";
        
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Region r = new Region(resultSet.getString(1), resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRegion;

    }

//    @Override
//    public boolean Delete(String regionId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
