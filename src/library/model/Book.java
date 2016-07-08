/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.model;

import java.io.Serializable;

public class Book implements Serializable {

    private long id;
    private String title;
    private String author;
    private String status;
    private String category;
    private String isbn;
    private byte[] image;
    private long libarianID;

    public Book() {
        super();
    }

    public Book(long id, String title, String author, String status, String category, String isbn, byte[] image, long libarianID) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
        this.category = category;
        this.isbn = isbn;
        this.image = image;
        this.libarianID = libarianID;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getLibarianID() {
        return libarianID;
    }

    public void setLibarianID(long libarianID) {
        this.libarianID = libarianID;
    }
}
