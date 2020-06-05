/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import daos.idaos.ICountryDao;

/**
 *
 * @author User
 */
public class CountryDao implements ICountryDao {
    private Connection connection;
    
    public CountryDao (Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Country> getAll() {
         List<Country> listCountries = new ArrayList<>();
        //querynya
        String query = "SELECT * FROM countries";
        //logic jdbc

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Country c = new Country(resultSet.getString(1), resultSet.getString(2), 
                        resultSet.getString(3));
                listCountries.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCountries;        
    }

    @Override
    public boolean insert(Country c) {
        boolean result = false;

        String query = "INSERT INTO `countries` (`COUNTRY_ID`, `COUNTRY_NAME`, `REGION_ID`) "
                + "VALUES (?, ?, ?);";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, c.getCountryID());
            preparedStatement.setString(2, c.getCountryname());
            preparedStatement.setString(3, c.getRegionID());
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;    }

    @Override
    public boolean update(Country c) {
        boolean result = false;
        String query = "UPDATE `countries` SET `country_name` = ?, `region_id` = ? WHERE `countries`.`country_id` = ?;";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, c.getCountryID());
            preparedStatement.setString(2, c.getCountryname());
            preparedStatement.setString(3, c.getRegionID());
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;    }

    @Override
    public boolean delete(String countryID) {
        boolean result = false;
        String query = "DELETE FROM countries WHERE countries.country_id = ?;";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, countryID);
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;    }

    @Override
    public List<Country> search(String countryID) {
//        Test yahu = new Test();

        String searchName = countryID;

        String query = "select * from countries where country_id like '%" + searchName + "%'";
        List<Country> listcountries = new ArrayList<Country>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Country c = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                listcountries.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listcountries;    
    }
    
}
