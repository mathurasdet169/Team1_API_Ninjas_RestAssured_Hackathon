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
@ClassFeature
Feature: Class feature of the LMS Portal
#
  #Background: 
    #Given The admin is logged in successfully into the LMS application
#
  #@GetAllClassRecordings
  #Scenario Outline: Get all class recordings
    #Given Admin creates GET Request for "<Scenario>"
    #When Admin sends HTTPS "<Request>" with "<endpoint>"
    #Then Admin receives <exp_statuscode> and "<Message>" with response body.
#
    #Examples: 
      #| Scenario                                    | exp_statuscode | endpoint        | Request | Message        |
      #| Get_AllClassRecordings_With_ValidEndpoint   |            200 | classrecordings | Valid   | OK             |
      #| Get_AllClassRecordings_With_InValidEndpoint |            404 | classrec        | Valid   | Not Found      |
     #| Get_AllClassRecordings_With_InValidMethod   |            405 | classrecordings | InValid | Not Allowed    |
     #| Get_AllClassRecordings_With_NoAuth          |            401 | classrecordings | Valid   | Not Authorized |
      #
     