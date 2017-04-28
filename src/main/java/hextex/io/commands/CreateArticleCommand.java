
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.references.Article;
import hextex.service.KeyMaker;

public class CreateArticleCommand implements Command {

    private InMemoryReferenceDao dao;
    private IO io;
    private KeyMaker keyMaker;

    public CreateArticleCommand(InMemoryReferenceDao dao, IO io, KeyMaker keyMaker) {
        this.dao = dao;
        this.io = io;
        this.keyMaker = keyMaker;
    }

    @Override
    public void run() {
        Article article = createArticle();
        dao.add(article);
        io.print("Article was succesfully created!");
    }

    private Article createArticle() {
        String author = io.readAuthors("Article's author(s) (format: 'Lastname Firstname, Lastname Firstname...'):");
        String title = io.readLine("Article's title:");
        String journal = io.readLine("Article's journal:");
        int volume = io.readInt("Article's volume:");
        String page = io.readLine("Article's pages:");
        int year = io.readInt("Year of publishing:");
        String key = keyMaker.generateKey(author, year);
        return new Article(author, title, journal, volume, page, year, key);
    }

}
