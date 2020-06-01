/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.RegionModel;

/**
 *
 * @author Yosef Febrianes
 */
public interface IRegionDao {

    public List<RegionModel> getAll();

    public boolean insert(RegionModel r);

    public boolean update(RegionModel r);

    public boolean delete(String regionId);

    public List<RegionModel> search(String regionId);

//    public boolean Delete(String regionId);
}
