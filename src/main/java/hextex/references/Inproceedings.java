/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.references;

import hextex.json.Request;

/**
 *
 * @author omistaja
 */
public class Inproceedings implements Reference {
    private String type;
    private String author;
    private String title;
    private String bookTitle;
    private int year;
    private String key;

    public Inproceedings(String author, String title, String booktitle, int year, String key) {
        this.type = "Inproceedings";
        this.author = author;
        this.title = title;
        this.bookTitle = booktitle;
        this.year = year;
        this.key = key;
    }

    public Inproceedings(Request req) {
        this(req.getSingleAuthor(), req.getTitle(), req.getBookTitle(), req.getYear(),
                req.getKey());
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String getType() {
        return type;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setBookTitle(String newBookTitle) {
        bookTitle = newBookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setYear(int newYear) {
        year = newYear;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getBibtexName() {
        return "@inproceedings{" + key + ",\n"
                + "    author = {" + author + "},\n"
                + "    title = {" + title + "},\n"
                + "    booktitle = {" + bookTitle + "},\n"
                + "    year = {" + year + "},\n"
                + "}\n";
    }

    @Override
    public String getEasyName() {
        return "Inproceedings: (reference: " + key + ", author: " + author + ", title:"
                + title + ", book title: " + bookTitle + ", year: " + year + ")";
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
