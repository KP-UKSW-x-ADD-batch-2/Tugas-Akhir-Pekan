/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.icontrollers.IEmployeeController;
import daos.EmployeeDao;
import daos.idaos.IEmployeeDao;
import java.sql.Connection;
import java.util.List;
import models.EmployeeModel;

/**
 *
 * @author Yosef Febrianes
 */
public class EmployeeController implements IEmployeeController {

    private IEmployeeDao iedao;

    public EmployeeController(Connection connection) {
        iedao = new EmployeeDao(connection);
    }

    @Override
    public List<EmployeeModel> getAll() {
        if (iedao.getAll().isEmpty()) {
            System.out.println("Data yang dicari kosong");
            return null;
        } else {
            getAll();
        }
        return iedao.getAll();
    }

    @Override
    public String insert(EmployeeModel e) {
        String result;
        EmployeeModel employee = new EmployeeModel(e.getEmployeeId(), e.getFirstName(), e.getLastName(), e.getEmail(), e.getPhoneNumber(), e.getHireDate(), e.getJobId(), e.getSalary(), e.getCommisionPct(), e.getManagerId(), e.getDepartementId());
        if (iedao.insert(employee)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(EmployeeModel e) {
        String result;
        EmployeeModel employee = new EmployeeModel();
        employee.getEmployeeId();
        employee.getFirstName();
        employee.getLastName();
        employee.getEmail();
        employee.getPhoneNumber();
        employee.getHireDate();
        employee.getJobId();
        employee.getSalary();
        employee.getCommisionPct();
        employee.getManagerId();
        employee.getDepartementId();

        if (iedao.update(e)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(String employeeId) {
        String result;
        EmployeeModel employee = new EmployeeModel();
        employee.getEmployeeId();
        if (iedao.delete(employeeId)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Data gagal dihapus";
        }
        return result;
    }

    @Override
    public List<EmployeeModel> search(String employeeId) {
        String result;
        if (iedao.search(employeeId).isEmpty()) {
            System.out.println("Data yang dicari kosong");
            result = "Data tidak ditemukan";
            return null;
        } else {
            search(employeeId);
            result = "Data ditemukan";
        }
        return iedao.search(employeeId);

    }

}
