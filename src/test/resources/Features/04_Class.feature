Feature: Class feature of the LMS Portal

  Background:
    Given The admin is logged in successfully into the LMS application

  @GetAllClass
 Scenario Outline: Admin retrieves all classes with different conditions
  Given Admin creates GET Request for "<Scenario>"
  When Admin sends HTTPS "<Request>" with "<endpoint>"
  Then Admin receives <exp_statuscode> and "<Message>" with response body.

Examples: 
  | Scenario                            | exp_statuscode | endpoint   | Request   | Message         |
  | Get_AllClasses_With_ValidEndpoint    | 200            | allClasses | Valid     | OK              |
  | Get_AllClasses_With_InvalidEndpoint  | 404            | allClas    | Valid     | Not Found       |
  | Get_AllClasses_With_NoAuth           | 401            | allClasses | Valid     | Not Allowed     |
  | Get_AllClasses_With_InvalidMethod    | 405            | allClasses | Invalid   | Not Authorized  |
