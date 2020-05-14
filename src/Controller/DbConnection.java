/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;


/**
 *
 * @author IZABAYO.S The Crushing Architect
 */
public class DbConnection {
    Connection con = null;
    public Connection getcon(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
           e.getMessage();
        }
        try {
            String url = "jdbc:postgresql://localhost:5432/Software_Security";
            String user = "postgres";
            String password = "12";
            
            con = DriverManager.getConnection(url, user, password);
         
        } catch (SQLException e) {
            
        }
    return con;
    }
}
