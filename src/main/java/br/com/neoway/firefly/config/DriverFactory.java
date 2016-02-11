package br.com.neoway.firefly.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.neoway.firefly.support.Log;

public class DriverFactory {

	private DriverType selectedDriverType;

	private final DriverType defaultDriverType = DriverType.FIREFOX;
	private final String browser = System.getProperty("browser", defaultDriverType.toString()).toUpperCase();
	private final String operatingSystem = System.getProperty("os.name").toUpperCase();
	private final String systemArchitecture = System.getProperty("os.arch");
	private final boolean useRemoteWebDriver = Boolean.getBoolean("remoteDriver");

	public WebDriver getDriver() {
		selectedDriverType = determineEffectiveDriverType();
		DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
		return instantiateWebDriver(desiredCapabilities);
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

	private WebDriver instantiateWebDriver(DesiredCapabilities desiredCapabilities) {
		Log.info(infoInstantiateWebDriver());
		if (useRemoteWebDriver) {
			return getRemoteWebDriverObject(desiredCapabilities);
		}
		return selectedDriverType.getWebDriverObject(desiredCapabilities);
	}

	private String infoInstantiateWebDriver() {
		StringBuilder infoBuilder = new StringBuilder("Start Firefly WebDriver:");
		infoBuilder.append("\n\tCurrent Operating System: ").append(operatingSystem);
		infoBuilder.append("\n\tCurrent Architecture: ").append(systemArchitecture);
		infoBuilder.append("\n\tCurrent Browser Selection: ").append(browser);
		infoBuilder.append("\n\tUsing remote WebDriver: ").append(useRemoteWebDriver);
		return infoBuilder.toString();
	}

	private WebDriver getRemoteWebDriverObject(DesiredCapabilities desiredCapabilities) {
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
			return new RemoteWebDriver(seleniumGridURL, desiredCapabilities);
		} catch (MalformedURLException urlException) {
			Log.error("URL seleniumGrid specified incorrect:", urlException);
			throw new IllegalArgumentException(urlException);
		}
	}
}