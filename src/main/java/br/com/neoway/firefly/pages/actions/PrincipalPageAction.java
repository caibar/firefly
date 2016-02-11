package br.com.neoway.firefly.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.neoway.firefly.pages.PrincipalPage;

public class PrincipalPageAction extends PrincipalPage {

	WebDriverWait wait;

	public PrincipalPageAction(EventFiringWebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10, 100);
	}

	public boolean ishomepageDisplayed() throws Exception {
		wait.until(ExpectedConditions.presenceOfElementLocated(signInLocation));
		return signIn.isDisplayed();
	}

	public void clickSigninLink() throws Exception {
		signIn.click();
	}
}
