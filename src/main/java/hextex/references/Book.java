package hextex.references;

import hextex.json.Request;

/**
 *
 * @author cocacoca
 */
public class Book implements Reference {

    private String type;
    public String author;
    public String title;
    public int year;
    public String publisher;
    private String key;

    public Book(String author, String title, int year, String publisher, String key) {
        this.type = "Book";
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.key = key;
    }

    public Book(Request req) {
        this(req.getAuthor(), req.getTitle(), req.getYear(),
                req.getPublisher(), req.getKey());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getBibtexName() {
        /*
        For multiple authors in a list. Currently not in use.

        StringBuilder authorsNames = new StringBuilder();
        for (Author author : authors) {
            authorsNames.append(author.getBibtexName()).append(" and ");
        }
        authorsNames.delete(authorsNames.length() - 5, authorsNames.length());
         */

        return "@book{" + key + ",\n"
                + "    author = {" + author + "},\n"
                + "    title = {" + title + "},\n"
                + "    year = {" + year + "},\n"
                + "    publisher = {" + publisher + "},\n"
                + "}\n";
    }

    @Override
    public String getEasyName() {
        return "Book: (reference: " + key + ", author: " + author + ", title:"
                + title + ", year: " + year + ", publisher: " + publisher + ")";
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
