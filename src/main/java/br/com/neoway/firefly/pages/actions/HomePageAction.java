package br.com.neoway.firefly.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.neoway.firefly.DriverFactory;
import br.com.neoway.firefly.pages.HomePage;

public class HomePageAction extends HomePage {

	WebDriverWait wait;

	public HomePageAction(DriverFactory driver) {
		PageFactory.initElements(driver.getDriver(), this);
		wait = new WebDriverWait(driver.getDriver(), 10, 100);
	}


	public void isHomesectionDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(displayLocation));
	}
}
