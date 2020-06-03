/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Departments;

/**
 *
 * @author User
 */
public interface IDepartmentsControllers {
    public List<Departments> getAll();
    public String insert(Departments d);
    public String update(Departments d);
    public String delete(String departmentsId);
    public List<Departments> search(String departmentsId);
}
