package hextex.io;

import java.util.Scanner;

public class ConsoleIO implements IO {

    private Scanner scanner;

    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    public int readInt(String prompt) {
        while (true) {

            System.out.println(prompt);
            String result = scanner.nextLine();
            try {
                int number = Integer.parseInt(result);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Value must be a number!");
            }
        }
    }

    public String readLine(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Value cannot be empty!");
        }
    }

    public String readAuthors(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            if (!input.isEmpty() && input.contains(" ")) {
                return input;
            }if(input.isEmpty()){
                System.out.println("Author cannot be empty!");
            }
            System.out.println("Please follow the format");
        }
    }
}
