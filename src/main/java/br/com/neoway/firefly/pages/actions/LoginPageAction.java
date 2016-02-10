package br.com.neoway.firefly.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.neoway.firefly.DriverFactory;
import br.com.neoway.firefly.pages.LoginPage;

public class LoginPageAction extends LoginPage {
	WebDriverWait wait;
	DriverFactory driver;
	public LoginPageAction(DriverFactory driver) {
		PageFactory.initElements(driver.getDriver(), this);
		wait = new WebDriverWait(driver.getDriver(), 10, 500);
		this.driver = driver;
	}

	public void isloginsectionDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(formBodyLocation));
		wait.until(ExpectedConditions.elementToBeClickable(signinButton));
	}

	public void clickSigninButton(){
		signinButton.click();
	}
	
	public void enterSite(){
		driver.getDriver().get("https://github.com/");
	}

	public void preencherLogin(String userName) {
		login.sendKeys(userName);
	}

	public void preencherPassword(String password) {
		this.password.sendKeys(password);
	}

	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.getText();
	}
}
