package com.api.hooks;


import java.io.IOException;

import com.api.utilities.CommonUtils;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void setUp(Scenario scenario) throws IOException {
		CommonUtils.setBaseUrl();
		CommonUtils.setBaseRequest_withoutBearer();
		
        
    }


}

