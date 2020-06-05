/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Department;

/**
 *
 * @author User
 */
public interface IDepartmentsControllers {
    public List<Department> getAll();
    public String insert(Department d);
    public String update(Department d);
    public String delete(String departmentsId);
    public List<Department> search(String departmentsId);
}
