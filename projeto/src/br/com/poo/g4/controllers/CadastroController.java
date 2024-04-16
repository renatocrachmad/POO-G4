package br.com.poo.g4.controllers;

import java.io.IOException;
import br.com.poo.g4.services.CadastroService;

public class CadastroController {
	public static void cadastrar() throws IOException {
		CadastroService.leitorCadastro();

	}

}
