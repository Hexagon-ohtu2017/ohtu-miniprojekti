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
import java.util.stream.Collectors;

/**
 *
 * @author aleksisvuoksenmaa
 */
public class RemoveFilterCommand implements Command {

    private InMemoryReferenceDao dao;
    private IO io;
    private QueryBuilder queryBuilder;
    private ArrayList<String> filters;

    public RemoveFilterCommand(IO io, InMemoryReferenceDao dao, QueryBuilder qb, ArrayList<String> filters) {
        this.io = io;
        this.dao = dao;
        this.queryBuilder = qb;
        this.filters = filters;
    }

    @Override
    public void run() {
        io.print("Currently, you have the following active filters: " + this.printFilters() +"\n");
        String remove = io.readLine("Please enter the filter you want to remove: ");
        this.filters.remove(remove);
        io.print("References matching the filter:");
        //List<Reference> matches = references.stream().filter(r -> r.matchesFilter(filterString)).collect(Collectors.toList());
        for (String filter : filters) {
            queryBuilder.matchesField(filter);
        }
        Matcher m = queryBuilder.build();
        ArrayList<Reference> matches = this.matches(m);
        for (Reference r : matches) {
            io.print(r.getEasyName());
        }
    }
    
    private ArrayList matches(Matcher matcher) {
        ArrayList<Reference> matches = new ArrayList<Reference>();
        
        for (Reference r : this.dao.listAll()) {
            if (matcher.matches(r)) {
                matches.add(r);
            }            
        }
        
        return matches;
    }
    
    private String printFilters() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (String filter : filters) {
            sb.append("\t" + filter);
            sb.append("\n");
        }
        return sb.toString();
    }

    

}