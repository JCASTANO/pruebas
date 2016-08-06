package com.bullying.service.impl;

public class Calculadora {
	
	private int resultado;

	public void sumar(int numero1, int numero2) {
		resultado = numero1 + numero2;
	}

	public int getResult() {
		return resultado;
	}
}