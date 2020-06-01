/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.EmployeeModel;

/**
 *
 * @author Yosef Febrianes
 */
public interface IEmployeeController {

    public List<EmployeeModel> getAll();

    public String insert(EmployeeModel e);

    public String update(EmployeeModel e);

    public String delete(String employeeId);

    public List<EmployeeModel> search(String employeeId);
}
