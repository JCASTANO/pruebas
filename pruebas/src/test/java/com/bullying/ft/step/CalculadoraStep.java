package com.bullying.ft.step;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.bullying.ft.base.page.Page;
import com.bullying.ft.page.CalculadoraPage;

public class CalculadoraStep {

    private CalculadoraPage calcPagina;
	
    public CalculadoraStep(Page pages) {
	  calcPagina = pages.getCalculadoraPagina();
	}
	
	@Given("que estoy en la pagina de la calculadora")
	public void givenQueEstoyEnLaPaginaDeLaCalculadora(){
		calcPagina = calcPagina.open(); 
	}
	
	@When("ingreso los valores para sumar <numero1> + <numero2>")
	public void  whenIngresoLosValoresParaSumar(@Named("numero1")String numero1, @Named("numero2")String numero2){
		calcPagina = calcPagina.ingresarValores(numero1, numero2);
		calcPagina = calcPagina.sumar();
	}
	 
	@Then("obtengo <resultado>")
	public void thenObtengo(@Named("resultado")String resultado) {
		Assert.assertEquals(resultado, calcPagina.obtenerResultado());
	}
}
