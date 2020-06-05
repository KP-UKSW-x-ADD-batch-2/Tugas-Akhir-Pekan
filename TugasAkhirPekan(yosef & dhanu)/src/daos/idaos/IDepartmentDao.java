/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Country;
import models.Department;

/**
 *
 * @author User
 */
public interface IDepartmentDao {
    public List<Department> getAll();
    public boolean insert (Department d);
    public boolean update (Department d);
    public boolean delete (String departmentID);
    public List<Department> search (String departmentID);
}
