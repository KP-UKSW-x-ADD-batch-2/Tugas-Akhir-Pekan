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
import models.Department;
import daos.idaos.IDepartmentDao;

/**
 *
 * @author User
 */
public class DepartmentDao implements IDepartmentDao {
    private Connection connection;
    
    public DepartmentDao (Connection connection) {
        this.connection = connection;
    }
 
    @Override
    public List<Department> getAll() {
        List<Department> listdepartments = new ArrayList<>();
        //querynya
        String query = "SELECT * FROM departments";
        //logic jdbc

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Department d = new Department(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
                listdepartments.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listdepartments;
    }

    @Override
    public boolean insert(Department d) {
         boolean result = false;

        String query = "INSERT INTO departments(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, d.getDepartmentID());
            preparedStatement.setString(2, d.getDepartmentName());
            preparedStatement.setString(3, d.getManagerID());
            preparedStatement.setString(4, d.getLocationID());
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Department d) {
         boolean result = false;
        String query = "UPDATE `departments` SET `DEPARTMENT_NAME` = ?, `MANAGER_ID` = ?, `LOCATION_ID` = ?"
                + " WHERE `departments`.`DEPARTMENT_ID` = ?;";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, d.getDepartmentID());
            preparedStatement.setString(2, d.getDepartmentName());
            preparedStatement.setString(3, d.getManagerID());
            preparedStatement.setString(4, d.getLocationID());
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;    
    }

    @Override
    public boolean delete(String departmentID) {
        boolean result = false;
        String query = "DELETE FROM departments WHERE departments.department_id = ?;";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, departmentID);
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Department> search(String departmentID) {
//        Test yahu = new Test();

        String searchName = departmentID;

        String query = "select * from departments where department_id like '%" + searchName + "%'";
        List<Department> listdepartments = new ArrayList<Department>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Department d = new Department(resultSet.getString(1), resultSet.getString(2), 
                        resultSet.getString(3), resultSet.getString(4));
                listdepartments.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdepartments;
        }    
}