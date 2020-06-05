/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Location;
/**
 *
 * @author Yosef Febrianes
 */
public interface ILocationController {
        public List<Location> getAll();

    public String insert(Location r);

    public String update(Location r);

    public String delete(String locationId);

    public List<Location> search(String locationId);
}
