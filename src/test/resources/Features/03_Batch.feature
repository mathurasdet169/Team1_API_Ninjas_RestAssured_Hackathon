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
@batch
Feature: Batch Module
  

  @Post
  Scenario Outline: Check user able to create batch with json data
    Given User creates POST request 
    When User sends POST HTTP request with "<ScenarioType>" and endpoint
    Then User receives <statusCode> and with response body for create
    
        Examples:
      | ScenarioType                 | statusCode |
      |CreateBatchWithoutAuth        |        401 |
      |CreateBatchWithValidData      |        201 |
      |CreateBatchExistingBatchName  |        400 |
      |CreateBatchWithMissingData    |        400 |
      |CreateBatchWithInvalidEndpoint|        404 |
      |CreateBatchWithMissingAdditioanlFields|201 |
      |CreateBatchWithInValidData    |        400 |
      |CreateBatchWithInactiveProgId |        400 |


