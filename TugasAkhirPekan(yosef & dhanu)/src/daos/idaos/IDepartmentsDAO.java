/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Countries;
import models.Departments;

/**
 *
 * @author User
 */
public interface IDepartmentsDAO {
    public List<Departments> getAll();
    public boolean insert (Departments d);
    public boolean update (Departments d);
    public boolean delete (String departmentID);
    public List<Departments> search (String departmentID);
}
