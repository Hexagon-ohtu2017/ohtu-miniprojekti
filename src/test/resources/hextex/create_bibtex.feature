Feature: As a user I can create a new bibtex file

    Scenario: a new named bibtex is succesfully created with references
        Given bibtex is selected
        When name "tiedostonimi" and references are given
        Then a new bibtex file is created
