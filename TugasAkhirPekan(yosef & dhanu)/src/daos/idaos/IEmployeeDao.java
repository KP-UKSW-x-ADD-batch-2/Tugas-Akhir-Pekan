/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Employee;

/**
 *
 * @author Yosef Febrianes
 */
public interface IEmployeeDao {

    public List<Employee> getAll();

    public boolean insert(Employee e);

    public boolean update(Employee e);

    public boolean delete(String employeeId);

    public List<Employee> search(String employeeId);

}
