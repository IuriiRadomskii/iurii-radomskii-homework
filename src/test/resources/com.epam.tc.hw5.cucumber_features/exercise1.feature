Feature: Different Elements page functionality

  Scenario: Login as user "Roman Iovlev"
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When Open Different Element page through the header dropdown menu Service
    And Select 'Water' and 'Wind' checkboxes
    And Select 'Selen' radio button
    And Select 'Yellow' in dropdown menu
    Then Log has proper entries