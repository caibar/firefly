package br.com.neoway.firefly.tests;

import org.junit.Test;

import br.com.neoway.firefly.DriverFactory;

public class DriverFactoryTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void incorrectUrlOfWebDriverRemote() {
		System.setProperty("remoteDriver", "true");
		System.setProperty("gridURL", "htrf://testgridurl.com.br");
		new DriverFactory().getDriver();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void emptyUrlOfWebDriverRemote() {
		System.setProperty("remoteDriver", "true");
		System.setProperty("gridURL", "");
		new DriverFactory().getDriver();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void blankUrlOfWebDriverRemote() {
		System.setProperty("remoteDriver", "true");
		System.setProperty("gridURL", " ");
		new DriverFactory().getDriver();
	}
	
}
