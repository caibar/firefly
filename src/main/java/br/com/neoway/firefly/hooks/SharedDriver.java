package br.com.neoway.firefly.hooks;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import br.com.neoway.firefly.config.DriverFactory;
import br.com.neoway.firefly.support.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SharedDriver extends EventFiringWebDriver {

	private static final WebDriver REAL_DRIVER = new DriverFactory().getDriver();;
	private static final Thread CLOSE_THREAD = new Thread() {
		@Override
		public void run() {
			REAL_DRIVER.quit();
		}
	};

	static {
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}

	public SharedDriver() {
		super(REAL_DRIVER);
	}

	@Override
	public void close() {
		if (Thread.currentThread() != CLOSE_THREAD) {
			throw new UnsupportedOperationException(
					"You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
		}
		super.close();
	}

	public static WebDriver getDriver(){
		return REAL_DRIVER;
	}
	
	@Before
	public void deleteAllCookies() {
		manage().deleteAllCookies();
	}

	@After
	public void embedScreenshot(Scenario scenario) {
		Log.info("HOOKS AFTER CUCUMBER!");
		try {
			if (scenario.isFailed()) {
				scenario.write("Current Page URL is " + getCurrentUrl());
				byte[] screenshot = getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			Log.error("Platforms dont support screenshots", somePlatformsDontSupportScreenshots);
		}
	}
}
