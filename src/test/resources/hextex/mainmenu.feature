Feature: As a user I can browse through main menu

    Scenario: new is selected from main menu
    Given app is running
    When new is selected
    And back is selected
    And back is selected
    And quit is selected
    Then system will respond with "Create a new reference!"

    Scenario: n is selected from main menu
    Given app is running
    When n is selected
    And back is selected
    And quit is selected
    Then system will respond with "Create a new reference!"


    Scenario: quit is selected from main menu
    Given app is running
    When quit is selected
    Then system will respond with "Thank you, come again ;)"

    Scenario: unknown command is selected from mainmenu
    Given app is running
    When getMattiLuukkainen is selected
    And qu is selected
    Then system will respond with "Command not found."


    Scenario: list is selected from main menu
    Given app is running
    When list is selected
    And quit is selected
    Then system will respond with "References:"

    Scenario: delete is selected from main menu
    Given app is running
    When delete is selected
    And "Testi65" is entered
    And quit is selected
    Then system will respond with "Reference key (format: 'DoeDoe2000'):"
