package br.com.poo.g4.services;

import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.services.MenuService;
import br.com.poo.g4.controllers.FuncionarioController;
import br.com.poo.g4.entities.Cliente;
import br.com.poo.g4.entities.Conta;
import br.com.poo.g4.entities.ContaCorrente;
import br.com.poo.g4.entities.ContaPoupanca;
import br.com.poo.g4.entities.Diretor;
import br.com.poo.g4.entities.Presidente;
import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.util.Util;

public class SubMenuService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void subMenuCliente1 (Cliente clienteAutenticado) {
		Util.customizer();
		logger.log(Level.INFO, """
					[1] Saque
					[2] Depósito
					[3] Transferência
					[0] Voltar
					""");
		int opcao = sc.nextInt();
		sc.nextLine();
		
		switch (opcao) {
		case 1:
			
		}
	}
	
	public static void subMenuCliente2 (Cliente clienteAutenticado) {
		//Vai ter que ter lógica pra exibir relatório dependendo do tipo da conta!
	}
/*	public static void SubMenuCliente() throws IOException, InterruptedException {
		
		ContaCorrente contaCorrente = new ContaCorrente();
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		double valor;

		Util.customizer();
		logger.log(Level.INFO, """
				Movimentações na conta:
				[1]\tSaque
				[2]\tDepósito
				[3]\tTransferência
				Relatórios:
				[4]\tSaldo
				[5]\tRelatório de tributação da conta corrente
				[6]\tRelatório de Rendimento da poupança
				[0]\tVolta ao submenu
				Digite uma opção:
				""");

		int subOpcao = sc.nextInt();

		switch (subOpcao) {
		case 1:
			// Saque
			valor = sc.nextDouble();
			contaCorrente.sacar(valor);
			break;
		case 2:
			// Depósito
			valor = sc.nextDouble();
			contaCorrente.depositar(valor);
			break;
		case 3:
		// Transferência
			//valor = sc.nextDouble();
			//Conta contaDestino = sc.next();
			//contaCorrente.transferir(contaDestino, valor);
			break;
		case 4:
			// Saldo
			Util.customizer();
			logger.log(Level.INFO, "Seu saldo é: " + contaCorrente.getSaldo());
			break;
		case 5:
			// Relatório de tributação da conta corrente
			RelatorioIO.extratoTributacao(contaCorrente);
			break;
		case 6:
			//Relatório de Rendimento da poupança
			RelatorioIO.extratoTributacao(contaPoupanca);
			break;
		case 0:
			 MenuService.menu();
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			SubMenuCliente();
			break;
		}

		sc.close();
	}
	
	public static void SubMenuFuncionario() throws IOException, InterruptedException {
		FuncionarioController funcionarioController = new FuncionarioController();

		Util.customizer();
		logger.log(Level.INFO, """
				Informe seu cargo:
				[1]\tGerente
				[2]\tDiretor
				[3]\tPresidente
				[0]\tVolta ao submenu
				Digite uma opção:
				""");

		int subOpcao = sc.nextInt();

		switch (subOpcao) {
		case 1:
			subMenuGerente();
			break;
		case 2:
			subMenuDiretor();
			break;
		case 3:
			subMenuPresidente();
			break;
		case 0:
			MenuService.menu();
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			SubMenuFuncionario();
			break;
		}

		sc.close();
	}

	public static void subMenuGerente() throws IOException, InterruptedException {
		
		AutenticacaoService autenticacaoService = new AutenticacaoService();
		
		logger.log(Level.INFO, "Menu Gerente");
		Util.customizer();
		logger.log(Level.INFO, """
				Relatórios:
				[1]\tRelatório do total de contas da mesma Agência
				[2]\tRelatório das contas da Agência
				Cadastro:
				[3]\tCadastro de Clientes
				[0]\tVolta ao submenu
				Digite uma opção:
				""");

		int subOpcao = sc.nextInt();

		switch (subOpcao) {
		case 1:
		//Relatório do total de contas
			//String cliente = sc.next();
			//String diretor = sc.next();
			//RelatorioIO.relatorioContas(cliente, diretor);
			break;
		case 2:
		//Relatório das contas
			//String cliente = sc.next();
			//String diretor = sc.next();
			//RelatorioIO.relatorioContas(cliente, diretor);
			break;
		case 3:
			//Cadastro de Clientes
			autenticacaoService.leitorCadastro();
			break;
		case 0:
			MenuService.menu();
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			subMenuGerente();
			break;
		}

		sc.close();
	}

	
	public static void subMenuDiretor() throws IOException, InterruptedException {
		
		AutenticacaoService autenticacaoService = new AutenticacaoService();
		Diretor diretor = new Diretor();
		
		logger.log(Level.INFO, "Menu Diretor");
		Util.customizer();
		logger.log(Level.INFO, """
				Relatórios:
				[1]\tRelatório do total de contas da mesma Agência
				[2]\tRelatório das contas da Agência
				[3]\tRelatório das contas e suas agências, coordenadas pelo Diretor
				Cadastro:
				[4]\tCadastro de Clientes
				[5]\tCadastro de Gerentes
				[0]\tVolta ao submenu
				Digite uma opção:
				""");

		int subOpcao = sc.nextInt();

		switch (subOpcao) {
		case 1:
		//Relatório do total de contas
			//String cliente = sc.next();
			//String diretor = sc.next();
			//RelatorioIO.relatorioContas(cliente, diretor);
			break;
		case 2:
		//Relatório das contas
			//String cliente = sc.next();
			//String diretor = sc.next();
			//RelatorioIO.relatorioContas(cliente, diretor);
			break;
		case 3:
		//Relatório das contas de suas agências
			//RelatorioIO.relatorioContas(null, diretor);
			break;
		case 4:
			//Cadastro de Clientes
			autenticacaoService.leitorCadastro();
			break;
		case 5:
			//Cadastro de Gerentes
			Util.customizer();
			logger.log(Level.INFO, "Digite seu nome: ");
			String nome = sc.next();
			logger.log(Level.INFO, "Digite seu cpf: ");
			String cpf = sc.next();
			logger.log(Level.INFO, "Digite uma senha: ");
			String senha = sc.next();
			logger.log(Level.INFO, "Digite uma agência: ");
			String agencia = sc.next();
			
			diretor.cadastrarGerente(nome, cpf, senha, agencia);
			break;
		case 0:
			MenuService.menu();
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			subMenuDiretor();
			break;
		}

		sc.close();
	}

	public static void subMenuPresidente() throws IOException, InterruptedException {
		
		Presidente presidente = new Presidente();
		AutenticacaoService autenticacaoService = new AutenticacaoService();
		
		logger.log(Level.INFO, "Menu Presidente");
		Util.customizer();
		logger.log(Level.INFO, """
				Relatórios:
				[1]\tRelatório do total de contas
				[2]\tRelatório das contas da Agência
				[3]\tRelatório das contas de suas agências
				[4]\tRelatório da lista de diretores e respectivas agências
				[5]\tRelatório do valor total armazenado no banco
				Cadastro:
				[6]\tCadastro de Clientes
				[7]\tCadastro de Gerentes
				[8]\tCadastro de Diretores
				[0]\tVolta ao submenu
				Digite uma opção:
				""");

		int subOpcao = sc.nextInt();

		switch (subOpcao) {
		case 1:
		//Relatório do total de contas
			//String cliente = sc.next();
			//String diretor = sc.next();
			//RelatorioIO.relatorioContas(cliente, diretor);
			break;
		case 2:
		//Relatório das contas
			//String cliente = sc.next();
			//String diretor = sc.next();
			//RelatorioIO.relatorioContas(cliente, diretor);
			break;
		case 3:
		//Relatório das contas de suas agências
			break;
		case 4:
			//Relatório da lista de diretores e respectivas agências
			RelatorioIO.relatorioDiretores(presidente);
			break;
		case 5:
			//Relatório do valor total armazenado no banco
			Util.setupLogger();
			logger.log(Level.INFO, "O total armazenado no banco é: ");
			RelatorioIO.relatorioCapital(presidente);
			break;
		case 6:
			//Cadastro de Clientes
			autenticacaoService.leitorCadastro();
			break;
		case 7:
			//Cadastro de Gerentes
			Util.customizer();
			logger.log(Level.INFO, "Digite seu nome: ");
			String nome = sc.next();
			logger.log(Level.INFO, "Digite seu cpf: ");
			String cpf = sc.next();
			logger.log(Level.INFO, "Digite uma senha: ");
			String senha = sc.next();
			logger.log(Level.INFO, "Digite uma agência: ");
			String agencia = sc.next();
			
			presidente.cadastrarGerente(nome, cpf, senha, agencia);
			break;
		case 8:
			//Cadastro de Diretores
			Util.customizer();
			logger.log(Level.INFO, "Digite seu nome: ");
			nome = sc.next();
			logger.log(Level.INFO, "Digite seu cpf: ");
			cpf = sc.next();
			logger.log(Level.INFO, "Digite uma senha: ");
			senha = sc.next();
			presidente.cadastrarDiretor(nome, cpf, senha);
			break;
		case 0:
			MenuService.menu();
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			subMenuPresidente();
			break;
		}

		sc.close();
	}*/
}
