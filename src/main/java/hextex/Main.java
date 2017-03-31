package hextex;
import hextex.io.ConsoleIO;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("JEE TÄÄ TOIMII!!");
        ConsoleIO io = new ConsoleIO();
        String name = io.readLine("Give book's name");
        System.out.println("Book's name is " + name);
        int pages = io.readInt("How many pages book have?");
        System.out.println("Book has " + pages + " pages");
    }
}
