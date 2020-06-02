/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.EmployeeModel;

/**
 *
 * @author Yosef Febrianes
 */
public interface IEmployeeDao {

    public List<EmployeeModel> getAll();

    public boolean insert(EmployeeModel e);

    public boolean update(EmployeeModel e);

    public boolean delete(String employeeId);

    public List<EmployeeModel> search(String employeeId);

}
