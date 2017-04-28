
package hextex.io.commands;

public class HelpCommand implements Command {

    @Override
    public void run() {
        System.out.println("type new if you want to generate new reference");
        System.out.println("type delete if you want to delete a reference");
        System.out.println("type list if you want to list all references");
        System.out.println("type bibtex to create bibtex file for a reference");
        System.out.println("type quit if you want to quit program");
    }

}
