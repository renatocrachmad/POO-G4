package br.com.poo.g4.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
import br.com.poo.g4.controllers.FuncionarioController;
=======
>>>>>>> 3c5736e fix: Correções gerais
import br.com.poo.g4.entities.Cliente;
import br.com.poo.g4.entities.Conta;
import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.util.Util;

public class SubMenuService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
	// ClienteController clienteController = new ClienteController();

	public static void SubMenuCliente() {
=======
	public static void SubMenuCliente() throws IOException, InterruptedException {
=======
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
=======
	public static void subMenuCliente (Cliente clienteAutenticado, Conta conta) {
>>>>>>> 42d2dfd fix: Correções diversas
		
		Map<String, Conta> mapaContas = Conta.getMapaContas();
		
		try {
			
			Util.customizer();
			logger.log(Level.INFO, """
						[1] Saque
						[2] Depósito
						[3] Transferência
						[0] Voltar
						Digite uma opção:
						""");
			
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				logger.log(Level.INFO, "Digite a quantidade a ser sacada: ");
				double quantidadeSaque = sc.nextDouble();
				conta.sacar(quantidadeSaque);
				logger.log(Level.INFO, "Saque realizado com sucesso!\n");
				RelatorioIO.operacoes("Saque", conta);
				logger.log(Level.INFO, "Deseja imprimir o extrato? (s/n)");
				char decisao = sc.next().charAt(0);
				if (decisao == 's') {
					RelatorioIO.extratoSaque(quantidadeSaque);
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente(clienteAutenticado, conta);
					break;
				} else {
					subMenuCliente(clienteAutenticado, conta);
					break;
				}
			case 2:
				logger.log(Level.INFO, "Digite a quantidade a ser depositada: ");
				double quantidadeDeposito = sc.nextDouble();
				conta.depositar(quantidadeDeposito);
				logger.log(Level.INFO, "Depósito realizado com sucesso!\n");
				RelatorioIO.operacoes("Depósito", conta);
				logger.log(Level.INFO, "Deseja imprimir o extrato? (s/n)");
				char decisao2 = sc.next().charAt(0);
				if (decisao2 == 's') {
					RelatorioIO.extratoDeposito(quantidadeDeposito);
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente(clienteAutenticado, conta);
					break;
				} else {
					subMenuCliente(clienteAutenticado, conta);
					break;
				}
			case 3:
				logger.log(Level.INFO, "Digite a quantidade a ser transferida: ");
				double quantidadeTransferencia = sc.nextDouble();
				sc.nextLine();
				logger.log(Level.INFO, "Digite o CPF do destinatário: ");
				String cpfDestinatario = sc.nextLine();
				
				if (mapaContas.containsKey(cpfDestinatario)) {
					Conta destinatario = mapaContas.get(cpfDestinatario);
					conta.transferir(destinatario, quantidadeTransferencia);
					logger.log(Level.INFO, "Transferência realizada com sucesso!\n");
					RelatorioIO.operacoes("Transferência", conta);
					logger.log(Level.INFO, "Deseja imprimir o extrato? (s/n)");
					char decisao3 = sc.next().charAt(0);
					if (decisao3 == 's') {
						RelatorioIO.extratoTransferencia(destinatario, quantidadeTransferencia);
						logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
						subMenuCliente(clienteAutenticado, conta);
						break;
					} else {
						subMenuCliente(clienteAutenticado, conta);
						break;
					}
				} else {
					logger.log(Level.INFO, "CPF não encontrado!");
					subMenuCliente(clienteAutenticado, conta);
					break;
				}
			case 0:
				MenuService.menuCliente(clienteAutenticado, conta);
				break;
			default:
				logger.log(Level.WARNING, "Opção inválida!");
				subMenuCliente(clienteAutenticado, conta);
				break;
			}
		} catch (IOException e) {
			System.out.println("Erro de leitura");
		} catch (InputMismatchException e) {
			logger.log(Level.WARNING, "Erro na identificação de variável!");
		}
	}
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
/*	public static void SubMenuCliente() throws IOException, InterruptedException {
>>>>>>> bb901a1 feat: Mudança nos menus, estruturação geral do projeto
		
		ContaCorrente contaCorrente = new ContaCorrente();
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		double valor;
>>>>>>> 25ef01f fix: alteração dos submenus

		Util.customizer();
		logger.log(Level.INFO, """
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
				Menu Interativo:
				[1]\tMovimentações na conta
				[2]\tRelatórios
=======
				Movimentações na conta:
				[1]\tSaque
				[2]\tDepósito
				[3]\tTransferência
				Relatórios:
				[4]\tSaldo
				[5]\tRelatório de tributação da conta corrente
				[6]\tRelatório de Rendimento da poupança
>>>>>>> 25ef01f fix: alteração dos submenus
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

//		sc.close();
	}
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git

	public static void SubMenuFuncionario(boolean cliente, boolean gerente, boolean diretor, boolean presidente)
			throws IOException, InterruptedException {
=======
=======
>>>>>>> 3c5736e fix: Correções gerais
	
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
	public static void SubMenuFuncionario() throws IOException, InterruptedException {
>>>>>>> 25ef01f fix: alteração dos submenus
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

<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
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
=======
	public static void subMenuGerente() throws IOException, InterruptedException {
=======
	public static void subMenuCliente2 (Cliente clienteAutenticado, Conta conta) throws IOException {
>>>>>>> 3c5736e fix: Correções gerais
		
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
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
>>>>>>> 25ef01f fix: alteração dos submenus

	
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
=======
		try {
>>>>>>> 3c5736e fix: Correções gerais
			
			if (conta.getTipo().equalsIgnoreCase("CORRENTE")) {
				Util.customizer();
				logger.log(Level.INFO, """
							[1] Saldo
							[2] Relatório de tributação
							[0] Voltar
							""");
			} else if (conta.getTipo().equalsIgnoreCase("POUPANCA")) {
				Util.customizer();
				logger.log(Level.INFO, """
							[1] Saldo
							[2] Simulação de rendimento
							[0] Voltar
							""");
			}
			
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				logger.log(Level.INFO, "O seu saldo é de R$ " + conta.getSaldo());
				logger.log(Level.INFO, "Deseja imprimir o extrato? (s/n)");
				char decisao = sc.next().charAt(0);
				if (decisao == 's') {
					RelatorioIO.extratoSaldo(conta);
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente2(clienteAutenticado, conta);
					break;
				} else {
					subMenuCliente2(clienteAutenticado, conta);
					break;
				}
			case 2:
				if (conta.getTipo().equalsIgnoreCase("CORRENTE")) {
					RelatorioIO.extratoTributacao(conta);
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente2(clienteAutenticado, conta);
					break;
				} else if (conta.getTipo().equalsIgnoreCase("POUPANCA")) {
					logger.log(Level.INFO, "Qual o valor que deseja simular?");
					Double valor = sc.nextDouble();
					logger.log(Level.INFO, "Qual a quantidade de dias?");
					Integer prazo = sc.nextInt();
					
					RelatorioIO.simulacaoRendimento(valor, prazo, conta.getRendimento());
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente2(clienteAutenticado, conta);
					break;
				}
				break;
			case 0:
				MenuService.menuCliente(clienteAutenticado, conta);
				break;
			default:
				logger.log(Level.WARNING, "Opção inválida!");
				subMenuCliente2(clienteAutenticado, conta);
				break;
			}
		} catch (InputMismatchException e) {
			logger.log(Level.WARNING, "Erro na identificação de variável!");
		}
	}
}