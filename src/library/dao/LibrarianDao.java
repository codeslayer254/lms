/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library.dao;

import library.model.Users;
import java.sql.ResultSet;

/**
 *
 * @author rmeyo
 */
public class LibrarianDao extends BaseDao{
    
    public LibrarianDao() {
        super();
    }
    
    public void save(Users user) throws Exception {
        StringBuilder query = new StringBuilder();
        
        user.setRole("LIBRARIAN");
        query = query.append("INSERT INTO USERS ")
                .append("(FIRSTNAME, LASTNAME, USERNAME, PASSWORD, EMAIL, ROLE, IMAGE) ")
                .append("VALUES(")
                .append("'" + user.getFirstName() + "',")
                .append("'" + user.getLastName() + "',")
                .append("'" + user.getUsername()+ "',")
                .append("'" + user.getPassword()+ "',")
                .append("'" + user.getEmail() + "',")
                .append("'" + user.getRole()+ "',")
                .append("'" + user.getImage() + "'")
                .append(")");
        insert(query.toString());
    }
    
    public void delete(Users user)throws Exception{
        StringBuilder query = new StringBuilder();
        
        query = query.append("DELETE FROM `users` WHERE `USER_ID` = " + user.getId());
        
        insert(query.toString());
    }
    
    public void update(Users user)throws Exception{
        StringBuilder query = new StringBuilder();
        
        query = query.append(
        "UPDATE `users`" + "SET `FIRSTNAME` = '" + user.getFirstName() + "' , `LASTNAME` = '" 
        + user.getLastName() + "' , `USERNAME` = '" + user.getUsername() + "' , `PASSWORD` = '" + user.getPassword()
        + "' , `EMAIL` = '" + user.getEmail() 
        + "' WHERE " + "`USER_ID` = '" + user.getId() + "'");

        insert(query.toString());
    }
    
     public Users findLibrarianById(long userID) throws Exception{
        StringBuilder query = new StringBuilder();
        Users librarian = null;
       
         
        query = query.append("SELECT * FROM USERS WHERE USER_ID = '" + userID + "'");
        ResultSet rs = select(query.toString());
        
        while(rs.next()){
            librarian = new Users();
            librarian.setId(rs.getLong("USER_ID"));
            librarian.setFirstName(rs.getString("FIRSTNAME"));
            librarian.setLastName(rs.getString("LASTNAME"));
            librarian.setUsername(rs.getString("USERNAME"));
            librarian.setPassword(rs.getString("PASSWORD"));
            librarian.setEmail(rs.getString("EMAIL"));
        }
        
        return librarian;
    }
     
      public Users findLibrarian(String userName) throws Exception{
        StringBuilder query = new StringBuilder();
        Users librarian = null;
       
         
        query = query.append("SELECT * FROM USERS WHERE USERNAME = '" + userName + "'");
        ResultSet rs = select(query.toString());
        
        while(rs.next()){
            librarian = new Users();
            librarian.setId(rs.getLong("USER_ID"));
            librarian.setFirstName(rs.getString("FIRSTNAME"));
            librarian.setLastName(rs.getString("LASTNAME"));
            librarian.setUsername(rs.getString("USERNAME"));
            librarian.setPassword(rs.getString("PASSWORD"));
            librarian.setEmail(rs.getString("EMAIL"));
        }
        
        return librarian;
    }
      
    public Users findLibrarian(String userName, String firstName, String lastname) throws Exception{
        StringBuilder query = new StringBuilder();
        Users librarian = null;
       
         
        query = query.append("SELECT * FROM USERS WHERE FRISTNAME = '" + firstName + "'");
        ResultSet rs = select(query.toString());
        
        while(rs.next()){
            librarian = new Users();
            librarian.setId(rs.getLong("USER_ID"));
            librarian.setFirstName(rs.getString("FIRSTNAME"));
            librarian.setLastName(rs.getString("LASTNAME"));
            librarian.setUsername(rs.getString("USERNAME"));
            librarian.setPassword(rs.getString("PASSWORD"));
            librarian.setEmail(rs.getString("EMAIL"));
        }
        
        return librarian;
    }
     
             
    public Users findLibrarianByUserName( String username) throws Exception{
        StringBuilder query = new StringBuilder();
        Users librarian = null;
       
         
        query = query.append("SELECT * FROM USERS WHERE USERNAME = '" + username + "'");
        ResultSet rs = select(query.toString());
        
        while(rs.next()){
            librarian = new Users();
            librarian.setId(rs.getLong("USER_ID"));
            librarian.setFirstName(rs.getString("FIRSTNAME"));
            librarian.setLastName(rs.getString("LASTNAME"));
            librarian.setUsername(rs.getString("USERNAME"));
            librarian.setPassword(rs.getString("PASSWORD"));
            librarian.setEmail(rs.getString("EMAIL"));
            
            
        }
        
        return librarian;
    }
    
}
