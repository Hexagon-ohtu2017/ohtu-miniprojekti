
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.references.Article;
import hextex.references.Inproceedings;
import hextex.service.KeyMaker;

public class CreateInproceedingsCommand implements Command {

    private InMemoryReferenceDao dao;
    private IO io;
    private KeyMaker keyMaker;

    public CreateInproceedingsCommand(InMemoryReferenceDao dao, IO io, KeyMaker keyMaker) {
        this.dao = dao;
        this.io = io;
        this.keyMaker = keyMaker;
    }

    @Override
    public void run() {
        Inproceedings inproceedings = createInproceedings();
        dao.add(inproceedings);
        io.print("Inproceedings was succesfully created!");
    }

    private Inproceedings createInproceedings() {
        String author = io.readAuthors("Inproceeding's author(s) (format: 'Lastname Firstname, Lastname Firstname...'):");
        String title = io.readLine("Inproceeding's title:");
        String bookTitle = io.readLine("Inproceedings' book's title:");
        int year = io.readInt("Year of publishing:");
        String key = keyMaker.generateKey(author, year);
        return new Inproceedings(author, title, bookTitle, year, key);
    }

}
