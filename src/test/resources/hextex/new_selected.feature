Feature: As a user I can browse through main menu

    Scenario: new is selected from main menu
    Given app is running
    When new is selected
    Then system will respond with "Create a new reference!"
