/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Jobs;

/**
 *
 * @author User
 */
public interface IJobsControllers {
    public List<Jobs> getAll();
    public String insert(Jobs j);
    public String update(Jobs j);
    public String delete(String jobId);
    public List<Jobs> search(String jobId);
}
