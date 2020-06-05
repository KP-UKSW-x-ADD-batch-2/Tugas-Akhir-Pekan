/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author Yosef Febrianes
 */
public interface IRegionDao {

    public List<Region> getAll();

    public boolean insert(Region r);

    public boolean update(Region r);

    public boolean delete(String regionId);

    public List<Region> search(String regionId);

//    public boolean Delete(String regionId);
}
