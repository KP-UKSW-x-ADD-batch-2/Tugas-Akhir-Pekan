/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mysql.jdbc.Connection;
import controllers.icontrollers.IJobsControllers;
import daos.JobDao;
import java.util.List;
import javax.swing.JOptionPane;
import models.Job;
import daos.idaos.IJobDao;

/**
 *
 * @author User
 */
public class JobsControllers implements IJobsControllers {
    private IJobDao ijbsdao;
    
    public JobsControllers (Connection connection) {
        ijbsdao = new JobDao(connection);
    }

    @Override
    public List<Job> getAll() {
        if (ijbsdao.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Data Kosong");
            return null;
        } else {
            System.out.println(ijbsdao.getAll());
        }
        return null;    
    }

    @Override
    public String insert(Job j) {
        Job jobs = new Job(j.getJobID(), j.getJobTitle(), j.getMinSalary(), j.getMaxSalary());
        if (ijbsdao.insert(j)) {
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } else  {
            JOptionPane.showMessageDialog(null, "Data gagal ditambah");
        }
        return null;    
    }

    @Override
    public String update(Job j) {
        Job jobs = new Job(j.getJobID(), j.getJobTitle(), j.getMinSalary(), j.getMaxSalary());
        if (ijbsdao.update(j)) {
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } else {
            JOptionPane.showMessageDialog(null, "Data gagal Diubah");
        }
        return null;    
    }

    @Override
    public String delete(String jobId) {
         Job jobs = new Job();
         if (ijbsdao.delete(jobId)) {
             JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } else {
             JOptionPane.showMessageDialog(null, "Data gagal dihapus");
         }
         return null;    
    }

    @Override
    public List<Job> search(String jobId) {
        Job jobs = new Job();
         if (ijbsdao.search(jobId).isEmpty()) {
             JOptionPane.showMessageDialog(null, "Data ditemukan");
        } else {
             JOptionPane.showMessageDialog(null, "Data tidak ada");
         }
         return null;    
    }
    
}
