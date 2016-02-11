package br.com.neoway.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.neoway.automation.base.ApplicationsEnum;
import br.com.neoway.automation.base.framework.WebDriverUtil;

public class PageSimm {

	private static final int TIMEOUT_IN_SECONDS = 5;
	private static final int POOL_TIME_IN_MILISECONDS = 100;

	private WebDriverWait wait;

	@FindBy(className = "user-name")
	private WebElement userName;
	@FindBy(css = ".user-config > a")
	private WebElement logout;
	@FindBy(xpath = "//h1[@ng-click=\"app.open('profiles')\"]")
	private WebElement appProfiles;
	@FindBy(xpath = "//h1[@ng-click=\"app.open('leads')\"]")
	private WebElement appLeads;
	@FindBy(xpath = "//h1[@ng-click=\"app.open('dashboard')\"]")
	private WebElement appDashboard;
	@FindBy(xpath = "//h1[@ng-click=\"app.open('maps')\"]")
	private WebElement appMaps;
	@FindBy(xpath = "//h1[@ng-click=\"app.open('pathfinder')\"]")
	private WebElement appPathfinder;
	@FindBy(xpath = "//h1[@ng-click=\"app.open('admin')\"]")
	private WebElement appAdmin;

	public PageSimm() {
		PageFactory.initElements(WebDriverUtil.getDriver(), this);
		wait = new WebDriverWait(WebDriverUtil.getDriver(), TIMEOUT_IN_SECONDS, POOL_TIME_IN_MILISECONDS);
	}

	public void accessSpecificModule(ApplicationsEnum application) {
		WebElement applicationImageElement = null;

		switch (application) {
		case ADMIN:
			applicationImageElement = appAdmin;
			break;
		case LEADS:
			applicationImageElement = appLeads;
			break;
		case MAPS:
			applicationImageElement = appMaps;
			break;
		case PATHFINDER:
			applicationImageElement = appPathfinder;
			break;
		default:
			applicationImageElement = appProfiles;
			break;
		}

		wait.until(ExpectedConditions.elementToBeClickable(applicationImageElement));
		applicationImageElement.click();
	}
	
	public String getUserName() {
		return userName.getText();
	}
	
	public void logoutSimm() {
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}

	public void validateAccess() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("application-list")));
	}

}