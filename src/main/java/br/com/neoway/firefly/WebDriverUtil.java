package br.com.neoway.firefly;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
	public void esperaElementoDesaparesser(By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(new DriverFactory().getDriver(), 10, 500);
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(by)));
	}

	public void encontrarUmElementoVisivel(By by) throws Exception {
		WebDriverWait wait = new WebDriverWait(new DriverFactory().getDriver(), 15, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void defineOtempoDeEsperaParaCarregarUmaPagina() throws Exception{
		//default é 0 o que equivale a um tempo limite infinito
		new DriverFactory().getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
	public void esperarAlgoTerminar() throws Exception{
		String searchString = "teste";
		(new WebDriverWait(new DriverFactory().getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driverObject) {
				//algo que ocorra retorne true OK
				return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
			}
		});
	}
	
	//mudar de janela do navegador ou frame driver.switchTo().window("myOtherWindow")
}
