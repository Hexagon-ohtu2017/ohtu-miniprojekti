package hextex.json;

import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("type")
    private String type;

    @SerializedName("author")
    public String author;

    @SerializedName("title")
    public String title;

    @SerializedName("year")
    public int year;

    @SerializedName("publisher")
    public String publisher;

    @SerializedName("journal")
    public String journal;
    
    @SerializedName("volume")
    public int volume;
    
    @SerializedName("pages")
    public String pages;

    @SerializedName("bookTitle")
    public String bookTitle;
    
    @SerializedName("key")
    public String key;

    public Request(String type, String author, String title, int year, String publisher, String journal, int volume, String pages, String bookTitle, String key) {
        this.type = type;
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.journal = journal;
        this.volume = volume;
        this.pages = pages;
        this.bookTitle = bookTitle;
        this.key = key;
    }
    
    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    public String getType() {
        return type;
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

    public String getKey() {
        return key;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setKey(String key) {
        this.key = key;
    }
}
