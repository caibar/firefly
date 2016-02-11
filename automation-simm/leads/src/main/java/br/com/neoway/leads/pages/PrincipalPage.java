package br.com.neoway.leads.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrincipalPage {

	@FindBy(linkText = "Sign in")
	protected WebElement signIn;
	protected By signInLocation = By.linkText("Sign in");

}