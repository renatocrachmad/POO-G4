package br.com.poo.g4.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.controllers.FuncionarioController;
import br.com.poo.g4.util.Util;

public class SubMenuService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	// ClienteController clienteController = new ClienteController();

	public static void SubMenuCliente() {

		Util.customizer();
		logger.log(Level.INFO, """
				Menu Interativo:
				[1]\tMovimentações na conta
				[2]\tRelatórios
				[0]\tVolta ao submenu
				Digite uma opção:
				""");

		int subOpcao = sc.nextInt();

		switch (subOpcao) {
		case 1:
			// Movimentações na conta
			break;
		case 2:
			// Relatórios
			break;
		case 0:
			// MenuService.menu();
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			SubMenuCliente();
			break;
		}

//		sc.close();
	}

	public static void SubMenuFuncionario(boolean cliente, boolean gerente, boolean diretor, boolean presidente)
			throws IOException, InterruptedException {
		FuncionarioController funcionarioController = new FuncionarioController();

		Util.customizer();
		logger.log(Level.INFO, """
				
				
				Menu interativo:
				[1]\tRelatório 1 de Gerente
				[2]\tRelatório 2 de Gerente
				[3]\tCadastro de Clientes
				""");
		if (diretor) {
			logger.log(Level.INFO, """
					[4]\tRelatório de Diretor
					[5]\tCadastro de Gerentes
					""");
		} else if(presidente) {
			logger.log(Level.INFO, """
					[6]\tRelatório 1 de Presidente
					[7]\tRelatório 2 de Presidente
					""");
		}
		logger.log(Level.INFO, """
				[0]\tVolta ao submenu
				Digite uma opção:
				""");
//		logger.log(Level.INFO, """
//				Informe seu cargo:
//				[1]\tGerente
//				[2]\tDiretor
//				[3]\tPresidente
//				[0]\tVolta ao submenu
//				Digite uma opção:
//				""");

		int subOpcao = sc.nextInt();

		switch (subOpcao) {
		case 1:
//			subMenuGerente();
			break;
		case 2:
//			subMenuDiretor();
			break;
		case 3:
//			subMenuPresidente();
			break;
		case 0:
			MenuService.menu(cliente, gerente, diretor, presidente);
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			SubMenuFuncionario(cliente, gerente, diretor, presidente);
			break;
		}

//		sc.close();
	}

//	public static void subMenuDiretor() {
//		logger.log(Level.INFO, "Menu Diretor");
//		Util.customizer();
//		logger.log(Level.INFO, """
//				Informe seu cargo:
//				[1]\tRelatórios
//				[2]\tCadastro
//				[0]\tVolta ao submenu
//				Digite uma opção:
//				""");
//
//		int subOpcao = sc.nextInt();
//
//		switch (subOpcao) {
//		case 1:
//			// Relatórios
//			break;
//		case 2:
//			// Cadastro
//			break;
//		case 0:
//			// MenuService.menu();
//			break;
//		default:
//			Util.customizer();
//			logger.log(Level.INFO, "Opção inválida!");
//			SubMenuCliente();
//			break;
//		}
//
//		sc.close();
//	}
//
//	public static void subMenuPresidente() {
//		logger.log(Level.INFO, "Menu Presidente");
//
//		Util.customizer();
//		logger.log(Level.INFO, """
//				Informe seu cargo:
//				[1]\tRelatórios
//				[2]\tCadastro
//				[0]\tVolta ao submenu
//				Digite uma opção:
//				""");
//
//		int subOpcao = sc.nextInt();
//
//		switch (subOpcao) {
//		case 1:
//			// Relatórios
//			break;
//		case 2:
//			// Cadastro
//			break;
//		case 0:
//			// MenuService.menu();
//			break;
//		default:
//			Util.customizer();
//			logger.log(Level.INFO, "Opção inválida!");
//			SubMenuCliente();
//			break;
//		}
//
//		sc.close();
//	}
//
//	public static void subMenuGerente() {
//		logger.log(Level.INFO, "Menu Gerente");
//		Util.customizer();
//		logger.log(Level.INFO, """
//				Informe seu cargo:
//				[1]\tRelatórios
//				[2]\tCadastro
//				[0]\tVolta ao submenu
//				Digite uma opção:
//				""");
//
//		int subOpcao = sc.nextInt();
//
//		switch (subOpcao) {
//		case 1:
//			// Relatórios
//			break;
//		case 2:
//			// Cadastro
//			break;
//		case 0:
//			// MenuService.menu();
//			break;
//		default:
//			Util.customizer();
//			logger.log(Level.INFO, "Opção inválida!");
//			SubMenuCliente();
//			break;
//		}
//
//		sc.close();
//	}

}
