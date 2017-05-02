Feature: As a user I can create a new inproceedings reference with proper input

    Scenario: creation succesfull with proper fields author title bookTitle and year
        Given new is selected
        And   inproceedings is selected
        When  author "Joku Arttu" is entered
        And title "otsikko" is entered
        And bookTitle "kirjanNimi" is entered
        And year "2017" is entered
        And creation is activated
        Then a new inproceedings is created