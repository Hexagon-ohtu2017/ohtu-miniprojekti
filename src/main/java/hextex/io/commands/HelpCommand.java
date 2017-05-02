
package hextex.io.commands;

import hextex.io.IO;

public class HelpCommand implements Command {

    private IO io;

    public HelpCommand(IO io) {
      this.io = io;
    }
    @Override
    public void run() {
        io.print("type new if you want to generate new reference");
        io.print("type delete if you want to delete a reference");
        io.print("type list if you want to list all references");
        io.print("type bibtex to create bibtex file for a reference");
        io.print("type quit if you want to quit program");
    }

}
