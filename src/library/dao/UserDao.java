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
import library.model.Admin;
import library.model.Librarian;

/**
 *
 * @author 
 */
public class UserDao extends BaseDao{
    
    public UserDao() {
        super();
    }
    
    public void saveAdmin(Admin admin) throws Exception {
        StringBuilder query = new StringBuilder();
        
        query = query.append("INSERT INTO USERS ")
                .append("(FIRSTNAME, LASTNAME, USERNAME, PASSWORD, ROLE, IMAGE) ")
                .append("VALUES(")
                .append("'" + admin.getFirstName()+ "',")
                .append("'" + admin.getLastName()+ "',")
                .append("'" + admin.getUsername()+ "',")
                .append("'" + admin.getPassword()+ "',")
                .append("admin,")
                .append("'" + admin.getImage()+ "'")
                .append(")");
        insert(query.toString());
    }
    
    public void saveLibrarin(Librarian librarian) throws Exception {
        StringBuilder query = new StringBuilder();
        
        query = query.append("INSERT INTO USERS ")
                .append("(FIRSTNAME, LASTNAME, USERNAME, PASSWORD, ROLE, IMAGE) ")
                .append("VALUES(")
                .append("'" + librarian.getFirstName()+ "',")
                .append("'" + librarian.getLastName()+ "',")
                .append("'" + librarian.getUsername()+ "',")
                .append("'" + librarian.getPassword()+ "',")
                .append("librarian,")
                .append("'" + librarian.getImage()+ "'")
                .append(")");
        insert(query.toString());
    }
    
    
    public void delete(Users user)throws Exception{
        StringBuilder query = new StringBuilder();
        
        query = query.append("DELETE FROM `staff` WHERE `STAFF_ID` = " + user.getId());
        
        insert(query.toString());
    }
    
    public void update(Users user)throws Exception{
        StringBuilder query = new StringBuilder();
        
        query = query.append("UPDATE `staff`"
                + "SET `USERNAME` = '"  + user.getUsername() 
                + "' , `PASSWORD` = '" + user.getPassword() 
                + "' WHERE " + "`STAFF_ID` = '" + user.getId() + "'");

        insert(query.toString());
    }
    
    public List<Users> getAllUsers() throws Exception{
        StringBuilder query = new StringBuilder();
        List<Users> listOfUsers = new ArrayList<Users>();
        
        query = query.append("SELECT * FROM USERS");
        ResultSet rs = select(query.toString());
        
        while(rs.next()){
            Users libUser = new Users();
            libUser.setId(rs.getLong("USER_ID"));
            libUser.setUsername(rs.getString("FIRSTNAME"));
            libUser.setPassword(rs.getString("LASTNAME"));
            libUser.setUsername(rs.getString("ROLE"));
            libUser.setPassword(rs.getString("EMAIL"));
            libUser.setUsername(rs.getString("USERNAME"));
            libUser.setPassword(rs.getString("PASSWORD"));
            
            listOfUsers.add(libUser);
        }
        
        return listOfUsers;
    }
    
     public Users loginUser(String username, String password) throws Exception{
        StringBuilder query = new StringBuilder();
        Users libUser = null;
       
         
        query = query.append("SELECT * FROM USERS WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'");
        ResultSet rs = select(query.toString());
        
        while(rs.next()){
            libUser = new Users();
            libUser.setId(rs.getLong("USER_ID"));
            libUser.setUsername(rs.getString("USERNAME"));
            libUser.setPassword(rs.getString("PASSWORD"));
            libUser.setFirstName(rs.getString("FIRSTNAME"));
            libUser.setLastName(rs.getString("LASTNAME"));
            libUser.setRole(rs.getString("ROLE"));
            libUser.setEmail(rs.getString("EMAIL"));
            
        }
        
        return libUser;
    }
}
