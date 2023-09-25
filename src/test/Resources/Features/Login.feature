Feature: Login Feature
  @Login_feature
  Scenario:User is able to login in the Application
    Given User opened the browser
    And user is entered the Application Url
    When user enter username as "john" and password as "demo" and click on the login button
#    When user enter username and password as in below table and click on logi button
      |username|john|
      |password|demo|
    Then  user is able to login to the Application
