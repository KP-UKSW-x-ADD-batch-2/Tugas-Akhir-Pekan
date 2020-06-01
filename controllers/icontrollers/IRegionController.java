/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.RegionModel;

/**
 *
 * @author Yosef Febrianes
 */
public interface IRegionController {

    public List<RegionModel> getAll();

    public String insert(RegionModel r);

    public String update(RegionModel r);

    public String delete(String regionId);

    public List<RegionModel> search(String regionId);
}
