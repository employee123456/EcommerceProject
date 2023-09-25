Feature: Payment
  @payment
  Scenario: User go to the payment option

    Given User will login
    And user will enter the email annd password
    When click on the signin button
    Then Uer will login
    Then user will go to the payment option