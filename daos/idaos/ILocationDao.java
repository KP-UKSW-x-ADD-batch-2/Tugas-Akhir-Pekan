/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;
import java.util.List;
import models.LocationModel;

/**
 *
 * @author Yosef Febrianes
 */
public interface ILocationDao {
    
    public List<LocationModel> getAll();

    public boolean insert(LocationModel r);

    public boolean update(LocationModel r);

    public boolean delete(String locationId);

    public List<LocationModel> search(String locationId);
}
