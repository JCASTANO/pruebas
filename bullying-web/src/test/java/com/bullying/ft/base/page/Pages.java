package com.bullying.ft.base.page;

import org.jbehave.web.selenium.WebDriverProvider;

import com.bullying.ft.page.CalculadoraPage;

public class Pages {

	private final WebDriverProvider driverProvider;
	private CalculadoraPage calculadoraPagina;
	
	public Pages(WebDriverProvider driverProvider) {
		this.driverProvider = driverProvider;
	}
	
	public CalculadoraPage getCalculadoraPagina() {
		calculadoraPagina = new CalculadoraPage(driverProvider);
		return calculadoraPagina;
	}	
}
