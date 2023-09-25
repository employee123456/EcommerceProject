Feature: Temp

  @t
  Scenario: Example scenario
    Given I want to do something
    When I have a list of item to send
      | akash   |
      | chetna  |
      | gauri   |
      | shradha |
      | rani    |
    When I have student and there mark to send
      | Student_name | marks | Grade |
      | akash        | 50    | A     |
      | chetna       | 40    | B     |
      | gauri        | 60    | A     |
      | shradha      | 70    | A     |
      | rani         | 80    | A     |
    Then something should happened


  @Example
  Scenario Outline:I want to search for the product
    Given I am on the search page
    When I search for the product "<product>"
    Then Result should be displayed as "<product>"
  Example:
  | computer  |
  | mobile    |
  | earphone  |
  | bluetooth |
  | shoes     |
