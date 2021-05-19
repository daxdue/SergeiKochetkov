Feature: First Exercise feature

  Scenario: Elements page test
    Given I open JDI GitHub site
    When I perform login with username 'Roman' and password 'Jdi1234'
    Then I expect to view logged user 'ROMAN IOVLEV'
    And I open 'Different Elements' page
    When I select checkboxes 'Water' and 'Wind'
    Then log row displayed for each selected checkbox
    When I select radio 'Selen'
    Then log row displayed for selected radio
    When I select dropdown item 'Yellow'
    Then log row displayed for selected dropdown element

