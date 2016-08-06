package com.bullying.ft;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.bullying.service.impl.Calculadora;

public class CalculadoraSteps {
	
	private Calculadora calculadora;

	@Given("una calculadora")
	public void given() {
		calculadora = new Calculadora();
	}

	@When("<numero1> + <numero2>")
	public void when(@Named("numero1") int numero1, @Named("numero2") int numero2) {
		calculadora.sumar(numero1, numero2);
	}

	@Then("resultado sera <resultado>")
	public void then(@Named("resultado") int resultado) {
		Assert.assertEquals(calculadora.getResult(), resultado);
	}
}