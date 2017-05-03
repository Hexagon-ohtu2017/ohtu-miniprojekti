/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.matcher.Matcher;
import hextex.matcher.QueryBuilder;
import hextex.references.Reference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleksisvuoksenmaa
 */
public class RemoveFilterCommand implements Command {

    private InMemoryReferenceDao dao;
    private IO io;

    public RemoveFilterCommand(IO io, InMemoryReferenceDao dao) {
        this.io = io;
        this.dao = dao;
    }

    @Override
    public void run() {
        io.print("Currently, you have the following active filters: " + dao.getFilters());
        String remove = io.readLineAcceptEmpty("Please enter the filter you want to remove"
                + " (\"ddd\" to remove all filters)");
        if (remove.isEmpty()) {
            return;
        }
        if (remove.equals("ddd")) {
            dao.clearFilters();
            io.print("All filters are removed.");
        } else {
            dao.removeFilter(remove);
            io.print("References matching the filter:");
            List<Reference> matches = dao.listFiltered();
            for (Reference r : matches) {
                io.print(r.getEasyName());
            }
        }
    }

    /*
    private String printFilters() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (String filter : filters) {
            sb.append("\t");
            sb.append(filter);
            sb.append("\n");
        }
        return sb.toString();
    }
     */
}
