/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.references;

/**
 *
 * @author cocacoca
 */
public class Book {

    public String nameOfReference;
    public String author;
    public String title;
    public int year;
    public String publisher;

    public Book(String name, String author, String title, int year, String publisher) {
        this.nameOfReference = name;
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
    }

    public void setName(String name) {
        this.nameOfReference = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return nameOfReference;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }
}
