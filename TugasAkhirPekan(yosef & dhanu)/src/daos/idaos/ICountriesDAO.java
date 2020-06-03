/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.idaos;

import java.util.List;
import models.Countries;
import models.Departments;

/**
 *
 * @author User
 */
public interface ICountriesDAO {
    public List<Countries> getAll();
    public boolean insert (Countries c);
    public boolean update (Countries c);
    public boolean delete (String countryID);
    public List<Countries> search (String countryID);
}
