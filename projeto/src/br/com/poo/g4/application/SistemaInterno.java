package br.com.poo.g4.application;

import java.io.IOException;

import br.com.poo.g4.controllers.AutenticacaoController;
import br.com.poo.g4.io.RelatorioIO;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, InterruptedException {
		RelatorioIO.leitor("banco");
		RelatorioIO.relatorioAgencia("001");
		AutenticacaoController.autenticar();
//		MenuService.menu();
	}

}
