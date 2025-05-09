package main;

import java.math.BigDecimal;

import main.model.service.ClienteService;
import main.model.service.PlanoService;

public class Main {
	public static void main (String[] args) {
		BigDecimal valor = new BigDecimal("50.00");
		PlanoService.createPlano(30, valor);
	}
}
