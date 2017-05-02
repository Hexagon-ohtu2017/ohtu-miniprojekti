package hextex.io;

import java.util.ArrayList;
import java.util.List;

public class Shortcut {

    private ArrayList<String> commands;

    public Shortcut(ArrayList<String> commands) {
        this.commands = commands;
    }

    public List<String> returnCommands(String print) {
        List<String> matchingCommands = new ArrayList<>();
        for (String name : commands) {
            if (print.length() <= name.length()) {
                if (name.equals(print)) {
                    List<String> exactMatch = new ArrayList<>();
                    exactMatch.add(name);
                    return exactMatch;
                }
                if (name.substring(0, print.length()).equals(print)) {
                    matchingCommands.add(name);
                }
            }
        }

        return matchingCommands;
    }

}
