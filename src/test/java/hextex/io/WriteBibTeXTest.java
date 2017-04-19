/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.io;
import hextex.references.Book;
import hextex.references.Reference;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class WriteBibTeXTest {
    private ArrayList<Reference> lib;

    public WriteBibTeXTest() {
      String refName = "TT17";
      String author = "Tea the Tester";
      String title = "Testing the Tester";
      int year = 2017;
      String publisher = "Princeton University Press";
      String key = "Tes2017";
      Book b = new Book(author, title, year, publisher, key);
      this.lib = new ArrayList();
      lib.add(b);
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

   @Test
   public void writeBibTeXCorrectly() throws IOException {
       WriteBibTeX.writeFile("TeaTest.txt", lib);
       BufferedReader br = new BufferedReader(new FileReader("TeaTest.txt"));

       StringBuilder sb = new StringBuilder();
       String line = br.readLine();
       assertFalse(line.isEmpty());

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();

        String comparison = "@book{" + "Tes2017" + ",\n"
                + "author = {" + "Tea the Tester" + "},\n"
                + "title = {" + "Testing the Tester" + "},\n"
                + "year = {" + 2017 + "},\n"
                + "publisher = {" + "Princeton University Press" + "},\n"
                + "}\n";

        assertTrue(sb.toString().contains(comparison));

   }
}
