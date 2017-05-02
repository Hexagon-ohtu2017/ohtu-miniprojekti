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

    @Given("^app is running$")
    public void app_is_running() throws Throwable {
    }
    
    @When("^(.+) is selected$")
    public void option_is_selected(String option) throws Throwable {
        inputLines.add(option);
    }
    
    @When("^.*\"([^\"]*)\" is entered$")
    public void something_is_entered(String arg1) throws Throwable {
        inputLines.add(arg1);
    }
    
    @When("^creation is activated$")
    public void creation_is_ativated() throws Throwable {
        inputLines.add("quit");
        io = new StubIO(inputLines);
        ConsoleInterface console = new ConsoleInterface(io);
        console.run();
    }

    @Then("^a new book is created$")
    public void new_book_created() throws Throwable {
        for(int i=0; i<io.getPrints().size(); i++){
            System.out.println(io.getPrints().get(i)+" KOE!!!!!");
        }
        assertTrue(io.getPrints().contains("Reference was succesfully created!"));
    }
    
    @Then("^system will respond with \"([^\"]*)\"$")
    public void system_will_respond_with(String arg1) throws Throwable {
      io = new StubIO(inputLines);
      ConsoleInterface console = new ConsoleInterface(io);
      console.run();
      assertTrue(io.getPrints().contains(arg1));
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
