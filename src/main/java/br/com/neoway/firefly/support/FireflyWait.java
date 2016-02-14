package br.com.neoway.firefly.support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.neoway.firefly.hooks.SharedDriver;

public class FireflyWait {
	
	public static void esperaElementoDesaparesser(By by) {
		WebDriverWait wait = new WebDriverWait(SharedDriver.getDriver(), 10, 500);
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(by)));
	}

	public static void encontrarUmElementoVisivel(By by) {
		WebDriverWait wait = new WebDriverWait(SharedDriver.getDriver(), 15, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void defineOtempoDeEsperaParaCarregarUmaPagina() {
		// default é 0 o que equivale a um tempo limite infinito
		SharedDriver.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	public static void esperarAlgoTerminar() {
		String searchString = "teste";
		(new WebDriverWait(SharedDriver.getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driverObject) {
				// algo que ocorra retorne true OK
				return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
			}
		});
	}

	// mudar de janela do navegador ou frame
	// driver.switchTo().window("myOtherWindow")
}
