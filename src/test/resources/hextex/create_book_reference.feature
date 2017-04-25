
Feature: As a user I can create a new book reference with proper input

    Scenario: creation succesfull with proper fields title author year publisher reference
        Given new is selected
        And   book is selected
        When  author "Joku Arttu" is entered
        And title "kirja" is entered
        And year "1994" is entered
        And publisher "otava" is entered
        And creation is activated
        Then a new book is created