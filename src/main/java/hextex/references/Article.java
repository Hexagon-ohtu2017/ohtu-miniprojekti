/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.references;

import hextex.json.Request;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omistaja
 */
public class Article implements Reference {

    private String type;
    private String author;
    private String title;
    private String journal;
    private int volume;
    private String pages;
    private int year;
    private String key;

    public Article(String author, String title, String journal, int volume,
            String pages, int year, String key) {
        this.type = "Article";
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.volume = volume;
        this.pages = pages;
        this.year = year;
        this.key = key;
    }

    public Article(Request req) {
        this(req.getAuthor(), req.getTitle(), req.getJournal(), req.getVolume(),
                req.getPages(), req.getYear(), req.getKey());
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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

    public void setPages(String newPages) {
        pages = newPages;
    }

    public String getPages() {
        return pages;
    }

    public void setYear(int newYear) {
        year = newYear;
    }

    public int getVolume() {
        return volume;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getBibtexName() {
        return "@article{" + key + ",\n"
                + "    author = {" + author + "},\n"
                + "    title = {" + title + "},\n"
                + "    journal = {" + journal + "},\n"
                + "    volume = {" + volume + "},\n"
                + "    pages = {" + pages + "},\n"
                + "    year = {" + year + "},\n"
                + "}\n";
    }

    @Override
    public String getFullName() {
        return "Article " + key + ": (" + author + ", \"" + title + "\""
                + ", journal: " + journal + ", volume: "
                + volume + ", pages: " + pages + ", " + year + ")";
    }
    
    @Override
    public String getEasyName() {
        return "[" + key + "]" + ": " + author + ", \"" + title + "\""
                + ", " + year;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public boolean matchesFilter(String filterString) {
        filterString = filterString.replaceAll("\\s+","").toLowerCase();
        ArrayList<String> fields = this.addAllFields();
        for (String field : fields) {
            if(field.toLowerCase().contains(filterString)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ArrayList<String> addAllFields() {
        ArrayList<String> fields = new ArrayList();
        fields.add(this.author);
        fields.add(this.journal);
        fields.add(this.key);
        fields.add(this.pages);
        fields.add(this.title);
        fields.add(Integer.toString(this.year));
        fields.add(Integer.toString(this.volume));
        return fields;
    }
}
