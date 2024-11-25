Feature: Program module requests

Background: 
     Given: Admin sets Authorization 
   
   @PostNewProgram  
   Scenario Outline: Check if Admin able to create a program with valid endpoint and request body
    Given Admin creates POST request by reading from data file with "<scenario>" and endpoint "<endpoint>"
    When  Admin sends POST Api HTTPS request
    Then  Admin Validates "<expectedStatusCode>" updated Status with response body "<expectedResMsg>"
    Examples:
     |  scenario               | expectedStatusCode | endpoint    | expectedResMsg                               |
     | post_addProgram         | 201                | saveprogram |"Created"                                     | 
     | post_InvalidEndpoint    | 404                | saveprogram |"Not Found"                                   |
     | post_ExistingProgName   | 400                | saveprogram |"cannot create program , since already exists"|
     | post_InvalidMethod      | 405                | saveprogram |"Method Not Allowed"                          |
     | post_InvalidReqBody     | 400                | saveprogram |"Bad Request"                                 |
     | post_MissingValues      | 400                | saveprogram |"Invalid Status: must be Active or Inactive   |
     | post_MissingAdditField  | 201                | saveprogram |"Created"                                     |
     | post_NullValues         | 500                | saveprogram |"Internal Server Error"                       |
     | post_NoAuth             | 401                | saveprogram |"Unauthorized"                                |
     
     
   @GetAllRequestProgram  
   Scenario Outline: Check if Admin able to retrieve all programs with valid Endpoint
    Given Admin creates GETAll request by reading from data file with "<scenario>" and endpoint "<endpoint>"
    When  Admin sends GETAll Api HTTPS request
    Then  Admin receives "<expectedStatusCode>" updated Status with response body "<expectedResMsg>"
    Examples:
     |  scenario                  | expectedStatusCode | endpoint    |expectedResMsg      |
     | getAll_validEndpoint       | 200                | allPrograms |"OK"                |
     | getAll_InvalidEndpoint     | 404                | invalidPath |"Not Found"         |
     | getAll_InvalidMethod       | 405                | allPrograms |"Method Not Allowed"|
     | getAll_NoAuth              | 401                | allPrograms |"Unauthorized"      |
     
     
   @GetRequestByProgramID  
   Scenario Outline: Check if Admin able to update a program with valid programID endpoint and valid request body
    Given Admin creates GET ProgId Api request by reading from data file with "<scenario>" and endpoint "<endpoint>" and programId "<programId>"
    When  Admin sends GET ProgId "<programId>" HTTPS request
    Then  Admin receives "<expectedStatusCode>" updated Status with response body
    Examples:
     |  scenario                    | expectedStatusCode | endpoint             |"<expectedResMsg>"  |
     | getProgId_validProgId        | 200                | programs/{programId} |"OK"                |
     | getProgId_InvalidEndpoint    | 404                | programs/{programId} |"Not Found"         |
     | getProgId_InvalidProgId      | 404                | programs/{programId} |"Not Found"         |
     | getProgId_InvalidBaseUri     | 404                | programs/{programId} |"Not Found"         |
     | getProgId_NoAuth             | 401                | programs/{programId} |"Unauthorized"      |
     
     
     
   @GetAllProgramsWithAdmins  
   Scenario Outline: Check if Admin able to retrieve all programs with Admins
    Given Admin creates GETAll with Admins request from data file with "<scenario>" and endpoint "<endpoint>" 
    When  Admin sends GETAll with Admins HTTPS request
    Then  Admin receives "<expectedStatusCode>" updated Status with response body "<expectedResMsg>"
    Examples:
     |  scenario                   | expectedStatusCode | endpoint             |"<expectedResMsg>"  |
     | getAllAdmin_validEndPoint   | 200                | allProgramsWithUsers |"Not Found"         |
     | getAllAdmin_InvalidEndpoint | 404                | allProgramsWithUsers |"Not Found"         |
     | getAllAdmin_InvalidMethod   | 405                | allProgramsWithUsers |"Method Not Allowed"|
     | getAllAdmin_NoAuth          | 401                | allProgramsWithUsers |"Unauthorized"      |
     
     
   @PutRequestbyProgramID 
   Scenario Outline: Check if Admin able to update a program with valid programID endpoint and valid request body
    Given Admin creates PUT progId request by reading data file with "<scenario>" and endpoint "<endpoint>" and programId "<programId>"
    When  Admin sends PUT progId HTTPS request
    Then  Admin receives "<expectedStatusCode>" updated Status with response body
    Examples:
     |  scenario                  | expectedStatusCode | endpoint               |expectedResMsg      |
     | putProgId_validProgId      | 200                | putprogram/{programId} |"OK"                |
     | putProgId_InvalidProgId    | 404                | putprogram/{programId} |"Not Found"         |
     | putProgId_InvalidBaseURI   | 404                | putprogram/{programId} |"Not Found"         |
     | putProgId_InvalidMethod    | 405                | putprogram/{programId} |"Method Not Allowed"|                                  
     | putProgId_InvalidReqBody   | 400                | putprogram/{programId} |"Bad Request"       |
     | putProgId_MissingReqBody   | 400                | putprogram/{programId} |"Bad Request"       |
     | putProgId_NoAuth           | 401                | putprogram/{programId} |"Unauthorized"      | 
     
    
  