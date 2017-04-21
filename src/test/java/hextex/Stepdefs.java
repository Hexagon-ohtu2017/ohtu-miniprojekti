/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex;

import cucumber.api.java.en.And;
import hextex.io.StubIO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hextex.inmemory.InMemoryReferenceDao;
import hextex.inmemory.ReferenceDao;
import hextex.io.ConsoleInterface;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author ilarilai
 */
public class Stepdefs {
    StubIO io;
    ReferenceDao referenceDao = new InMemoryReferenceDao();
    List<String> inputLines = new ArrayList<>();
   
    @Given("^new is selected$")
    public void new_selected() throws Throwable {
    inputLines.add("new");
    
    }
    @Given("^book is selected$")
    public void book_is_selected() throws Throwable {
        inputLines.add("book");
    }
    @When("^author \"([^\"]*)\" is entered$")
    public void author_is_entered(String author) throws Throwable {
      inputLines.add(author);
      
    }
     @And("^title \"([^\"]*)\" is entered$")
    public void title_is_entered(String title) throws Throwable {
      inputLines.add(title);
      
    } 
    @And("^year \"([^\"]*)\" is entered$")
    public void year_is_entered(String year) throws Throwable {
      inputLines.add(year);
      
    }
     @And("^publisher \"([^\"]*)\" is entered$")
    public void publisher_is_entered(String publisher) throws Throwable {
      inputLines.add(publisher);
    
    }@And("^creation is activated$")
    public void creation_is_ativated() throws Throwable {
      inputLines.add("back");
      inputLines.add("quit");
      io =new StubIO(inputLines);
      ConsoleInterface console=new ConsoleInterface(io);
      console.run();
    }


    @Then("^a new book is created$")
    public void new_book_created() throws Throwable {
    for(int i=0; i<io.getPrints().size();i++){
        System.out.println(io.getPrints().get(i)+" KOE!!!!!");
    } 
    assertTrue(io.getPrints().contains("Reference was succesfully created!"));
    }

//    @Given("^bibtex is selected$")
//    public void bibtex_selected() throws Throwable {
//        inputLines.add("bibtext");
//    }

//    @When("^name \"([^\"]*)\" and references are given$")
//    public void name_entered() throws Throwable {
//
//    }
//
//    @Then("^a new bibtex file is created$")
//    public void new_bibtex_created() throws Throwable {
//
//    }
}
