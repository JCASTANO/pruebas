package com.bullying.ft.page;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import com.bullying.ft.base.page.AbstractPage;

public class CalculadoraPage extends AbstractPage {
	
	private static final String PAGE_URL = "http://localhost:9003/app/index2.html";
	private static final String RESULTADO = "resultado";
	private static final String BTN_SUMAR = "btnSumar";
	private static final String NUMERO2 = "numero2";
	private static final String NUMERO1 = "numero1";

	public CalculadoraPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public CalculadoraPage open() {
		get(PAGE_URL);
		waitForId(NUMERO1);
		return this;
	}
	
	public CalculadoraPage ingresarValores(String  operando1, String operando2) {
		findElement(By.id(NUMERO1)).sendKeys(operando1);
		findElement(By.id(NUMERO2)).sendKeys(operando2);
		return this;
	}
	
	public CalculadoraPage sumar() {
		findElement(By.name(BTN_SUMAR)).click();
		return this;
	}

	public String obtenerResultado(){ 
		waitForId(RESULTADO);
		return findElement(By.id(RESULTADO)).getText();
	}
}
