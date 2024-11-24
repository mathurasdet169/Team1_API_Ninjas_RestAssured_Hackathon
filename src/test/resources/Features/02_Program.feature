#Feature: Program module requests
#
#Background: 
     #Given: Admin sets Authorization 
   #
   #@PostNewProgram  
   #Scenario Outline: Check if Admin able to create a program with valid endpoint and request body
    #Given Admin creates POST request by reading from data file with "<scenario>" and endpoint 
    #When  Admin sends POST Api HTTPS request for given scenario "<scenario>"
    #Then  Admin Validates expectedStatusCode and expectedResMsg for given scenario"<scenario>"
    #Examples:
     #|  scenario               |                         
     #| post_addProgram         | 
     #| post_InvalidEndpoint    | 
     #| post_ExistingProgName   | 
     #| post_InvalidMethod      |
     #| post_InvalidReqBody     |
     #| post_MissingValues      |
     #| post_MissingAdditField  |
     #| post_NullValues         |
     #| post_NoAuth             |
     #
     #
     #
   #@GetAllRequestProgram  
   #Scenario Outline: Check if Admin able to retrieve all programs with valid Endpoint
    #Given Admin creates GETAll request by reading from data file with "<scenario>" and endpoint 
    #When  Admin sends GETAll Api HTTPS request for given scenario "<scenario>"
    #Then  Admin Validates expectedStatusCode and expectedResMsg for given scenario"<scenario>"
    #Examples:
     #|  scenario                  | 
     #| getAll_validEndpoint       | 
     #| getAll_InvalidEndpoint     | 
     #| getAll_InvalidMethod       | 
     #| getAll_NoAuth              | 
     #
     #
   #@GetRequestByProgramID  
   #Scenario Outline: Check if Admin able to update a program with valid programID endpoint and valid request body
    #Given Admin creates GET ProgId Api request by reading from data file with "<scenario>" and endpoint and programId 
    #When  Admin sends GET ProgId HTTPS request for given scenario "<scenario>"
    #Then  Admin Validates expectedStatusCode and expectedResMsg for given scenario"<scenario>"
    #Examples:
     #|  scenario                    | 
     #| getProgId_validProgId        | 
     #| getProgId_InvalidEndpoint    |
     #| getProgId_InvalidProgId      |
     #| getProgId_InvalidBaseUri     | 
     #| getProgId_NoAuth             | 
     #
     #
     #
   #@GetAllProgramsWithAdmins  
   #Scenario Outline: Check if Admin able to retrieve all programs with Admins
    #Given Admin creates GETAll with Admins request from data file with "<scenario>" and endpoint  
    #When  Admin sends GETAll with Admins HTTPS request for given scenario "<scenario>"
    #Then  Admin Validates expectedStatusCode and expectedResMsg for given scenario"<scenario>"
    #Examples:
     #|  scenario                   | 
     #| getAllAdmin_validEndPoint   | 
     #| getAllAdmin_InvalidEndpoint | 
     #| getAllAdmin_InvalidMethod   |
     #| getAllAdmin_NoAuth          | 
     #
     #
   #@PutRequestbyProgramID 
   #Scenario Outline: Check if Admin able to update a program with valid programID endpoint and valid request body
    #Given Admin creates PUT progId request by reading data file with "<scenario>" endpoint and programId 
    #When  Admin sends PUT progId HTTPS request for given scenario "<scenario>"
    #Then  Admin Validates expectedStatusCode and expectedResMsg for given scenario"<scenario>"
    #Examples:
     #|  scenario                  | 
     #| putProgId_validProgId      | 
     #| putProgId_InvalidProgId    | 
     #| putProgId_InvalidBaseURI   |
     #| putProgId_InvalidMethod    |                                 
     #| putProgId_InvalidReqBody   | 
     #| putProgId_MissingReqBody   |
     #| putProgId_NoAuth           | 
     #
    #
  