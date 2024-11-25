@ClassFeature
Feature: Class feature of the LMS Portal

  Background: 
    Given The admin is logged in successfully into the LMS application

  @GetAllClassRecordings
  Scenario Outline: Get all class recordings
     #Given Admin creates GET Request for "<Scenario>"
    When Admin sends HTTPS Request for "<Scenario>" with endpoint
    Then Admin receives <exp_statuscode> and Message with response body.

    Examples: 
      | Scenario                                    | exp_statuscode | Message        |
      | Get_AllClassRecordings_With_ValidEndpoint   |            200 | OK             |
      | Get_AllClassRecordings_With_InValidEndpoint |            404 | Not Found      |
      | Get_AllClassRecordings_With_InValidMethod   |            405 | Not Allowed    |
      | Get_AllClassRecordings_With_NoAuth          |            401 | Not Authorized |

  @GetAllClassRecordingWithClassID
  Scenario Outline: Get All ClassRecording With ClassID
    #Given Admin creates GET Request for "<Scenario>"
    When Admin sends HTTPS Request for "<Scenario>" with endpoint
    Then Admin receives <exp_statuscode> and Message with response body.

    Examples: 
      | Scenario                                         | exp_statuscode |
      | Get_ClassRecordingByClassID_With_ValidClassID    |            200 |
      | Get_ClassRecordingByClassID_With_InValidClassID  |            404 |
      | Get_ClassRecordingByClassID_With_InvalidEndpoint |            404 |
      | Get_ClassRecordingByClassID_With_InvalidMethod   |            405 |
      | Get_ClassRecordingByClassID_With_NoAuth          |            401 |

  @GetAllClassRecordingDownloadWithClassID
  Scenario Outline: Get All Class Recording Download With ClassID
    When Admin sends HTTPS Request for "<Scenario>" with endpoint
    Then Admin receives <exp_statuscode> and Message with response body.

    Examples: 
      | Scenario                                        | exp_statuscode |
      | Get_ClassRecordingDownload_With_ValidClassID    |            200 |
      | Get_ClassRecordingDownload_With_InValidClassID  |            404 |
      | Get_ClassRecordingDownload_With_InvalidEndpoint |            404 |
      | Get_ClassRecordingDownload_With_InvalidMethod   |            405 |
      | Get_ClassRecordingDownload_With_NoAuth          |            401 |

  @GetUpcomingClassesWithStudentID
  Scenario Outline: Get Up coming Classes With StudentID
    When Admin sends HTTPS Request for "<Scenario>" with endpoint
    Then Admin receives <exp_statuscode> and Message with response body.

    Examples: 
      | Scenario                                       | exp_statuscode |
      | Get_UpcomingClasses_StudentID                  |            200 |
      | Get_UpcomingClasses_InValidStudentID           |            404 |
      | Get_UpcomingClassesByStudentID_InvalidEndpoint |            404 |
      | Get_UpcomingClassesByStudentID_InvalidMethod   |            405 |
      | Get_UpcomingClassesByStudentID_NoAuth          |            401 |

  @UpdateClassDetailsWithClassID
  Scenario Outline: Update ClassDetails With ClassID
     When Admin sends HTTPS Request with "<Scenario>" update class
    Then Admin receives <exp_statuscode> and Message with response body.

    Examples: 
      | Scenario                               |exp_statuscode |
      | Put_ClassDetails_With_ValidClassID     |200|
      | Put_ClassDetails_With_InValidClassID   |404|
      | Put_ClassDetails_With_InvalidEndpoint  |404|
      | Put_ClassDetails_With_InvalidMethod    |405|
      | Put_ClassDetails_With_NoAuth           |401|
      | Put_ClassDetails_MissingMandtoryFields |400|
      | Put_ClassDetails_With_DeletedBatchID   |400|
      | Put_ClassDetails_With_DeletedClassID   |404|

 @UpdateClassRecordingsWithClassID
  Scenario Outline: Update ClassRecordings With ClassID
  #  Given Admin creates PUT Request for "<Scenario>"
     When Admin sends HTTPS Request with "<Scenario>" update class
    Then Admin receives <exp_statuscode> and Message with response body.

    Examples: 
      | Scenario                               |exp_statuscode |
      | Put_ClassRecordings_ValidClassID     |200|
      | Put_ClassRecordings_InValidClassID   |404|
      | Put_ClassRecordings_With_InvalidEndpoint  |404|
      | Put_Classrecordings_With_InvalidMethod    |405|
      | Put_ClassRecordings_With_NoAuth           |401|
      | Put_ClassRecordings_InvalidData|400|
     

  @DeleteClassWithClassID
  Scenario Outline: Delete all class Details
    Given Admin creates DELETE Request for "<Scenario>"
    When Admin sends HTTPS "<Request>" with "<endpoint>" for delete request
    Then Admin receives <exp_statuscode> and "<Message>" with response body for delete request

    Examples: 
      | Scenario                                 | exp_statuscode | Message        |
      | Delete_ClassDetails_With_InValidClassID  |            404 | OK             |
      | Delete_ClassDetails_With_InValidEndpoint |            404 | Not Found      |
      | Delete_ClassDetails_With_InValidMethod   |            405 | Not Allowed    |
      | Delete_ClassDetails_With_NoAuth          |            401 | Not Authorized |
      | Delete_ClassDetails_With_ValidClassID    |            200 | OK             |
