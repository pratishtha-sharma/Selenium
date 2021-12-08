Feature: Application Login

Scenario: Home page after login
Given User is on Netbanking landing page after login
When User login into application with username and password
Then User is taken to the home page
And Cards are displayed