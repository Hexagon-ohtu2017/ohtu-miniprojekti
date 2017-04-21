///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package hextex;
//
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
//
///**
// *
// * @author ilarilai
// */
public class Stepdefs {
//
    ConsoleInterface console;
    StubIO io;
    InMemoryReferenceDao dao = new InMemoryReferenceDao();
    List<String> inputLines = new ArrayList<>();
    String result;
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
@Given("^app is running$")
public void app_is_running() throws Throwable {
// Write code here that turns the phrase above into concrete actions

}

@When("^new is selected$")
public void new_is_selected() throws Throwable {
// Write code here that turns the phrase above into concrete actions
inputLines.add("new");
//inputLines.add("back");
//inputLines.add("back");
//inputLines.add("quit");
io = new StubIO(inputLines);
console = new ConsoleInterface(io);
console.mainmenu();
}

@Then("^system will respond with \"([^\"]*)\"$")
public void system_will_respond_with(String arg1) throws Throwable {
// Write code here that turns the phrase above into concrete actions

assertTrue( io.getPrints().contains("Create a new reference"));
}


}
