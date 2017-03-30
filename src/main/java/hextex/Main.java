package hextex;

import java.util.Scanner;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Anna kirjan nimi: ");
        
        String nimi = "";
        if(s.hasNextLine()) {
            nimi = s.nextLine();
        }
        
        System.out.println("Annoit nimen: " + nimi);
        
    }
}
