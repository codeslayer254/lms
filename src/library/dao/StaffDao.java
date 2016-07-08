/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library.dao;

import library.model.Users;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class StaffDao extends BaseDao{
    
    public StaffDao() {
        super();
    }
    
    public void save(Users user) throws Exception {
        StringBuilder query = new StringBuilder();
        
        query = query.append("INSERT INTO USERS ")
                .append("(USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ROLE, IMAGE) ")
                .append("VALUES(")
                .append("'" + user.getUsername()+ "',")
                .append("'" + user.getPassword()+ "',")
                .append("'" + user.getFirstName()+ "',")
                .append("'" + user.getLastName()+ "',")
                .append("'" + user.getEmail()+ "',")
                .append("'" + user.getRole()+ "',")
                .append("'" + user.getImage()+ "'")
                .append(")");
        insert(query.toString());
    }
    
    public void delete(Users user)throws Exception{
        StringBuilder query = new StringBuilder();
        
        query = query.append("DELETE FROM `users` WHERE `STAFF_ID` = " + user.getId());
        
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
    
    public List<Users> getAllStaff() throws Exception{
        StringBuilder query = new StringBuilder();
        List<Users> listOfStaff = new ArrayList<Users>();
        
        query = query.append("SELECT * FROM USERS WHERE ROLE = 'ADMIN'");
        ResultSet rs = select(query.toString());
        
        while(rs.next()){
            Users users = new Users();
            users.setId(rs.getLong("USER_ID"));
            users.setUsername(rs.getString("USERNAME"));
            users.setPassword(rs.getString("PASSWORD"));
            
            listOfStaff.add(users);
        }
        
        return listOfStaff;
    }
    
     public Users loginStaff(String username, String password) throws Exception{
        StringBuilder query = new StringBuilder();
        Users staffUser = null;
       
         
        query = query.append("SELECT * FROM USERS WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'");
        ResultSet rs = select(query.toString());
        
        while(rs.next()){
            staffUser = new Users();
            staffUser.setId(rs.getLong("USER_ID"));
            staffUser.setUsername(rs.getString("USERNAME"));
            staffUser.setPassword(rs.getString("PASSWORD"));
            
        }
        
        return staffUser;
    }
     
 public Users findStaffById(long userID) throws Exception{
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
}
