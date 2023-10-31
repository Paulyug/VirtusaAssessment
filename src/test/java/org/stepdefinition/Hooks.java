package org.stepdefinition;

import org.utility.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utilities {
	@Before
	public void setup() {
		openBrowser();
		implicitWait(20);

	}
	
	@After
	public void tearDown(Scenario sc) {
		screenshot(sc.getName());
		closeBrowser();

	}

}
