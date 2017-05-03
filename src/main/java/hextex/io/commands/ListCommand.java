
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.references.Reference;
import java.util.List;

public class ListCommand implements Command {

    private InMemoryReferenceDao dao;
    private IO io;

    public ListCommand(InMemoryReferenceDao dao, IO io) {
        this.dao = dao;
        this.io = io;
    }

    @Override
    public void run() {
        List<Reference> references = dao.listFiltered();
//        List<Reference> references = this.dao.listAll();
//        try {
//            references.addAll(JsonFileManipulator.readJSON());
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ConsoleInterface.class.getName()).log(Level.SEVERE, null, ex);
//        }
        io.print("References:");
        for (Reference ref : references) {
            io.print("\t" + ref.getEasyName());
        }
    }

}
