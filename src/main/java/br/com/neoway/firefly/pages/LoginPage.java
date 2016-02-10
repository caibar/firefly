package br.com.neoway.firefly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id = "login_field")
	protected WebElement login;
	@FindBy(id = "password")
	protected WebElement password;
	@FindBy(name = "commit")
	protected WebElement signinButton;
	@FindBy(xpath = ".//div[@id='site-container']/div/div")
	protected WebElement errorMessage;
	protected By formBodyLocation = By.className("auth-form-body");

}
