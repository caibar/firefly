package br.com.neoway.firefly.support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import br.com.neoway.firefly.config.DriverFactory;

public class WebDriverUtil {
	public void esperaElementoDesaparesser(By by) {
		WebDriverWait wait = new WebDriverWait(new DriverFactory().getDriver(), 10, 500);
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(by)));
	}

	public void encontrarUmElementoVisivel(By by) {
		WebDriverWait wait = new WebDriverWait(new DriverFactory().getDriver(), 15, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void defineOtempoDeEsperaParaCarregarUmaPagina() {
		// default é 0 o que equivale a um tempo limite infinito
		new DriverFactory().getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	public void esperarAlgoTerminar() {
		String searchString = "teste";
		(new WebDriverWait(new DriverFactory().getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driverObject) {
				// algo que ocorra retorne true OK
				return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
			}
		});
	}

	// mudar de janela do navegador ou frame
	// driver.switchTo().window("myOtherWindow")
}
