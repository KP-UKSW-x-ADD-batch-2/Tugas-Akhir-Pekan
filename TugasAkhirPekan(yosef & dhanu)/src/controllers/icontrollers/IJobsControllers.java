/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author User
 */
public interface IJobsControllers {
    public List<Job> getAll();
    public String insert(Job j);
    public String update(Job j);
    public String delete(String jobId);
    public List<Job> search(String jobId);
}
