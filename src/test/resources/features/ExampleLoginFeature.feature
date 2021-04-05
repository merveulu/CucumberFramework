Feature: Login Page test
  Scenario: Login with correct credentials
    Given user will be on login page
    When user enter correct credentials and click login
    Then verify login