/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Employee;

/**
 *
 * @author Yosef Febrianes
 */
public interface IEmployeeController {

    public List<Employee> getAll();

    public String insert(Employee e);

    public String update(Employee e);

    public String delete(String employeeId);

    public List<Employee> search(String employeeId);
}
