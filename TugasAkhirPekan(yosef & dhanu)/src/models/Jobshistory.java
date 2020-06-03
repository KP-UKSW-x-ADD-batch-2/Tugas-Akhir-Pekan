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
public class Jobshistory {
    private String startDate;
    private String endDate;
    private String jobID;
    private String departmentID;
    private String employeeID;
    
    public Jobshistory (String startDate, String endDate, String jobID, String departmentID, String employeeID){
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobID = jobID;
        this.departmentID = departmentID;
        this.employeeID = employeeID;
    }
    
    public Jobshistory () {}

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    
}
