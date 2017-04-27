/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.references.Book;
import hextex.service.KeyMaker;

public class CreateBookCommand implements Command {

    private IO io;
    private KeyMaker keyMaker;
    private InMemoryReferenceDao dao;

    public CreateBookCommand(InMemoryReferenceDao dao, IO io, KeyMaker keyMaker) {
        this.io = io;
        this.keyMaker = keyMaker;
        this.dao = dao;
    }

    @Override
    public void run() {
        Book book = createBook();
        dao.add(book);
        io.print("Book was succesfully created!");
    }

    private Book createBook() {
        String author = io.readAuthors("Book's author(s) (format: 'Lastname Firstname, Lastname Firstname...'):");
        String title = io.readLine("Book's title:");
        int year = io.readInt("Year of publishing:");
        String publisher = io.readLine("Publisher:");
        String key = keyMaker.generateKey(author, year);
        Book created = new Book(author, title, year, publisher, key);
        return created;
    }

}
