/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mysql.jdbc.Connection;
import controllers.icontrollers.IJobsControllers;
import daos.JobsDAO;
import daos.idaos.IJobsDAO;
import java.util.List;
import javax.swing.JOptionPane;
import models.Jobs;

/**
 *
 * @author User
 */
public class JobsControllers implements IJobsControllers {
    private IJobsDAO ijbsdao;
    
    public JobsControllers (Connection connection) {
        ijbsdao = new JobsDAO(connection);
    }

    @Override
    public List<Jobs> getAll() {
        if (ijbsdao.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Data Kosong");
            return null;
        } else {
            System.out.println(ijbsdao.getAll());
        }
        return null;    
    }

    @Override
    public String insert(Jobs j) {
        Jobs jobs = new Jobs(j.getJobID(), j.getJobTitle(), j.getMinSalary(), j.getMaxSalary());
        if (ijbsdao.insert(j)) {
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } else  {
            JOptionPane.showMessageDialog(null, "Data gagal ditambah");
        }
        return null;    
    }

    @Override
    public String update(Jobs j) {
        Jobs jobs = new Jobs(j.getJobID(), j.getJobTitle(), j.getMinSalary(), j.getMaxSalary());
        if (ijbsdao.update(j)) {
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } else {
            JOptionPane.showMessageDialog(null, "Data gagal Diubah");
        }
        return null;    
    }

    @Override
    public String delete(String jobId) {
         Jobs jobs = new Jobs();
         if (ijbsdao.delete(jobId)) {
             JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } else {
             JOptionPane.showMessageDialog(null, "Data gagal dihapus");
         }
         return null;    
    }

    @Override
    public List<Jobs> search(String jobId) {
        Jobs jobs = new Jobs();
         if (ijbsdao.search(jobId).isEmpty()) {
             JOptionPane.showMessageDialog(null, "Data ditemukan");
        } else {
             JOptionPane.showMessageDialog(null, "Data tidak ada");
         }
         return null;    
    }
    
}
