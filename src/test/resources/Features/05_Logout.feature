@tag
Feature: Logout Admin
  I want to use this template for my feature file

  
Background:Admin is already loggedin
Given Admin create GET request for Logout    
      
@Admin_Logout
Scenario: Admin is getting loggedout with valid end point
When Admin send HTTP Get request for valid end point
Then Admin receive status code 200 OK

@Admin_Logout_With_Invalid_EndPoint
Scenario: Admin is trying to logout with invalid endpoint
When Admin send HTTP Get request for Invalid end point
Then Admin receive status code 401 Unauthorized
