/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.references;

/**
 *
 * @author omistaja
 */
public class Inproceeding implements Reference{

    private String nameOfReference;
    private String author;
    private String title;
    private String bookTitle;
    private int year;
    
    public Inproceeding(String name, String author, String title , String booktitle, int year) {
        this.nameOfReference = name;
        this.author = author;
        this.title = title;
        this.bookTitle = booktitle;
        this.year = year;
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
    public void setName(String name) {
        nameOfReference = name;
    }
    
    public void setYear(int newYear) {
        year = newYear;
    }
    
    public int getYear() {
        return year;
    }
    @Override
    public String getName() {
        return nameOfReference;
    }

    @Override
    public String getBibtexName() {
                return "@article{" + nameOfReference + ",\n"
                + "author = {" + author + "},\n"
                + "title = {" + title + "},\n"
                + "booktitle = {" + bookTitle + "},\n"      
                + "year = {" + year + "},\n"
                + "}\n";
    }
    
}
