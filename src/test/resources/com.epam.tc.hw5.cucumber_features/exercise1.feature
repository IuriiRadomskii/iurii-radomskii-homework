Feature: Different Elements page functionality
  Scenario: Checkboxes, radio buttons and options logs test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    And Select 'Water' and 'Wind' checkboxes
    And Select 'Selen' radio button
    And Select 'Yellow' in dropdown menu
    Then Log has proper entries