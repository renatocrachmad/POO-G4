package br.com.poo.g4.application;

import java.io.IOException;

import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.services.AutenticacaoService;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, InterruptedException {
		RelatorioIO.leitor("banco");
		AutenticacaoService.verificacao();
	}

}