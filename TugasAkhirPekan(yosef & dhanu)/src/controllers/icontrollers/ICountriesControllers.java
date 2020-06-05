/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Country;

/**
 *
 * @author User
 */
public interface ICountriesControllers {
    public List<Country> getAll();
    public String insert(Country c);
    public String update(Country c);
    public String delete(String countryId);
    public List<Country> search(String countryId);
}
