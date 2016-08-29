package com.pruebas.ft.base.page;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public abstract class AbstractPage extends WebDriverPage {
	
	private static final int TIMEOUT = 30;
	private static final int POLLING_EVRY = 1;
	
	public AbstractPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public void waitForId(final String id) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriverProvider()
				.get()).withTimeout(TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(POLLING_EVRY, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(id));
			}
		});
	}
}
