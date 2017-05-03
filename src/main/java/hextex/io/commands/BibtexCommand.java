package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.io.WriteBibTeX;
import hextex.references.Reference;
import java.io.IOException;
import java.util.List;

public class BibtexCommand implements Command {

    private IO io;
    private InMemoryReferenceDao dao;

    public BibtexCommand(IO io, InMemoryReferenceDao dao) {
        this.io = io;
        this.dao = dao;
    }

    @Override
    public void run() {
        List<Reference> references = dao.listFiltered();

        if (references.isEmpty()) {
            io.print("There are no references matching your filters!");
            return;
        }

        String fileName = io.readLine("Please give a name of the BibTeX file "
                + "you wish to update");

        for (Reference r : references) {
            try {
                WriteBibTeX.writeFile(fileName + ".bib", r);
            } catch (IOException ex) {
                throw new IllegalStateException(ex.getMessage());
            }
        }
        io.print("Bibtex file \"" + fileName + ".bib" + "\" has been updated");

    }

}
