package hextex.io;

public class MainMenu implements Element{

  private IO io;

  public MainMenu(IO io) {
    this.io = io;
  }

  @Override public Element run() {
    return new MainMenu(io);
  }
  //@Override
  //public void run() {
    //while (true) {
      //System.out.println("Welcome to the mainmenu of HexTexBibtexGenerator 1.0 !");
      //String command = io.readLine("Commands: [new] , [list] , [delete] , [help] , [quit]");
      //if (command.equals("new")) {
        //io.print("Create a new reference");
        //return "new";
      //}
      //if (command.equals("list")) {
          //io.print("Listing all references");
          //return "list";
      //}

      //if (command.equals("delete")) {
        //io.print("Reference key (format: 'DoeDoe2000'):");
        //return "delete";
      //}

      //if (command.equals("help")) {
        //io.print("type new to create new reference");
        //io.print("type bibtex to create bibtex file for reference you created");
        //io.print("type back if you want to return to main menu");
          //return "help";
      //}

      //if (command.equals("quit")) {
          //io.print("Thank you, come again ;)");
          //return "quit";
      //}
    //}
  //}
}
