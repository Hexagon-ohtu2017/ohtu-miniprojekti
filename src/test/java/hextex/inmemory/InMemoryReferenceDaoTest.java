/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.inmemory;

import hextex.references.*;
import hextex.references.Reference;
import hextex.service.KeyMaker;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuletule
 */
public class InMemoryReferenceDaoTest {

    private InMemoryReferenceDao dao;
    private KeyMaker km;
    private Book b;
    private Article a;
    private Inproceedings ip;

    public InMemoryReferenceDaoTest() {
        this.dao = new InMemoryReferenceDao();
        this.km = new KeyMaker(dao);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String author = "Tea Tester";
        String author2 = "Filtered tester";
        String title = "Testing the Tester";
        int year = 2017;
        String publisher = "Princeton University Press";

        b = new Book(author, title, year, publisher, km.generateKey(author, year));

        dao.add(b);

        a = new Article(author2, "Test Article", "Journal of studies", 1,
                "234-245", 2017, km.generateKey(author, year));

        dao.add(a);

        ip = new Inproceedings(author, "Test proc", "Impro Book",
                year, km.generateKey(author, year));

        dao.add(ip);

    }

    @Test
    public void testDelete() {
        dao.delete(b.getKey());

        assertFalse(dao.listAll().contains(b));
    }

    @Test
    public void testFilter() {
        dao.addFilter("Filt");

        assertFalse(dao.listFiltered().contains(b));
        assertTrue(dao.listFiltered().contains(a));
    }

    @Test
    public void testFilter2() {
        dao.addFilter("Filt");
        assertTrue(dao.getFilters().contains("Filt"));
    }

    @Test
    public void testRemoveFilter() {
        dao.addFilter("Filt");
        assertTrue(dao.getFilters().contains("Filt"));
        
        dao.removeFilter("Filt");
        assertFalse(dao.getFilters().contains("Filt"));
    }

    @Test
    public void testMultipleFilters() {
        dao.addFilter("Test");
        assertTrue(dao.listFiltered().contains(b));
        
        dao.addFilter("proc");
        assertFalse(dao.listFiltered().contains(b));
        assertTrue(dao.listFiltered().contains(ip));
        assertFalse(dao.listFiltered().contains(a));
    }

    @Test
    public void testRemoveAllFilters() {
        dao.addFilter("Test");
        assertTrue(dao.listFiltered().contains(b));
        
        dao.addFilter("proc");
        assertFalse(dao.listFiltered().contains(b));
        assertTrue(dao.listFiltered().contains(ip));
        assertFalse(dao.listFiltered().contains(a));
        
        
        dao.clearFilters();
        assertTrue(dao.listFiltered().contains(a));
        assertTrue(dao.listFiltered().contains(b));
        assertTrue(dao.listFiltered().contains(ip));
    }

    @Test
    public void listAllWorksWhenFiltered() {
        dao.addFilter("proc");
        assertFalse(dao.listFiltered().contains(b));
        assertTrue(dao.listAll().contains(b));
    }
    
    @Test
    public void listAllAndListFilteredAreEquivalentWithoutFilters() {
        assertTrue(dao.listFiltered().containsAll(dao.listAll()));
        assertTrue(dao.listAll().containsAll(dao.listFiltered()));
    }
}
