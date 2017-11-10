/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.springframework.stereotype.Repository;

/**
 *
 * @author yoruk
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private String summary;
    private int ownerid;

    public Book() {
    }
  
    public Book(int id, String title, String author, String summary, int ownerid) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.ownerid = ownerid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }
}
