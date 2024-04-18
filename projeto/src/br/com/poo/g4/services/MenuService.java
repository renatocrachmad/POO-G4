package br.com.poo.g4.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.controllers.AutenticacaoController;
import br.com.poo.g4.util.Util;

public class MenuService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void menu(boolean cliente, boolean gerente, boolean diretor, boolean presidente) throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
				Menu interativo:
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
				""");
		if (cliente) {
			logger.log(Level.INFO, """
					[1]\tMenu Cliente
					""");
		} else {
			logger.log(Level.INFO, """
					[1]\tMenu Funcionario
					""");
		}
		logger.log(Level.INFO, """
				[2]\tMenu a implementar
=======
				[1]\tMenu Cliente
				[2]\tMenu Funcionario
>>>>>>> 25ef01f fix: alteração dos submenus
				[3]\tCriar nova conta
				[0]\tSair
				Digite uma opção:
				""");

		try {
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				if (cliente) {
					SubMenuService.SubMenuCliente();
				} else {
					SubMenuService.SubMenuFuncionario(cliente, gerente, diretor, presidente);
				}
				break;
			case 2:
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
				// Opção Repetida
				// Opção a implementar
				AutenticacaoController.cadastrar();
=======
				SubMenuService.SubMenuFuncionario();
>>>>>>> 25ef01f fix: alteração dos submenus
				break;
			case 3:
				AutenticacaoController.cadastrar();
				break;
			case 0:
				Util.customizer();
				logger.log(Level.INFO, "Volte sempre!");
				break;
			default:
				Util.customizer();
				logger.log(Level.INFO, "Opção inválida!");
				menu(cliente, gerente, diretor, presidente);
				break;
			}
		} catch (InputMismatchException e) {
			Util.customizer();
			logger.log(Level.INFO, "\n\nOpção inválida!\n\n");
			Thread.sleep(2000);
			menu(cliente, gerente, diretor, presidente);
		}
	}
}
