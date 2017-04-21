package hextex.json;

import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("type")
    private String type;
    
    @SerializedName("author")
    public String singleAuthor;
    
    @SerializedName("title")
    public String title;
    
    @SerializedName("year")
    public int year;
    
    @SerializedName("publisher")
    public String publisher;
    
    @SerializedName("key")
    private String key;

    public Request(String type, String singleAuthor, String title, int year, String publisher, String key) {
        this.type = type;
        this.singleAuthor = singleAuthor;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.key = key;
    }
    
    public String getType() {
        return type;
    }

    public String getSingleAuthor() {
        return singleAuthor;
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

    public void setSingleAuthor(String singleAuthor) {
        this.singleAuthor = singleAuthor;
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
