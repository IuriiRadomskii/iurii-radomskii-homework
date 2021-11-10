Feature: Different Elements page functionality

  Scenario: Select checkboxes, radio buttons and option in dropdown menu
    Given I open Index Page
    When I perform login
    And Open through the header menu Service -> Different Elements Page
    And Select 'Water' and 'Wind' checkboxes
    And Select 'Selen' radio button
    And Select 'Yellow' in dropdown menu
    Then Each checkbox have proper log entries
    And Radio button has proper log entry
    And Yellow option has proper log entry