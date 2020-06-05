/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import daos.idaos.ILocationDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import tests.LocationTest;

/**
 *
 * @author Yosef Febrianes
 */
public class LocationDao implements ILocationDao {

    private Connection connection;

    public LocationDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Location> getAll() {
        List<Location> listLocation = new ArrayList<>();
        String query = "SELECT * FROM locations";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Location r = new Location(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                listLocation.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLocation;
    }

    @Override
    public boolean insert(Location r) {
        boolean result = false;

        String query
                = "INSERT INTO `locations` (`location_id`, `street_address`, `postal_code`, `city`, `state_province`, `country_id`) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, r.getLocationId());
            preparedStatement.setString(2, r.getStreetAddress());
            preparedStatement.setString(3, r.getPostalCode());
            preparedStatement.setString(4, r.getCity());
            preparedStatement.setString(5, r.getStateProvince());
            preparedStatement.setString(6, r.getCountryId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Location r) {
        boolean result = false;

        String query
                = "UPDATE `locations` SET `street_address` = ?, `postal_code` = ?, `city` = ?, `state_province` = ?, `country_id` = ? WHERE `locations`.`location_id` = ?;";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, r.getStreetAddress());
            preparedStatement.setString(2, r.getPostalCode());
            preparedStatement.setString(3, r.getCity());
            preparedStatement.setString(4, r.getStateProvince());
            preparedStatement.setString(5, r.getCountryId());
            preparedStatement.setString(6, r.getLocationId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(String locationId) {
        boolean result = false;

        String query = "DELETE FROM locations WHERE locations.location_id = ?;";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, locationId);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Location> search(String locationId) {
        List<Location> listLocation = new ArrayList<Location>();
        String query = "select * from locations where location_id like '%" + locationId + "%'";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Location r = new Location(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                listLocation.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLocation;
    }

}
