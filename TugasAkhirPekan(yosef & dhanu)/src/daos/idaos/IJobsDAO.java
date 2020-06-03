/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Jobs;

/**
 *
 * @author User
 */
public interface IJobsDAO {
    public List<Jobs> getAll();
    public boolean insert(Jobs j);
    public boolean update(Jobs j);
    public boolean delete(String jobsID);
    public List<Jobs> search(String jobsID);
}
