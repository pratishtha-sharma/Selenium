@tag
Feature: Purchase order from ecommerce website
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on ecommerce website
    When Logged in with emailId <email> and password <password>
    Then "Incorrect email or password." message should be shown on login Page


    Examples: 
      | email                    | password    |
      | pratishtha@mailinator.co | Welcome@12  |
