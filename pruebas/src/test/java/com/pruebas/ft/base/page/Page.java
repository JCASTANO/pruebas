package com.pruebas.ft.base.page;

import org.jbehave.web.selenium.WebDriverProvider;

import com.pruebas.ft.page.CalculadoraPage;

public class Page {

	private WebDriverProvider driverProvider;
	
	public Page(WebDriverProvider driverProvider) {
		this.driverProvider = driverProvider;
	}
	
	public CalculadoraPage getCalculadoraPagina() {
		return new CalculadoraPage(driverProvider);
	}	
}
