/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library.model;

import java.io.Serializable;

/**
 *
 * @author 
 */
public class Users implements Serializable{
    
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String password;
    private byte[] image;
    private String username;
    
public Users() {
    
  }

public Users(int _id, String _firstName, String _lastName, 
        String _email, String _role, String _password, byte[] _image, String _username) {
    id = _id;
    firstName = _firstName;
    lastName = _lastName;
    email = _email;
    role = _role;
    password = _password;
    image = _image;
    username = _username;
  }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    
    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getImage() {
        return image;
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    /* * returns random integer between minimum and maximum range */ 
    public int getRandomInteger(int maximum, int minimum)
    { return ((int) (Math.random()*(maximum - minimum))) + minimum; }


    
    public String toString() {
    return id + " - " + firstName + " - " + lastName + " - " + email +  " - " + role + " - " + password +  " - " + image +  " - " + username;
  }
    
}
