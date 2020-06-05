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
import models.Job;
import models.Jobshistory;
import daos.idaos.IJobshistoryDao;


/**
 *
 * @author User
 */
public class JobshistoryDao implements IJobshistoryDao {
    private Connection connection;
    
    public JobshistoryDao() {
        this.connection = connection;
}

    public JobshistoryDao(Connection connection) {}

    public List<Jobshistory> getAll() {
         List<Jobshistory> listjobshistory = new ArrayList<>();
        //querynya
        String query = "SELECT * FROM jobs_history";
        //logic jdbc

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Jobshistory jh = new Jobshistory(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5));
                listjobshistory.add(jh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listjobshistory;        }

    public boolean insert(Jobshistory jh) {
        boolean result = false;

        String query = "INSERT INTO `jobs_history` (`START_DATE`, `END_DATE`, `JOB_ID`, `DEPARTMENT_ID`, 'EMPLOYEE_ID') "
                + "VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, jh.getStartDate());
            preparedStatement.setString(2, jh.getEndDate());
            preparedStatement.setString(3, jh.getJobID());
            preparedStatement.setString(4, jh.getDepartmentID());
            preparedStatement.setString(5, jh.getEmployeeID());
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;    }

    public boolean update(Jobshistory jh) {
         boolean result = false;
         String query = "UPDATE `countries` SET `START_DATE` = ?, `END_DATE` = ?, `JOB_ID` = ?, `DEPARTMENT_ID` = ?, `EMPLOYEE_ID` = ?"
                 + " WHERE `countries`.`COUNTRY_ID` = 'C005';";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, jh.getStartDate());
            preparedStatement.setString(2, jh.getEndDate());
            preparedStatement.setString(3, jh.getJobID());
            preparedStatement.setString(4, jh.getDepartmentID());
            preparedStatement.setString(5, jh.getEmployeeID());
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(String employeeID) {
        boolean result = false;
        String query = "DELETE FROM `jobs_history` WHERE `jobs_history`.`EMPLOYEE_ID` = ?";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, employeeID);
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;    }

    public List<Jobshistory> search(String employeeID) {
//        Test test = new Test();

        String searchName = employeeID;

        String query = "select * from jobs_history where employee_id like '%" + searchName + "%'";
        List<Jobshistory> listjobshistory = new ArrayList<Jobshistory>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Jobshistory jh = new Jobshistory(resultSet.getString(1), resultSet.getString(2), 
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                listjobshistory.add(jh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listjobshistory;    }    
}
