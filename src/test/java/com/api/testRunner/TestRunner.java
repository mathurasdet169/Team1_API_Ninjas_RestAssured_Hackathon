package com.api.testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
	@CucumberOptions (
		       	  
				
				  features={"./src/test/resources/Features"},
						 		 
				  glue = "com.api.stepDef",
				  plugin = {"pretty", "html:reports/cucumberReport.html", //----Cucumber Report
						  "rerun:target/rerun.txt",
						
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",//---Extent Report
	             "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",//--------cucumber Report
						  "timeline:target/timeline" //-----Timeline report
						   },
				  dryRun = false,
				  monochrome = true,
				  publish = true
				 
			)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	 
	 
}
