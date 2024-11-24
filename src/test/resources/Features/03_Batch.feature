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
  

  @post
  Scenario Outline: Check user able to create batch with json data
    Given User creates POST request 
    When User sends POST HTTP request with "<ScenarioType>" and endpoint
    Then User receives <statusCode> of post with response body for "<ScenarioType>"
    
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


  @put
    Scenario Outline: Check user able to update batch with json data
    Given User creates PUT request
    When User sends PUT HTTP request with "<ScenarioType>" and endpoint
    Then User receives <statusCode> of put with response body for "<ScenarioType>"
    
        Examples:
      | ScenarioType                        | statusCode |
      | UpdateBatchbyBatchIdWithoutAuth     |401         |
      | UpdateBatchbyBatchId                |200         |
      | UpdateBatchbyInvalidBatchId         |404         |
      | UpdateBatchWithMissingData          |400         |
      | UpdateBatchWithInValidData          |400         |
      | UpdateBatchWithInvalidEndpoint      |404         |
      | UpdateBatchWithDeletedProgID        |400         |
      | UpdateBatchWithDeletedBatchID       |200         |      
      

      
   
   @getAllBatches
  Scenario Outline: Check user able to Get all batch details
    Given User creates GET request for all batches with "<ScenarioType>" data
    When User sends GET HTTP request with endpoint for get all "<ScenarioType>" data
    Then User receives <statusCode> and with response body for get all batches "<ScenarioType>" 
    
      Examples:
      | ScenarioType                    | statusCode |
      | GetAllBatches                   |        200 |
      | GetAllBatchesWithInvalidEndpoint|        404 |
      | GetAllBatchesWithSearchString   |        200 |
      | GetAllBatchesWithoutAuth        |        401 |
      
      
      @getByBatchId
  Scenario Outline: Check user able to Get batch details by batch id
    Given User creates GET request by batchId with "<ScenarioType>" data
    When User sends GET HTTP request with endpoint for get by batch Id "<ScenarioType>"
    Then User receives <statusCode> and with response body for get by batch Id "<ScenarioType>" 

    Examples:
      | ScenarioType                       | statusCode |
      |GetBatchByBatchIDWithoutAuth        |        401 |
      |GetBatchByBatchId                   |        200 |
      |GetBatchWithDeletedBatchId          |        200 |
      |GetBatchWithInvalidEndpoint         |        404 |
      |GetBatchWithInvalidBatchId          |        404 | 
      
      
      @getByBatchName
   Scenario Outline: Check user able to Get batch details by batch name
    Given User creates GET request by batch name with "<ScenarioType>" data
    When User sends GET HTTP request with endpoint for get by batch name "<ScenarioType>"
    Then User receives <statusCode> and with response body for get by batch name "<ScenarioType>"    
      
     Examples:
      |ScenarioType                        | statusCode |
      |GetBatchByBatchNameWithoutAuth      |        401 |
      |GetBatchByBatchName                 |        200 |
      |GetBatchWithInvalidBatchName        |        404 |        
      |GetBatchWithDeletedBatchName        |        200 | 
      
      
    @getByBProgId
   Scenario Outline: Check user able to Get batch details by program Id
    Given User creates GET request by prog Id with "<ScenarioType>" data
    When User sends GET HTTP request with endpoint for get by prog Id  "<ScenarioType>"
    Then User receives <statusCode> and with response body for get by prog Id "<ScenarioType>"  
      
     Examples:
      |ScenarioType                        | statusCode |
      |GetBatchByProgIdWithoutAuth         |        401 |
      |GetBatchByProgId                    |        200 |
      |GetBatchWithInvalidProgId           |        404 |        
      |GetBatchWithDeletedProgId           |        200 |  
      
           
   @delete
Scenario Outline: Check user able to delete batch by ID
    Given User creates Delete request with "<ScenarioType>" data
    When User sends DELETE HTTP request with "<ScenarioType>" endpoint
    Then User receives <statusCode> and with response body for delete "<ScenarioType>" 
      
        Examples:
      | ScenarioType                        | statusCode |
      | DeleteBatchByBatchID                |200         |
      | DeleteBatchWithInvalidEndpoint      |404         |
      | DeleteBatchbyInvalidBatchId         |404         |
      | DeleteBatchWithoutAuth              |401         |
      