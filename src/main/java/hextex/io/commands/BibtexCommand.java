
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.io.WriteBibTeX;
import hextex.references.Reference;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BibtexCommand implements Command {

    private IO io;
    private InMemoryReferenceDao dao;

    public BibtexCommand(IO io, InMemoryReferenceDao dao) {
        this.io = io;
        this.dao = dao;
    }

    @Override
    public void run() {

        if (dao.getReferences().isEmpty()) {
            io.print("There are no references!");
            return;
        }

        String fileName = io.readLine("Please give a name of the BibTeX file you wish to be created");

        for (Reference r : dao.getReferences()) {
            try {
                WriteBibTeX.writeFile(fileName, r);
            } catch (IOException ex) {
                throw new IllegalStateException(ex.getMessage());
            }
        }

    }

}
