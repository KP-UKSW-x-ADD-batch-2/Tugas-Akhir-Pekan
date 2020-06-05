/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author Yosef Febrianes
 */
public interface IRegionController {

    public List<Region> getAll();

    public String insert(Region r);

    public String update(Region r);

    public String delete(String regionId);

    public List<Region> search(String regionId);
}
