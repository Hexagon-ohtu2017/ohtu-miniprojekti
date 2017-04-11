/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hextex.database.BookDao;
import hextex.database.Database;
import hextex.io.ConsoleInterface;
import java.sql.SQLException;

/**
 *
 * @author ilarilai
 */
public class Stepdefs {

//    ConsoleInterface io = new ConsoleInterface();
//    Database database = new Database();
//    BookDao bookDao = new BookDao(database);
    @Given("^new is selected$")
    public void new_selected() throws Throwable {

    }

    @When("^title \"([^\"]*)\" and author \"([^\"]*)\" and year \"([^\"]*)\" and publisher \"([^\"]*)\" are given$")
    public void fields_entered() throws Throwable {

    }

    @Then("^a new book is created$")
    public void new_book_created() throws Throwable {

    }

    @Given("^bibtex is selected$")
    public void bibtex_selected() throws Throwable {

    }

    @When("^name \"([^\"]*)\" and references are given$")
    public void name_entered() throws Throwable {

    }

    @Then("^a new bibtex file is created$")
    public void new_bibtex_created() throws Throwable {

    }
}
