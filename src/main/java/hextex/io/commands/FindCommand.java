package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.references.Reference;
import java.util.List;

public class FindCommand implements Command {

    private InMemoryReferenceDao dao;
    private IO io;

    public FindCommand(InMemoryReferenceDao dao, IO io) {
        this.dao = dao;
        this.io = io;
    }

    @Override
    public void run() {
        String key = io.readLineAcceptEmpty("Please enter the key of the reference you are looking for: ");
        if (key.isEmpty()) {
            return;
        }
        List<Reference> references = dao.listFiltered();
        for (Reference ref : references) {
            if (ref.getKey().equals(key)) {
              io.print("Reference:\n\t" + ref.getFullName()+ "\n");
              return;
            }
        }
        io.print("Reference doesn't exist\n");
    }

}
