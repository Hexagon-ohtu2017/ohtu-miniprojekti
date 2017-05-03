/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.matcher.QueryBuilder;
import hextex.references.Reference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleksisvuoksenmaa
 */
public class FilterCommand implements Command {

    private InMemoryReferenceDao dao;
    private IO io;

    public FilterCommand(IO io, InMemoryReferenceDao dao) {
        this.io = io;
        this.dao = dao;
    }

    @Override
    public void run() {
        String filterString = io.readLineAcceptEmpty("Please enter a string you want to use to filter the references: ");
        if (filterString.isEmpty()) {
            return;
        }
        dao.addFilter(filterString);
        List<Reference> matches = dao.listFiltered();

        io.print("References matching the filter:");
        for (Reference r : matches) {
            io.print("\t" + r.getEasyName());
        }
    }
}
