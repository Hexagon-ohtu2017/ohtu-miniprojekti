package hextex.io;

import java.util.Scanner;

public class ConsoleIO {

    private Scanner scanner;

    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
        String result = scanner.nextLine();
        return Integer.parseInt(result);

    }

    public String readLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
