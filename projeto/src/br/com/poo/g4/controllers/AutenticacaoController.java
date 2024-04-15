package br.com.poo.g4.controllers;

import br.com.poo.g4.services.AutenticacaoService;

public class AutenticacaoController {
	public static void autenticar() {
		AutenticacaoService.autenticacao();
	}
}
