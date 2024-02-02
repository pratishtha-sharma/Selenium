#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase order from ecommerce website
  I want to use this template for my feature file

  
Background:
Given I landed on ecommerce website

  @submitOrder
  Scenario Outline: Postivie testcase of submitting an order
    Given Logged in with emailId <email> and password <password>
    When I add product <productName> to Cart
    And Click on checkout for <productName> and submit order
    Then "THANKYOU FOR THE ORDER." message should be shown on Confirmation Page

    Examples: 
      | email                     | password    | productName     |
      | pratishtha@mailinator.com | Welcome@123 | ADIDAS ORIGINAL |
     
