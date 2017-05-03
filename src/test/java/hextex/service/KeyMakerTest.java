/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.service;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.references.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ilari
 */
public class KeyMakerTest {

    private InMemoryReferenceDao dao;
    private KeyMaker km;
    private static final String manyAuthors = "Doe John, Doe John, Doe John";
    private static final String oneAuthor = "Doe John";
    private static final String shortAuthor = "Do John";
    private static final int year = 2017;

    @Before
    public void setUp() {
        this.dao = new InMemoryReferenceDao();
        this.km = new KeyMaker(dao);
    }

    @Test
    public void testGenerateKeyMultipleAuthors() {
        assertEquals(km.generateKey(manyAuthors, year), "DoeDoeDoe2017");
    }

    @Test
    public void testGenerateKeyOneAuthor() {
        assertEquals(km.generateKey(oneAuthor, year), "Doe2017");
    }

    @Test
    public void testSameYear() {
        String first = "DoeDoe2017";
        assertEquals(km.keyMakerSameYear(first), "DoeDoe2017a");
    }

    @Test
    public void testMultipleSameYear() {
        String key = "Tes2017a";
        String author = "Tea the Tester";
        String title = "Testing the Tester";
        String publisher = "Princeton University Press";
        Book b = new Book(author, title, year, publisher, key);
        dao.add(b);
        assertEquals(km.addCharacters(key), "Tes2017b");
    }
    

}
