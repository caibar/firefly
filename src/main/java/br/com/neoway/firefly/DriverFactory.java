package br.com.neoway.firefly;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.neoway.firefly.config.DriverType;
import br.com.neoway.firefly.helpers.Log;

public class DriverFactory {

	private WebDriver webdriver;
	private DriverType selectedDriverType;

	private final DriverType defaultDriverType = DriverType.FIREFOX;
	private final String browser = System.getProperty("browser", defaultDriverType.toString()).toUpperCase();
	private final String operatingSystem = System.getProperty("os.name").toUpperCase();
	private final String systemArchitecture = System.getProperty("os.arch");
	private final boolean useRemoteWebDriver = Boolean.getBoolean("remoteDriver");

	public WebDriver getDriver() {
		if (null == webdriver) {
			selectedDriverType = determineEffectiveDriverType();
			DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
			instantiateWebDriver(desiredCapabilities);
		}
		return webdriver;
	}

	public void quitDriver() {
		if (null != webdriver) {
			webdriver.quit();
		}
	}

	private DriverType determineEffectiveDriverType() {
		DriverType driverType = defaultDriverType;
		try {
			driverType = DriverType.valueOf(browser);
		} catch (IllegalArgumentException ignored) {
			Log.error("Unknown driver specified, defaulting to '" + driverType + "'...");
		} catch (NullPointerException ignored) {
			Log.error("No driver specified, defaulting to '" + driverType + "'...");
		}
		return driverType;
	}

	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) {
		Log.info(" ");
		Log.info("Current Operating System: " + operatingSystem);
		Log.info("Current Architecture: " + systemArchitecture);
		Log.info("Current Browser Selection: " + selectedDriverType);
		Log.info(" ");
		if (useRemoteWebDriver) {
			instantiateRemoteWebDriver(desiredCapabilities);
		} else {
			webdriver = selectedDriverType.getWebDriverObject(desiredCapabilities);
		}
	}

	private void instantiateRemoteWebDriver(DesiredCapabilities desiredCapabilities) {
		try {
			URL seleniumGridURL = new URL(System.getProperty("gridURL"));
			String desiredBrowserVersion = System.getProperty("desiredBrowserVersion");
			String desiredPlatform = System.getProperty("desiredPlatform");
			if (null != desiredPlatform && !desiredPlatform.isEmpty()) {
				desiredCapabilities.setPlatform(Platform.valueOf(desiredPlatform.toUpperCase()));
			}
			if (null != desiredBrowserVersion && !desiredBrowserVersion.isEmpty()) {
				desiredCapabilities.setVersion(desiredBrowserVersion);
			}
			webdriver = new RemoteWebDriver(seleniumGridURL, desiredCapabilities);
		} catch (MalformedURLException urlException) {
			Log.error("Error specified URL seleniumGrid" + urlException.getMessage());
			urlException.printStackTrace();
			// TODO verificar esse tratamento de erro pois o sistema tem que ser
			// encerrado cosso passe aqui.
		}
	}
}