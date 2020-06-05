/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mysql.jdbc.Connection;
import controllers.icontrollers.IJobshistoryControllers;
import daos.JobshistoryDao;
import java.util.List;
import javax.swing.JOptionPane;
import models.Jobshistory;
import daos.idaos.IJobshistoryDao;

/**
 *
 * @author User
 */
public class JobshistoryControllers implements IJobshistoryControllers{
    private IJobshistoryDao ijhdao;
    
    public JobshistoryControllers (Connection connection) {
        ijhdao = new JobshistoryDao(connection);
    }
    
    @Override
    public List<Jobshistory> getAll() {
        if (ijhdao.getAll().isEmpty()) {
            System.out.println("Data Kosong");
            return null;
        } else {
            System.out.println(ijhdao.getAll());
        }
        return null;    }

    @Override
    public String insert(Jobshistory jh) {
        String result;
        Jobshistory jobshistory = new Jobshistory(jh.getStartDate(), jh.getEndDate(), jh.getJobID(), 
                jh.getDepartmentID(), jh.getEmployeeID());
        if (ijhdao.insert(jh)) {
            result = "Data berhasil dihapus";
        } else  {
            result = "Data gagal dihapus";
        }
        return result;        }

    @Override
    public String update(Jobshistory jh) {
       Jobshistory jobshistory = new Jobshistory(jh.getStartDate(), jh.getEndDate(), jh.getJobID(), 
                jh.getDepartmentID(), jh.getEmployeeID());
       String result;
        if (ijhdao.update(jh)) {
            result = "Data Berhasil Diubah";
        } else {
            result = "Data gagal Diubah";
        }
        return result;    }

    @Override
    public String delete(String employeeId) {
        String result;
         Jobshistory jobs = new Jobshistory();
         if (ijhdao.delete(employeeId)) {
             result = "Data berhasil dihapus";
        } else {
             result = "Data gagal dihapus";
         }
         return result;    
    }

    @Override
    public List<Jobshistory> search(String employeeId) {
        Jobshistory jobshistory = new Jobshistory();
         if (ijhdao.search(employeeId).isEmpty()) {
             System.out.println("Data berhasil dihapus");
        } else {
             System.out.println("Data gagal dihapus");
         }
         return null;    }
    
}
