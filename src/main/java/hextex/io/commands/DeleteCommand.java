
package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;

public class DeleteCommand implements Command {

    private IO io;
    private InMemoryReferenceDao dao;

    public DeleteCommand(IO io, InMemoryReferenceDao dao) {
        this.io = io;
        this.dao = dao;
    }

    @Override
    public void run() {
        String keyToBeRemoved = io.readLineAcceptEmpty("Reference key (format: 'DoeDoe2000'):");
        if (keyToBeRemoved.isEmpty()) {
            return;
        }
        dao.delete(keyToBeRemoved);
        io.print("reference deleted");
    }

}
