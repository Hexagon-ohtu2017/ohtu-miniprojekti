
Feature: As a user I can create a new book reference with proper input

    Scenario: creation succesfull with proper fields title author year publisher reference
        Given new is selected
        When title "kirja" and author "arttu" and year "1994" and publisher "otava" and reference "ka94" are given
        Then a new book is created