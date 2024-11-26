Feature: Class feature of the LMS Portal

  Background:
    Given The admin is logged in successfully into the LMS application
       # Given User creates POST requestfor class module 


@PostNewClass
Scenario Outline: Check if admin is able to create class with JSON data
 
    When Admin sends POST HTTP request for class module with "<ScenarioType>" and endpoint
    Then Admin receives <expectedStatusCode> and with response body for all classes for create

    Examples:
      | ScenarioType                           |expectedStatusCode|
      | CreateClassWithoutAuth                 | 401        |
      | CreateClassWithValidData               | 201        |
      | CreateClassExistingClassTopic          | 400        |
      | CreateClassWithMandatoryFieldsOnly     | 201        |
      | CreateClassWithAdditionalFieldValues   | 400        |
      | CreateClassWithInvalidData             | 400        |
      | CreateClassWithoutRequestBody          | 400        |
      | CreateClassWithInvalidEndpoint         | 404        |
     


 @getAllClasses
Scenario Outline: Check if admin is able to retrieve all classes
  When Admin creates GET request for all classes with "<ScenarioType>" data
  Then Admin receives <expectedStatusCode> and with response body for all classes

  Examples:
    | ScenarioType                   | expectedStatusCode |
    | GetAllClassesWithoutAuth       | 401        |
    | GetAllClassesWithValidEndpoint | 200        |
    | GetAllClassesInvalidEndpoint   | 404        |
    | GetAllClassesInvalidMethod     | 405        |
      
@getClassRecordingsByBatchId
Scenario Outline: Check if admin is able to retrieve class recordings by batch ID
 
  When Admin creates GET request for class recordings with "<ScenarioType>" data
  Then Admin receives <expectedStatusCode> and with response body for all classes

  Examples:
    | ScenarioType                       | expectedStatusCode |
    | GetClassRecordingsWithoutAuth      | 401        |
    | GetClassRecordingsWithValidBatchId | 200        |
    | GetClassRecordingsInvalidBatchId   | 404        |
    | GetClassRecordingsInvalidEndpoint  | 404        |
    | GetClassRecordingsInvalidMethod    | 405        |
@getClassDetailsByClassId
Scenario Outline: Check if admin is able to retrieve class details by class ID
  
  When Admin creates GET request for class details with "<ScenarioType>" data
  Then Admin receives <expectedStatusCode> and with response body for all classes

  Examples:
    | ScenarioType                   | expectedStatusCode |
    | GetClassDetailsWithoutAuth     | 401        |
    | GetClassDetailsWithValidClassId | 200       |
    | GetClassDetailsInvalidClassId  | 404        |
    | GetClassDetailsInvalidEndpoint | 404        |
    | GetClassDetailsInvalidMethod   | 405        |
@getAllClassesByClassTopic
Scenario Outline: Check if admin is able to retrieve all classes by class topic

  When Admin creates GET request for classes by topic with "<ScenarioType>" data
  Then Admin receives <expectedStatusCode> and with response body for all classes

  Examples:
    | ScenarioType                      |expectedStatusCode |
    | GetClassesByClassTopicWithoutAuth | 401        |
    | GetClassesByClassTopicValidTopic  | 200        |
    | GetClassesByClassTopicInvalidTopic | 404       |
    | GetClassesByClassTopicInvalidEndpoint | 404     |
    | GetClassesByClassTopicInvalidMethod | 405      |
@getAllClassesByBatchId
Scenario Outline: Check if admin is able to retrieve all classes by batch ID
 
  When Admin creates GET request for classes by batch ID with "<ScenarioType>" data
Then Admin receives <expectedStatusCode> and with response body for all classes

  Examples:
    | ScenarioType                   | expectedStatusCode |
    | GetAllClassesByBatchIdWithoutAuth | 401      |
    | GetAllClassesByBatchIdValidBatchId | 200      |
    | GetAllClassesByBatchIdInvalidBatchId | 404    |
    | GetAllClassesByBatchIdInvalidEndpoint | 404   |
    | GetAllClassesByBatchIdInvalidMethod | 405     |
@getAllClassesByStaffId
Scenario Outline: Check if admin is able to retrieve all classes by staff ID
 
  When Admin creates GET request for classes by staff ID with "<ScenarioType>" data
 Then Admin receives <expectedStatusCode> and with response body for all classes

  Examples:
    | ScenarioType                   | expectedStatusCode |
    | GetAllClassesByStaffIdWithoutAuth | 401      |
    | GetAllClassesByStaffIdValidStaffId | 200      |
    | GetAllClassesByStaffIdInvalidStaffId | 404    |
    | GetAllClassesByStaffIdInvalidEndpoint | 404   |
    | GetAllClassesByStaffIdInvalidMethod | 405     |
    
      