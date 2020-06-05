/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;
import java.util.List;
import models.Location;

/**
 *
 * @author Yosef Febrianes
 */
public interface ILocationDao {
    
    public List<Location> getAll();

    public boolean insert(Location r);

    public boolean update(Location r);

    public boolean delete(String locationId);

    public List<Location> search(String locationId);
}
