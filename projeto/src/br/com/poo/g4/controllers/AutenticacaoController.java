package br.com.poo.g4.controllers;

import java.io.IOException;

import br.com.poo.g4.services.AutenticacaoService;

public class AutenticacaoController {
	public static void autenticar() {
		AutenticacaoService.autenticacao();
	}

	public static void cadastrar() throws IOException {
		AutenticacaoService.leitorCadastro();

	}
}
