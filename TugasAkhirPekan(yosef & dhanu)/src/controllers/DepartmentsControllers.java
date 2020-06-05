/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.mysql.jdbc.Connection;
import controllers.icontrollers.IDepartmentsControllers;
import daos.DepartmentDao;
import java.util.List;
import javax.swing.JOptionPane;
import models.Department;
import daos.idaos.IDepartmentDao;

/**
 *
 * @author User
 */
public class DepartmentsControllers implements IDepartmentsControllers{
    private IDepartmentDao idepdao;
    public DepartmentsControllers (Connection connection) {
        idepdao =  new DepartmentDao(connection);
    }
    
    @Override
    public List<Department> getAll() {
        if (idepdao.getAll().isEmpty()) {
            System.out.println("Data yang dicari kosong");
            return null;
        } else {
            getAll();
        }
        return idepdao.getAll();
    }

    @Override
    public String insert(Department d) {
        String result;
        Department departments = new Department(d.getDepartmentID(), d.getDepartmentName(), d.getManagerID(), d.getLocationID());
        if (idepdao.insert(d)) {
            result = "Data berhasil ditambah";
        } else  {
            result = "Data gagal ditambah";
        }
        return result;
    }

    @Override
    public String update(Department d) {
       Department departments = new Department(d.getDepartmentID(), d.getDepartmentName(), 
               d.getManagerID(), d.getLocationID());
       String result;
        if (idepdao.update(d)) {
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } else {
            JOptionPane.showMessageDialog(null, "Data gagal Diubah");
        }
        return null;
    }

    @Override
    public String delete(String departmentID) {
        String result;
         Department departments = new Department();
         if (idepdao.delete(departmentID)) {
             result = "Data berhasil dihapus";
        } else {
             result = "Data gagal dihapus";
         }
         return result;
    }

    @Override
    public List<Department> search(String departmentsID) {
       Department departments = new Department();
         if (idepdao.search(departmentsID).isEmpty()) {
             System.out.println("Data berhasil dihapus");
        } else {
             System.out.println("Data gagal dihapus");
         }
         return null;   
    }
}
