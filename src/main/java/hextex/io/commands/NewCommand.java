/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.io.WriteBibTeX;
import hextex.references.Article;
import hextex.references.Book;
import hextex.references.Inproceedings;
import hextex.references.Reference;
import hextex.service.KeyMaker;
import java.util.HashMap;

public class NewCommand implements Command {

    private IO io;
    private InMemoryReferenceDao dao;
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private KeyMaker keyMaker;

    public NewCommand(IO io, InMemoryReferenceDao dao, KeyMaker keyMaker) {
        this.io = io;
        this.dao = dao;
        this.keyMaker = keyMaker;

        commands.put("book", new CreateBookCommand(dao, io, keyMaker));
        commands.put("article", new CreateArticleCommand(dao, io, keyMaker));
        commands.put("inproceedings", new CreateInproceedingsCommand(dao, io, keyMaker));
    }

    @Override
    public void run() {
        while (true) {
            io.print("Create a new reference!");
            String command = io.readLine("Select type : [book] [article] [inproceedings] or return: [back]");

            if (command.equals("back")) {
                return;
            }

            if (commands.containsKey(command)) {
                commands.get(command).run();
            }
        }
    }

}
