package br.com.neoway.firefly.step_definitions;

import org.openqa.selenium.*;

import br.com.neoway.firefly.DriverFactory;
import br.com.neoway.firefly.support.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class WebDriverHooks {
	private final DriverFactory driverFactory;

	public WebDriverHooks(DriverFactory webDriver) {
		this.driverFactory = webDriver;
	}

	@After
	public void finish(Scenario scenario) {
		Log.info("HOOKS AFTER CUCUMBER!");
		try {
			if (scenario.isFailed()) {
				byte[] screenshot = ((TakesScreenshot) driverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			Log.error("Platforms dont support screenshots", somePlatformsDontSupportScreenshots);
		} finally {
			driverFactory.quitDriver();
		}
	}
}
