/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Country;
import models.Department;

/**
 *
 * @author User
 */
public interface ICountryDao {
    public List<Country> getAll();
    public boolean insert (Country c);
    public boolean update (Country c);
    public boolean delete (String countryID);
    public List<Country> search (String countryID);
}
