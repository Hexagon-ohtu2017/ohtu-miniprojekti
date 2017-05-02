package hextex.io;

import hextex.io.commands.Command;
import java.util.ArrayList;
import java.util.HashMap;


public class Shortcut {
  private ArrayList<String> commands;

  public Shortcut(ArrayList<String> commands) {
    this.commands = commands;
  }

  public String retunCommand(String print) {
      String command  = "eiole";
      for (String name : commands) {
          if (print.length() <= name.length()) {
             if (print.equals(name)) {
               return print;
             }
            if (name.substring(0, print.length()).equals(print)) {
                if (command.equals("eiole")) {
                    command = name;
                }
                else {
                    return "eiole";
                }

            }
          }

      }
      return command;
  }


}
