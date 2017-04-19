///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hextex;
//
//import hextex.io.StubIO;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import hextex.inmemory.InMemoryReferenceDao;
//import hextex.inmemory.ReferenceDao;
//import hextex.io.ConsoleInterface;
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.Assert.assertEquals;
//
///**
// *
// * @author ilarilai
// */
//public class Stepdefs {
//
//    ConsoleInterface console;
//    StubIO io;
//    InMemoryReferenceDao dao = new InMemoryReferenceDao();
//    List<String> inputLines = new ArrayList<>();
//
//    @Given("^new is selected$")
//    public void new_selected() throws Throwable {
//        inputLines.add("new");
//    }
//
//    @When("^title \"([^\"]*)\" and author \"([^\"]*)\" and year \"([^\"]*)\" and publisher \"([^\"]*)\" and key \"([^\"]*)\" are given$")
//    public void fields_entered(String title, String author, String year, String publisher, String key) throws Throwable {
//        inputLines.add(title);
//        inputLines.add(author);
//        inputLines.add(year);
//        inputLines.add(publisher);
//        inputLines.add(key);
//        
//        io = new StubIO(inputLines);
//        console = new ConsoleInterface(io);
//    }
//
//    @Then("^a new book is created$")
//    public void new_book_created() throws Throwable {
//        console.createBook(io);
//        assertEquals(dao.getReferences().get(0).getKey(), "art1994");
//    }
//
//    @Given("^bibtex is selected$")
//    public void bibtex_selected() throws Throwable {
//
//    }
//
//    @When("^name \"([^\"]*)\" and references are given$")
//    public void name_entered() throws Throwable {
//
//    }
//
//    @Then("^a new bibtex file is created$")
//    public void new_bibtex_created() throws Throwable {
//
//    }
//}
