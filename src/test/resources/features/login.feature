Feature: Login functionality on Saucedemo

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username and password
    And I click on the login button
    Then I should be redirected to the products page

  Scenario: Failed login with invalid username
    Given I am on the login page
    When I enter invalid username and valid password
    And I click on the login button
    Then I should see an error message

  Scenario: Boundary case - login with empty username and password
    Given I am on the login page
    When I leave username and password fields empty
    And I click on the login button
    Then I should see an error message
