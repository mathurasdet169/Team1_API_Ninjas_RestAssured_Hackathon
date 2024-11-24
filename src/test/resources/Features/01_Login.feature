
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
		