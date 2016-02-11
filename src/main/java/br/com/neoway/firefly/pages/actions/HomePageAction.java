package br.com.neoway.firefly.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.neoway.firefly.pages.HomePage;

public class HomePageAction extends HomePage {

	WebDriverWait wait;

	public HomePageAction(EventFiringWebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10, 100);
	}


	public void isHomesectionDisplayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(displayLocation));
	}
}
