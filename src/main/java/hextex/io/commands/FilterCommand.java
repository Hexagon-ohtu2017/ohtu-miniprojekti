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
public class FilterCommand implements Command {

    private InMemoryReferenceDao dao;
    private IO io;
    private QueryBuilder queryBuilder;
    private ArrayList<String> filters;

    public FilterCommand(IO io, InMemoryReferenceDao dao, QueryBuilder qb, ArrayList<String> filters) {
        this.io = io;
        this.dao = dao;
        this.queryBuilder = qb;
        this.filters = filters;
    }

    @Override
    public void run() {
        List<Reference> references = this.dao.listAll();
        String filterString = io.readLine("Please enter a string you want to use to filter the references: ");
        this.filters.add(filterString);
        for (String s : filters) {
            queryBuilder.matchesField(s);
        }
        io.print("References matching the filter:");
        //List<Reference> matches = references.stream().filter(r -> r.matchesFilter(filterString)).collect(Collectors.toList());
        Matcher m = queryBuilder.build();
        List<Reference> matches = this.matches(m);
        for (Reference r : matches) {
            io.print("\t" + r.getEasyName());
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

    

}
