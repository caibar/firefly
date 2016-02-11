package br.com.neoway.login.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.neoway.automation.base.ApplicationsEnum;
import br.com.neoway.automation.base.framework.ConfigManagerUtil;
import br.com.neoway.automation.base.framework.WebDriverUtil;

public class PageLogin {

	private static final int TIMEOUT_IN_SECONDS = 5;
	private static final int POOL_TIME_IN_MILISECONDS = 100;

	private WebDriverWait wait;

	@FindBy(name = "username")
	private WebElement usernameField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(css = ".btn")
	private WebElement loginButton;
	@FindBy(className = "login-errors")
	private WebElement loginErrorMessage;

	public PageLogin() {
		PageFactory.initElements(WebDriverUtil.getDriver(), this);
		wait = new WebDriverWait(WebDriverUtil.getDriver(), TIMEOUT_IN_SECONDS, POOL_TIME_IN_MILISECONDS);
	}

	public void defaultLogin(ApplicationsEnum application) {
		enterApplication();
		assignDefaultUser();
		assignDefaultPassword();
		clickLoginButton();

		PageSimm pageSimm = new PageSimm();
		pageSimm.accessSpecificModule(application);
	}

	public void login(ApplicationsEnum application, String user, String password) {
		enterApplication();
		assignUser(user);
		assignPassword(password);
		clickLoginButton();

		PageSimm pageSimm = new PageSimm();
		pageSimm.accessSpecificModule(application);
	}

	public void enterApplication() {
		WebDriverUtil.getDriver().get(ConfigManagerUtil.getString("LOGIN_URL"));
		validateLoginPage();
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}

	public void assignDefaultUser() {
		wait.until(ExpectedConditions.elementToBeClickable(usernameField));
		usernameField.sendKeys(ConfigManagerUtil.getString("LOGIN"));
	}

	public void assignUser(String user) {
		wait.until(ExpectedConditions.elementToBeClickable(usernameField));
		usernameField.sendKeys(user);
	}

	public void assignDefaultPassword() {
		wait.until(ExpectedConditions.elementToBeClickable(passwordField));
		passwordField.sendKeys(ConfigManagerUtil.getString("PASSWORD"));
	}

	public void assignPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(passwordField));
		passwordField.sendKeys(password);
	}

	public void validateErrorMessageWhenTryToLogin() {
		wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
	}

	public void validateLoginPage() {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
	}

}