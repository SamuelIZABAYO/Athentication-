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
public class logincontroller extends DbConnection{

       PreparedStatement prep = null;
   Statement stalo = null;
   
   public void createtable(){

       try {
           getcon();
    stalo = con.createStatement();
    
     String sql = "CREATE TABLE IF NOT EXISTS Login("
                    + "Username varchar(50) not null ,"
                    + "Password varchar(50) not null);";
     
     stalo.executeUpdate(sql);
     stalo.close();
     con.close();

       } catch (SQLException e) {
           
       }
   }
    
}
