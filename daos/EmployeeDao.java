/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import daos.idaos.IEmployeeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.EmployeeModel;
import models.LocationModel;
import tests.EmployeeTest;

/**
 *
 * @author Yosef Febrianes
 */
public class EmployeeDao implements IEmployeeDao {

    private Connection connection;

    public EmployeeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<EmployeeModel> getAll() {
        List<EmployeeModel> listEmployee = new ArrayList<>();
        String query = "SELECT * FROM employees";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EmployeeModel e = new EmployeeModel(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
                        resultSet.getString(9), resultSet.getString(10), resultSet.getString(11));
                listEmployee.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listEmployee;
    }

    @Override
    public boolean insert(EmployeeModel e) {
        boolean result = false;

        String query = "INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commision_pct, manager_id, departement_id) VALUES (?,?,?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, e.getEmployeeId());
            preparedStatement.setString(2, e.getFirstName());
            preparedStatement.setString(3, e.getLastName());
            preparedStatement.setString(4, e.getEmail());
            preparedStatement.setString(5, e.getPhoneNumber());
            preparedStatement.setString(6, e.getHireDate());
            preparedStatement.setString(7, e.getJobId());
            preparedStatement.setString(8, e.getSalary());
            preparedStatement.setString(9, e.getCommisionPct());
            preparedStatement.setString(10, e.getManagerId());
            preparedStatement.setString(11, e.getDepartementId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(EmployeeModel e) {

        boolean result = false;

        String query = "UPDATE `employees` SET `first_name` = ?, `last_name` = ?, `email` = ?, `phone_number` = ?, `hire_date` = ?, `job_id` = ?, `salary` = ?, `commision_pct` = ?, `manager_id` = ?, `departement_id` = ? WHERE `employees`.`employee_id` = ?;";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, e.getFirstName());
            preparedStatement.setString(2, e.getLastName());
            preparedStatement.setString(3, e.getEmail());
            preparedStatement.setString(4, e.getPhoneNumber());
            preparedStatement.setString(5, e.getHireDate());
            preparedStatement.setString(6, e.getJobId());
            preparedStatement.setString(7, e.getSalary());
            preparedStatement.setString(8, e.getCommisionPct());
            preparedStatement.setString(9, e.getManagerId());
            preparedStatement.setString(10, e.getDepartementId());
            preparedStatement.setString(11, e.getEmployeeId());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;

    }

    @Override
    public boolean delete(String employeeId) {
        boolean result = false;

        String query = "DELETE  FROM employees WHERE employees.employee_id = ?;";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, employeeId);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<EmployeeModel> search(String employeeId) {
        List<EmployeeModel> listEmployee = new ArrayList<EmployeeModel>();
        String query = "select * from employees where employee_id like '%" + employeeId + "%'";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EmployeeModel e = new EmployeeModel(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
                        resultSet.getString(9), resultSet.getString(10), resultSet.getString(11));
                listEmployee.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listEmployee;
    }

}
