/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.LocationModel;
/**
 *
 * @author Yosef Febrianes
 */
public interface ILocationController {
        public List<LocationModel> getAll();

    public String insert(LocationModel r);

    public String update(LocationModel r);

    public String delete(String locationId);

    public List<LocationModel> search(String locationId);
}
