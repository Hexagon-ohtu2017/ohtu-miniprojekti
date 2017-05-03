package hextex.io;

public class MainMenu implements Element{

  private IO io;

  public MainMenu(IO io) {
    this.io = io;
  }

  @Override
  public void run() {
    while (true) {
      System.out.println("Welcome to the mainmenu of HexTexBibtexGenerator 1.0 !");
      String command = io.readLine("Commands: [new] , [list] , [find] , [delete] , [help] , [quit]");
      if (command.equals("new")) {
        io.print("Create a new reference!");
         break;
      }
      if (command.equals("list")) {
          io.print("References:");
          break;
      }

      if (command.equals("find")) {

          break;
      }

      if (command.equals("delete")) {
        io.print("Reference key (format: 'DoeDoe2000'):");
        break;
      }

      if (command.equals("help")) {
        io.print("type new to create new reference");
        io.print("type bibtex to create bibtex file for reference you created");
        io.print("type back if you want to return to main menu");
        break;
      }

      if (command.equals("quit")) {
          io.print("Thank you, come again ;)");
          break;
      }
    }
  }
}
