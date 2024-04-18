package br.com.poo.g4.controllers;

import java.io.IOException;

import br.com.poo.g4.services.AutenticacaoService;

public class AutenticacaoController {
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
	public static void autenticar() throws IOException, InterruptedException {
		AutenticacaoService.autenticacao();
=======
	public static void autenticar() {
		//AutenticacaoService.autenticacao();
>>>>>>> bb901a1 feat: Mudança nos menus, estruturação geral do projeto
	}

	public static void cadastrar() throws IOException {
		AutenticacaoService.leitorCadastro();

	}

	public static void logo() {
		AutenticacaoService.logo();
	}
	
}
