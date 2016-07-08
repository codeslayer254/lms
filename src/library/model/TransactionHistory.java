/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author yedideya
 */

//
public class TransactionHistory implements Serializable{
    
    private long id;
    private String title;
    private String author;
    private String status;
    private Date dateBorrowed;
    private Date dateReturned;
    private String isbn;
    private long librarian;

    public TransactionHistory(){
        
    }
    
     public TransactionHistory(String title, String author, String status, String isbn, long librarian) {
        this.title = title;
        this.author = author;
        this.status = status;
        this.isbn = isbn;
        this.librarian = librarian;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(Date dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public long getLibrarian() {
        return librarian;
    }

    public void setLibrarian(long librarian) {
        this.librarian = librarian;
    }
    
    
}
