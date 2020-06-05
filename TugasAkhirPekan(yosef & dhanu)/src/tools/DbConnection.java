/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

//import java.sql.Connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Yosef Febrianes
 */
public class DbConnection {
    private Connection con;
    
    public Connection getConnection(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = (Connection) DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/tugas3?zeroDateTimeBehavior=convertToNull","root","");
        } catch (Exception e) {
            System.out.println("Error = "+e);
        }
 
    return con;
    }

}
