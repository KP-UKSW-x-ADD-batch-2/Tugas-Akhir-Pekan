/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Jobshistory;

/**
 *
 * @author User
 */
public interface IJobshistoryControllers {
    public List<Jobshistory> getAll();
    public String insert(Jobshistory jh);
    public String update(Jobshistory jh);
    public String delete(String employeeId);
    public List<Jobshistory> search(String employeeId);
}
