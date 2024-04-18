package br.com.poo.g4.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.controllers.AutenticacaoController;
import br.com.poo.g4.util.Util;

public class MenuService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void menu() throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
				Menu interativo:
				[1]\tMenu Cliente
				[2]\tMenu Funcionario
				[3]\tCriar nova conta
				[0]\tSair
				Digite uma opção:
				""");

		try {
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				SubMenuService.SubMenuCliente();
				break;
			case 2:
				SubMenuService.SubMenuFuncionario();
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
				menu();
				break;
			}
		} catch (InputMismatchException e) {
			Util.customizer();
			logger.log(Level.INFO, "\n\nOpção inválida!\n\n");
			Thread.sleep(2000);
			menu();
		}
	}
}
