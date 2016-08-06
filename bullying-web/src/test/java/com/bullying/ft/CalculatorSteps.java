package com.bullying.ft;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.bullying.other.Calculator;

public class CalculatorSteps {
	private Calculator calculator;

	@Given("a calculator")
	public void givenACalculator() {
		calculator = new Calculator();
	}

	@When("<number1> + <number2>")
	public void whenIAddNumber1AndNumber2(@Named("number1") int number1, @Named("number2") int number2) {
		calculator.add(number1, number2);
	}

	@Then("result should be <result>")
	public void thenTheOutcomeShould(@Named("result") int result) {
		Assert.assertEquals(calculator.getResult(), result);
	}
}