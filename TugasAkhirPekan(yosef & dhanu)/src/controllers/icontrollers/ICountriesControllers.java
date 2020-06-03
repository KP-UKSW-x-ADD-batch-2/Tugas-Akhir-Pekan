/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.icontrollers;

import java.util.List;
import models.Countries;

/**
 *
 * @author User
 */
public interface ICountriesControllers {
    public List<Countries> getAll();
    public String insert(Countries c);
    public String update(Countries c);
    public String delete(String countryId);
    public List<Countries> search(String countryId);
}
