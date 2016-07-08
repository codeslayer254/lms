/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class BaseDao {
    
    public Connection openConnection() {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/library", "root","");
        }catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public ResultSet select(String sql) throws Exception {
        System.out.println(sql);
        
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        return result; 
    }
    
    public int insert(String sql) throws Exception {
        System.out.println(sql);
        
        Connection connection = openConnection();
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(sql);
        connection.close();
        
        return result; 
    }
}
