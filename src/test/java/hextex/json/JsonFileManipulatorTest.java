/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.json;

import hextex.references.Book;
import hextex.references.Reference;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tuomo
 */
public class JsonFileManipulatorTest {

    private ArrayList<Reference> lib;
    private Book b;
    private String testFile;

    public JsonFileManipulatorTest() {
        lib = new ArrayList();
        testFile = "testestestest.json";
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String author = "Tea the Tester";
        String title = "Testing the Tester";
        int year = 2017;
        String publisher = "Princeton University Press";
        String key = "Tes2017";
        b = new Book(author, title, year, publisher, key);
        lib.add(b);
    }

    /**
     * Test of writeJSON method, of class JsonFileManipulator.
     */
    @Test
    public void testWriteJSON() throws Exception {
        JsonFileManipulator.writeJSON(lib, testFile);
    }

    /**
     * Test of readJSON method, of class JsonFileManipulator.
     */
    @Test
    public void testReadJSON() throws Exception {
        List<Reference> refs = JsonFileManipulator.readJSON(testFile);
        assertEquals("Tes2017", refs.get(0).getKey());
        assertEquals(1, refs.size());
    }

}
