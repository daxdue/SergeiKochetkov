Feature: Third Exercise Test feature

  Scenario: User manage test
    Given I open JDI GitHub site
    When I perform login with username 'Roman' and password 'Jdi1234'
    Then I expect to view logged user 'ROMAN IOVLEV'
    And I click on 'Service' button in Header
    And I click on 'User Table' button in Service dropdown
    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section
