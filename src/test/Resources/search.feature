Feature: Search
  @search_feature
  Scenario: User will go to the search option
    Given User opened the browser
    And user is entered the Application Url
    When user enter username as "john" and password as "demo" and click on the login button
#    When user enter username and password as in below table and click on logi button
      |username|john|
      |password|demo|
    Then  user is able to login to the Application



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
