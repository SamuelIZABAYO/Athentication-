/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Registration;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author IZABAYO.S The Crushing Architect
 */
public class registrationcontroller extends DbConnection{
    PreparedStatement prep = null;
    Statement stat = null;
    
    public void createtable(){
  
        try {
            getcon();
            stat = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Registration("
                    + "Firstname varchar(50) not null,"
                    + "Lastname varchar(50) not null ,"
                    + "Username varchar(50) not null ,"
                    + "Password varchar(50) not null ,"
                    + "Repassword varchar(50) not null,"
                    + "Salt varchar(50) not null,"
                    + "Address varchar(50) not null);";
            
            stat.executeUpdate(sql);
            stat.close();
            con.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void insert(Registration registration){
    createtable();
    getcon();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Registration Values(?,?,?,?,?,?,?)");
            ps.setString(1,registration.getFirstname());
            ps.setString(2,registration.getLastname());
            ps.setString(3,registration.getUsername());
            ps.setString(4,registration.getPassword());
            ps.setString(5,registration.getRepassword());
            ps.setBytes(6,registration.getSalt());
            ps.setString(7,registration.getAddress());
            
            if(!registration.getPassword().equals(registration.getRepassword())){
            JOptionPane.showMessageDialog(null,"Wrong input");
            }
            
         ps.executeUpdate();
            ps.close();
            con.close();
            JOptionPane.showMessageDialog(null," INFORMATION SAVED SUCCESSFULLY");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Wrong input");

        }
    }
}

