/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.util.Date;

/**
 *
 * @author meyor
 */
public class Guest extends Users{
    
    private long id;
    private String name;
    private Date datevisited;
    
    public Guest(){
        super();
    }

    public Guest(String name, Date datevisited) {
        
        this.name = name;
        this.datevisited = datevisited;
    }

     public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDatevisited() {
        return datevisited;
    }

    public void setDatevisited(Date datevisited) {
        this.datevisited = datevisited;
    }
    
    
    
    
}
