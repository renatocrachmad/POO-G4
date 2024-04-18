package br.com.poo.g4.application;

import java.io.IOException;

import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.services.AutenticacaoService;
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
=======
import br.com.poo.g4.services.MenuService;
>>>>>>> bb901a1 feat: Mudança nos menus, estruturação geral do projeto

public class SistemaInterno {

	public static void main(String[] args) throws IOException, InterruptedException {
		RelatorioIO.leitor("banco");
		AutenticacaoService.verificacao();
	}

}