/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex;

import hextex.io.ConsoleInterface;
import hextex.io.StubIO;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import org.junit.rules.ExternalResource;

public class ServerRule extends ExternalResource{
    
    @Override
    protected void after(){
        
        List<String> inputLines = new ArrayList<>();
        inputLines.add("delete");
        inputLines.add("kir1994");
        inputLines.add("quit");
        inputLines.add("y");
        StubIO io=new StubIO(inputLines);
        ConsoleInterface console = new ConsoleInterface(io);
        try {
            console.run();
        } catch (IOException ex) {
            System.out.println("Ei ajettu tyhjennystä");;
        }
           try {
        FileWriter fwOb = new FileWriter("TeaTest.txt", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        } catch (FileNotFoundException ex) {
            System.out.println("tiedostoa ei löydetty");;
        } catch (IOException ex) {
            System.out.println("Luku ei onnistunut tiedostosta");;
        }
    }
}