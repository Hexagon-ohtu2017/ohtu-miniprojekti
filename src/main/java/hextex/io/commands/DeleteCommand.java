/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        String keyToBeRemoved = io.readLine("Reference key (format: 'DoeDoe2000'):");
        dao.delete(keyToBeRemoved);
        System.out.println("reference deleted");
    }

}
