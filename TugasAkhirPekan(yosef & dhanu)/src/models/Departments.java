/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
public class Departments {
    private String departmentID;
    private String departmentName;
    private String managerID;
    private String locationID;
    
    public Departments(String departmentID, String departmentName, String managerID, String locationID){
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.managerID = managerID;
        this.locationID = locationID;
    }

    public Departments() {}

    public Departments(String text) {}

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }
    
}
