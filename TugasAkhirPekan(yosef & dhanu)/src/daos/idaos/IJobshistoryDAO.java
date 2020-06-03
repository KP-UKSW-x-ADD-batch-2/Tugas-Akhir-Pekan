/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Jobs;
import models.Jobshistory;

/**
 *
 * @author User
 */
public interface IJobshistoryDAO {
    public List<Jobshistory> getAll();
    public boolean insert(Jobshistory jh);
    public boolean update(Jobshistory jh);
    public boolean delete(String employeeID);
    public List<Jobshistory> search(String employeeID);
}
