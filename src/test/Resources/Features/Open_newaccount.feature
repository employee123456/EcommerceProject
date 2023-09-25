Feature: Open_newaccount
  @open_new_account
  Scenario: User is able to open the account
    Given User is looged In
    And User click on link as "Open new account"
    When User is select account as "SAVINGS" and any account number
#    When User is select account as "saving" and account number as "12345"
    And user click on Button Open new Account
    Then Account opened message is Displayed
    And A new number is generated