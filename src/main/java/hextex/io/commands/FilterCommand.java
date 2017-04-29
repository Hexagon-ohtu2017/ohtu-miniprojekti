/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.references.Reference;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Reference> references = this.dao.listAll();
        String filterString = io.readLine("Please enter a string you want to use to filter the references: ");
        
        io.print("References matching the filter:");
        List<Reference> matches = references.stream().filter(r -> r.matchesFilter(filterString)).collect(Collectors.toList());
        for (Reference r : matches) {
            io.print("\t" + r.getEasyName());
        }
    }

}
