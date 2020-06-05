/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Job;

/**
 *
 * @author User
 */
public interface IJobDao {
    public List<Job> getAll();
    public boolean insert(Job j);
    public boolean update(Job j);
    public boolean delete(String jobsID);
    public List<Job> search(String jobsID);
}
