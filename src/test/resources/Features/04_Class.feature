@ClassFeature
Feature: Class feature of the LMS Portal

  Background: 
    Given The admin is logged in successfully into the LMS application

  @PostNewClass
  Scenario Outline: Check if admin is able to create class with JSON data
    When Admin sends POST HTTP request for class module with "<ScenarioType>" and endpoint
    Then Admin receives <expectedStatusCode> and with response body for all classes for create

    Examples: 
      | ScenarioType                         | expectedStatusCode |
      | CreateClassWithoutAuth               |                401 |
      | CreateClassWithValidData             |                201 |
      | CreateClassExistingClassTopic        |                400 |
      | CreateClassWithMandatoryFieldsOnly   |                201 |
      | CreateClassWithAdditionalFieldValues |                400 |
      | CreateClassWithInvalidData           |                400 |
      | CreateClassWithoutRequestBody        |                400 |
      | CreateClassWithInvalidEndpoint       |                404 |

  @getAllClasses
  Scenario Outline: Check if admin is able to retrieve all classes
    When Admin creates GET request for all classes with "<ScenarioType>" data
    Then Admin receives <expectedStatusCode> and with response body for all classes

    Examples: 
      | ScenarioType                   | expectedStatusCode |
      | GetAllClassesWithoutAuth       |                401 |
      | GetAllClassesWithValidEndpoint |                200 |
      | GetAllClassesInvalidEndpoint   |                404 |
      | GetAllClassesInvalidMethod     |                405 |

  @getClassRecordingsByBatchId
  Scenario Outline: Check if admin is able to retrieve class recordings by batch ID
    When Admin creates GET request for class recordings with "<ScenarioType>" data
    Then Admin receives <expectedStatusCode> and with response body for all classes

    Examples: 
      | ScenarioType                       | expectedStatusCode |
      | GetClassRecordingsWithoutAuth      |                401 |
      | GetClassRecordingsWithValidBatchId |                200 |
      | GetClassRecordingsInvalidBatchId   |                404 |
      | GetClassRecordingsInvalidEndpoint  |                404 |
      | GetClassRecordingsInvalidMethod    |                405 |

  @getClassDetailsByClassId
  Scenario Outline: Check if admin is able to retrieve class details by class ID
    When Admin creates GET request for class details with "<ScenarioType>" data
    Then Admin receives <expectedStatusCode> and with response body for all classes

    Examples: 
      | ScenarioType                    | expectedStatusCode |
      | GetClassDetailsWithoutAuth      |                401 |
      | GetClassDetailsWithValidClassId |                200 |
      | GetClassDetailsInvalidClassId   |                404 |
      | GetClassDetailsInvalidEndpoint  |                404 |
      | GetClassDetailsInvalidMethod    |                405 |

  @getAllClassesByClassTopic
  Scenario Outline: Check if admin is able to retrieve all classes by class topic
    When Admin creates GET request for classes by topic with "<ScenarioType>" data
    Then Admin receives <expectedStatusCode> and with response body for all classes

    Examples: 
      | ScenarioType                          | expectedStatusCode |
      | GetClassesByClassTopicWithoutAuth     |                401 |
      | GetClassesByClassTopicValidTopic      |                200 |
      | GetClassesByClassTopicInvalidTopic    |                404 |
      | GetClassesByClassTopicInvalidEndpoint |                404 |
      | GetClassesByClassTopicInvalidMethod   |                405 |

  @getAllClassesByBatchId
  Scenario Outline: Check if admin is able to retrieve all classes by batch ID
    When Admin creates GET request for classes by batch ID with "<ScenarioType>" data
    Then Admin receives <expectedStatusCode> and with response body for all classes

    Examples: 
      | ScenarioType                          | expectedStatusCode |
      | GetAllClassesByBatchIdWithoutAuth     |                401 |
      | GetAllClassesByBatchIdValidBatchId    |                200 |
      | GetAllClassesByBatchIdInvalidBatchId  |                404 |
      | GetAllClassesByBatchIdInvalidEndpoint |                404 |
      | GetAllClassesByBatchIdInvalidMethod   |                405 |

  @getAllClassesByStaffId
  Scenario Outline: Check if admin is able to retrieve all classes by staff ID
    When Admin creates GET request for classes by staff ID with "<ScenarioType>" data
    Then Admin receives <expectedStatusCode> and with response body for all classes

    Examples: 
      | ScenarioType                          | expectedStatusCode |
      | GetAllClassesByStaffIdWithoutAuth     |                401 |
      | GetAllClassesByStaffIdValidStaffId    |                200 |
      | GetAllClassesByStaffIdInvalidStaffId  |                404 |
      | GetAllClassesByStaffIdInvalidEndpoint |                404 |
      | GetAllClassesByStaffIdInvalidMethod   |                405 |

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
      | Scenario                               | exp_statuscode |
      | Put_ClassDetails_With_ValidClassID     |            200 |
      | Put_ClassDetails_With_InValidClassID   |            404 |
      | Put_ClassDetails_With_InvalidEndpoint  |            404 |
      | Put_ClassDetails_With_InvalidMethod    |            405 |
      | Put_ClassDetails_With_NoAuth           |            401 |
      | Put_ClassDetails_MissingMandtoryFields |            400 |
      | Put_ClassDetails_With_DeletedBatchID   |            400 |
      | Put_ClassDetails_With_DeletedClassID   |            404 |

  @UpdateClassRecordingsWithClassID
  Scenario Outline: Update ClassRecordings With ClassID
    #  Given Admin creates PUT Request for "<Scenario>"
    When Admin sends HTTPS Request with "<Scenario>" update class
    Then Admin receives <exp_statuscode> and Message with response body.

    Examples: 
      | Scenario                                 | exp_statuscode |
      | Put_ClassRecordings_ValidClassID         |            200 |
      | Put_ClassRecordings_InValidClassID       |            404 |
      | Put_ClassRecordings_With_InvalidEndpoint |            404 |
      | Put_Classrecordings_With_InvalidMethod   |            405 |
      | Put_ClassRecordings_With_NoAuth          |            401 |
      | Put_ClassRecordings_InvalidData          |            400 |

  @DeleteClassWithClassID
  Scenario Outline: Delete all class Details
    When Admin sends HTTPS Request for "<Scenario>" with endpoint
    Then Admin receives <exp_statuscode> and Message with response body.

    Examples: 
      | Scenario                                 | exp_statuscode | Message        |
      | Delete_ClassDetails_With_InValidClassID  |            404 | OK             |
      | Delete_ClassDetails_With_InValidEndpoint |            404 | Not Found      |
      | Delete_ClassDetails_With_InValidMethod   |            405 | Not Allowed    |
      | Delete_ClassDetails_With_NoAuth          |            401 | Not Authorized |
      | Delete_ClassDetails_With_ValidClassID    |            200 | OK             |
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
     