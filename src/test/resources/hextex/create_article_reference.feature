Feature: As a user I can create a new article reference with proper input

    Scenario: creation succesfull with proper fields author title journal volume pages and year
        Given new is selected
        And   article is selected
        When  author "Joku Arttu" is entered
        And title "otsikko" is entered
        And journal "lehti" is entered
        And volume "1" is entered
        And pages "10" is entered
        And year "2017" is entered
        And creation is activated
        Then a new article is created