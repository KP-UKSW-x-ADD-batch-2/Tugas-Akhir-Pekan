/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.mysql.jdbc.Connection;
import daos.idaos.IJobsDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Jobs;
import tests.Test;

/**
 *
 * @author User
 */
public class JobsDAO implements IJobsDAO{
    
    private Connection connection;
    
    public JobsDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Jobs> getAll() {
        List<Jobs> listJobs = new ArrayList<>();
        //querynya
        String query = "SELECT * FROM jobs";
        //logic jdbc

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Jobs j = new Jobs(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4));
                listJobs.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listJobs;    
    }

    @Override
    public boolean insert(Jobs j) {
         boolean result = false;

        String query = "INSERT INTO `jobs` (`JOB_ID`, `JOB_TITLE`, `MIN_SALARY`, `MAX_SALARY`) "
                + "VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, j.getJobID());
            preparedStatement.setString(2, j.getJobTitle());
            preparedStatement.setString(3, j.getMinSalary());
            preparedStatement.setString(4, j.getMaxSalary());
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }    

    @Override
    public boolean update(Jobs j) {
         boolean result = false;
         String query = "UPDATE `jobs` SET `JOB_TITLE` = ?, `MIN_SALARY` = ?, `MAX_SALARY` = ? WHERE `jobs`.`JOB_ID` = ?;";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, j.getJobTitle());
            preparedStatement.setString(2, j.getMinSalary());
            preparedStatement.setString(3, j.getMaxSalary());
            preparedStatement.setString(4, j.getJobID());
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String jobsID) {
        boolean result = false;
        String query = "DELETE FROM `jobs` WHERE `jobs`.`JOB_ID` = ?";

        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            preparedStatement.setString(1, jobsID);
            preparedStatement.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Jobs> search(String jobsID) {
       Test test = new Test();

        String searchName = jobsID;

        String query = "select * from jobs where job_id like '%" + searchName + "%'";
        List<Jobs> listJobs = new ArrayList<Jobs>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Jobs j = new Jobs(resultSet.getString(1), resultSet.getString(2), 
                        resultSet.getString(3), resultSet.getString(4));
                listJobs.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listJobs;    
    }
    
}
