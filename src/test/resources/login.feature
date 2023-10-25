Feature: Login

  Scenario: User can log in
    Given User is on login page
    When User inputs valid username "username"
    And User inputs valid password "password"
    And User clicks on Login button
    Then User is logged in

    Scenario Outline: User cannot log in in with invalid credentials
      Given User is on login page
      When User inputs valid username <username>
      And User inputs valid password <password>
      And User clicks on Login button
      Then User is not logged in
      Examples:
        | username | password          |
        | "user 1" | "some password 1" |
        | "user 2" | "some password 2" |
        | "user 3" | "some password 3" |