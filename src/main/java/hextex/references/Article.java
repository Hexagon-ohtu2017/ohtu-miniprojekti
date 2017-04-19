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

    private String author;
    private String title;
    private String journal;
    private int volume;
    private String pages;
    private int year;
    private String key;

    public Article(String author, String title, String journal, int volume,
            String pages, int year, String key) {
        this.author = author;
        this.journal = journal;
        this.volume = volume;
        this.pages = pages;
        this.year = year;
        this.key = key;
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

    @Override
    public String getBibtexName() {
        return "@article{" + key + ",\n"
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
        return "Article: (reference: " + key + ", author: " + author + ", title:"
                + title + ", journal: " + journal + ", volume: "
                + volume + ", pages: " + pages + ", year: " + year + ")";
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
