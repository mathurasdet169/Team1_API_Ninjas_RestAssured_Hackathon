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
@login
Feature: Login to the LMS API Portal

Background: For creating http post request without bearer token
Given Admin create HTTP POST Request for LOGIN  
  

@AdminLogin_Positive_Scenario
Scenario: Admin login to the LMS
    #Given Admin creates request with valid credentials
    When Admin calls Post Https method with valid endpoint
    Then Admin receives 200 created with auto generated token
    
@AdminLogin_Invalid_EndPoint
Scenario: Admin login to the LMS API using invalid end point
    When Admin calls Post Https method with Invalid endpoint
    Then Admin receives Admin receives 401 unauthorized
    
@AdminLogin_With_Invalid_UserName
Scenario: Admin login to the LMS API using invalid Username
	    When Admin calls Post Https method with valid endpoint for Invalid Username
	    Then Admin receives 400 Bad Request with message for Invalid username
	    
@AdminLogin_With_Invalid_Password
Scenario: Admin login to the LMS API using invalid Password
	    When Admin calls Post Https method with valid endpoint for Invalid Password
	    Then Admin receives 400 Bad Request with message for Invalid Password

@AdminLogout_Without_Bearer
Scenario: Admin trying to logout without using bearer token
		When Admin calls Get Https method with valid endpoint
		Then Admin receives 401  unauthorized Access
		
