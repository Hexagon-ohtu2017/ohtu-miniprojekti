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
public class Article implements Reference {

    private String nameOfReference;
    private String author;
    private String title;
    private String journal;
    private int volume;
    private String pages;
    private int year;

    public Article(String name, String author, String title, String journal, int volume,
            String pages, int year) {
        this.nameOfReference = name;
        this.author = author;
        this.journal = journal;
        this.volume = volume;
        this.pages = pages;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String newJournal) {
        journal = newJournal;
    }

    public void setVolume(Integer newVolume) {
        volume = newVolume;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setPages(String newPages) {
        pages = newPages;
    }

    public String getPages() {
        return pages;
    }

    public void setYear(int newYear) {
        year = newYear;
    }

    public Integer getYear() {
        return year;
    }

    public void setName(String newName) {
        nameOfReference = newName;
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
                + "journal = {" + journal + "},\n"
                + "volume = {" + volume + "},\n"
                + "pages = {" + pages + "},\n"
                + "year = {" + year + "},\n"
                + "}\n";
    }

    @Override
    public String getEasyName() {
        return "Article: (reference: " + nameOfReference + ", author: " + author + ", title:"
                + title + ", journal: " + journal + ", volume: "
                + volume + ", pages: " + pages + ", year: " + year + ")";
    }

}
