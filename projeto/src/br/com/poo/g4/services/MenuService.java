package br.com.poo.g4.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
=======
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
>>>>>>> 42d2dfd fix: Correções diversas
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.controllers.AutenticacaoController;
import br.com.poo.g4.entities.*;
import br.com.poo.g4.entities.Cliente;
import br.com.poo.g4.entities.Funcionario;
import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.util.Util;

public class MenuService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
<<<<<<< Upstream, based on branch 'main' of https://github.com/renatocrachmad/POO-G4.git
	public static void menu(boolean cliente, boolean gerente, boolean diretor, boolean presidente) throws IOException, InterruptedException {
=======
	public static void menuCliente(Cliente clienteAutenticado) throws IOException {
		
=======
	public static void menuCliente(Cliente clienteAutenticado, Conta conta) throws IOException {	

>>>>>>> 42d2dfd fix: Correções diversas
		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
					[1] Movimentações de Conta
					[2] Relatórios
					[0] Sair
					Digite uma opção:
					""");
		try {
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				SubMenuService.subMenuCliente(clienteAutenticado, conta);
				break;
			case 2:
				SubMenuService.subMenuCliente(clienteAutenticado, conta);
				break;
			case 0: 
				logger.log(Level.INFO, "Até mais!");
				break;
			default:
				logger.log(Level.WARNING, "Opção inválida!");
				menuCliente(clienteAutenticado, conta);
				break;
			}
		} catch (InputMismatchException e) {
			logger.log(Level.WARNING, "Digite um valor do tipo inteiro válido!");
		}
	}
	
	public static void menuGerente(Funcionario gerenteAutenticado) throws IOException {
		
		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
					[1] Relatório do total de contas da Agência
					[2] Relatório das contas da Agência
					[3] Cadastrar cliente
					[0] Sair
					Digite uma opção:
					""");
		try {
			int opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				RelatorioIO.relatorioAgencia(gerenteAutenticado.getAgencia(), Conta.getMapaContas());
				logger.log(Level.INFO, "Relatório gerado em /temp/relatorios.txt");
				menuGerente(gerenteAutenticado);
				break;
			case 2:
				RelatorioIO.relatorioContasGerente(gerenteAutenticado);
				logger.log(Level.INFO, "Relatório gerado em /temp/relatorios.txt");
				menuGerente(gerenteAutenticado);
				break;
			case 3:
				logger.log(Level.INFO, "Digite o nome do cliente:\n");
				String nome = sc.nextLine();
				logger.log(Level.INFO, "Digite o CPF do cliente:\n");
				String cpf = sc.nextLine();
				logger.log(Level.INFO, "Digite a senha do cliente:\n");
				String senha = sc.nextLine();
				System.out.println("DEBUG: " + nome + " " + cpf + " " + senha + "\n");
				
				Cliente cliente = new Cliente(nome, cpf, senha);
				Cliente.getMapaClientes().put(cpf, cliente);
				
				logger.log(Level.INFO, "Qual o tipo de conta do cliente?");
				String tipo = sc.nextLine();
					if (tipo.equalsIgnoreCase("CORRENTE")) {
						Conta contaCorrente = new ContaCorrente(cpf, gerenteAutenticado.getAgencia());
						Conta.getMapaContas().put(cpf, contaCorrente);
						logger.log(Level.INFO, "Cliente " + cliente.getNome() + " cadastrado com sucesso!");
					} else if (tipo.equalsIgnoreCase("POUPANCA")) {
						logger.log(Level.INFO, "Qual será a taxa de rendimento?");
						Double rendimento = sc.nextDouble();
						Conta contaPoupanca = new ContaPoupanca(cpf, gerenteAutenticado.getAgencia(), rendimento);
						Conta.getMapaContas().put(cpf, contaPoupanca);
						logger.log(Level.INFO, "Cliente " + cliente.getNome() + " cadastrado com sucesso!");
					}
				menuGerente(gerenteAutenticado);
				break;
			case 0: 
				logger.log(Level.INFO, "Até mais!");
				break;
			default:
				logger.log(Level.WARNING, "Opção inválida!");
				menuGerente(gerenteAutenticado);
				break;
			}
		} catch (InputMismatchException e) {
			logger.log(Level.WARNING, "Digite um valor do tipo válido!");
		}
	}
	
	public static void menuDiretor(Funcionario diretorAutenticado) throws IOException {
		
		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
					[1] Relatório de informações ordenadas sobre contas
					[2] Cadastrar cliente
					[3] Cadastrar gerente
					[0] Sair
					Digite uma opção:
					""");
		try {
			int opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				System.out.println("n fizeram ainda");
				menuDiretor(diretorAutenticado);
				break;
			case 2:
				logger.log(Level.INFO, "Digite o nome do cliente:\n");
				String nome = sc.nextLine();
				logger.log(Level.INFO, "Digite o CPF do cliente:\n");
				String cpf = sc.nextLine();
				logger.log(Level.INFO, "Digite a senha do cliente:\n");
				String senha = sc.nextLine();
				System.out.println("DEBUG: " + nome + " " + cpf + " " + senha + "\n");
				
				Cliente cliente = new Cliente(nome, cpf, senha);
				Cliente.getMapaClientes().put(cpf, cliente);
				
				logger.log(Level.INFO, "Qual o tipo de conta do cliente?");
				String tipo = sc.nextLine();
				logger.log(Level.INFO, "Qual será a agência?");
				String agencia = sc.nextLine();
					if (tipo.equalsIgnoreCase("CORRENTE")) {
						Conta contaCorrente = new ContaCorrente(cpf, agencia);
						Conta.getMapaContas().put(cpf, contaCorrente);
						logger.log(Level.INFO, "Cliente " + cliente.getNome() + " cadastrado com sucesso!");
					} else if (tipo.equalsIgnoreCase("POUPANCA")) {
						logger.log(Level.INFO, "Qual será a taxa de rendimento?");
						Double rendimento = sc.nextDouble();
						Conta contaPoupanca = new ContaPoupanca(cpf, agencia, rendimento);
						Conta.getMapaContas().put(cpf, contaPoupanca);
						logger.log(Level.INFO, "Cliente " + cliente.getNome() + " cadastrado com sucesso!");
					}
				menuDiretor(diretorAutenticado);
				break;
			case 3:
				logger.log(Level.INFO, "Digite o nome do gerente: ");
				String nomeGerente = sc.nextLine();
				logger.log(Level.INFO, "Digite o CPF do gerente: ");
				String cpfGerente = sc.nextLine();
				logger.log(Level.INFO, "Digite a senha do gerente: ");
				String senhaGerente = sc.nextLine();
				logger.log(Level.INFO, "Digite a agência do gerente: ");
				String agenciaGerente = sc.nextLine();
				
				Funcionario gerente = new Gerente(nomeGerente, cpfGerente, senhaGerente, agenciaGerente);
				Funcionario.getMapaFuncionarios().put(cpfGerente, gerente);
				
				logger.log(Level.INFO, "Gerente " + gerente.getNome() + " cadastrado com sucesso!");
				
				System.out.println("DEBUG criação de gerente: " + gerente.toString());
				
				menuDiretor(diretorAutenticado);
				break;
			case 0: 
				logger.log(Level.INFO, "Até mais!");
				break;
			default:
				logger.log(Level.WARNING, "Opção inválida!");
				menuDiretor(diretorAutenticado);
				break;
			}
		} catch (InputMismatchException e) {
			logger.log(Level.WARNING, "Digite um valor do tipo inteiro válido!");
		}
	}
	
	public static void menuPresidente(Funcionario presidenteAutenticado) throws IOException {
		
		Util.customizer();
		logger.log(Level.INFO, """
					Menu interativo:
					[1] Relatório de Diretores
					[2] Relatório de Capital
					[3] Cadastrar cliente
					[4] Cadastrar gerente
					[5] Cadastrar diretor
					[0] Sair
					Digite uma opção:
					""");
		try {
			int opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				RelatorioIO.relatorioDiretores(presidenteAutenticado);
				logger.log(Level.INFO, "Relatório gerado em /temp/relatorios.txt");
				menuPresidente(presidenteAutenticado);
				break;
			case 2:
				RelatorioIO.relatorioCapital(presidenteAutenticado);
				logger.log(Level.INFO, "Relatório gerado em /temp/relatorios.txt");
				menuPresidente(presidenteAutenticado);
				break;
			case 3:
				logger.log(Level.INFO, "Digite o nome do cliente:\n");
				String nome = sc.nextLine();
				logger.log(Level.INFO, "Digite o CPF do cliente:\n");
				String cpf = sc.nextLine();
				logger.log(Level.INFO, "Digite a senha do cliente:\n");
				String senha = sc.nextLine();
				System.out.println("DEBUG: " + nome + " " + cpf + " " + senha + "\n");
				
				Cliente cliente = new Cliente(nome, cpf, senha);
				Cliente.getMapaClientes().put(cpf, cliente);
				
				logger.log(Level.INFO, "Qual o tipo de conta do cliente?");
				String tipo = sc.nextLine();
				logger.log(Level.INFO, "Qual será a agência?");
				String agencia = sc.nextLine();				
					if (tipo.equalsIgnoreCase("CORRENTE")) {
						Conta contaCorrente = new ContaCorrente(cpf, agencia);
						Conta.getMapaContas().put(cpf, contaCorrente);
						logger.log(Level.INFO, "Cliente " + cliente.getNome() + " cadastrado com sucesso!");
					} else if (tipo.equalsIgnoreCase("POUPANCA")) {
						logger.log(Level.INFO, "Qual será a taxa de rendimento?");
						Double rendimento = sc.nextDouble();
						Conta contaPoupanca = new ContaPoupanca(cpf, agencia, rendimento);
						Conta.getMapaContas().put(cpf, contaPoupanca);
						logger.log(Level.INFO, "Cliente " + cliente.getNome() + " cadastrado com sucesso!");
					}
				menuPresidente(presidenteAutenticado);
				break;
			case 4:
				logger.log(Level.INFO, "Digite o nome do gerente: ");
				String nomeGerente = sc.nextLine();
				logger.log(Level.INFO, "Digite o CPF do gerente: ");
				String cpfGerente = sc.nextLine();
				logger.log(Level.INFO, "Digite a senha do gerente: ");
				String senhaGerente = sc.nextLine();
				logger.log(Level.INFO, "Digite a agência do gerente: ");
				String agenciaGerente = sc.nextLine();
				
				Funcionario gerente = new Gerente(nomeGerente, cpfGerente, senhaGerente, agenciaGerente);
				Funcionario.getMapaFuncionarios().put(cpfGerente, gerente);
				logger.log(Level.INFO, "Gerente " + gerente.getNome() + " cadastrado com sucesso!");
				
				menuPresidente(presidenteAutenticado);
				break;
			case 5:
				logger.log(Level.INFO, "Digite o nome do diretor: ");
				String nomeDiretor = sc.nextLine();
				logger.log(Level.INFO, "Digite o CPF do diretor: ");
				String cpfDiretor = sc.nextLine();
				logger.log(Level.INFO, "Digite a senha do diretor: ");
				String senhaDiretor = sc.nextLine();
				
				Funcionario diretor = new Diretor(nomeDiretor, cpfDiretor, senhaDiretor);
				Funcionario.getMapaFuncionarios().put(cpfDiretor, diretor);
				logger.log(Level.INFO, "Diretor " + diretor.getNome() + " cadastrado com sucesso!");
				
				System.out.println("DEBUG diretor: " + diretor.toString());
				
				menuPresidente(presidenteAutenticado);
				break;
			case 0: 
				logger.log(Level.INFO, "Até mais!");
				break;
			default:
				logger.log(Level.WARNING, "Opção inválida!");
				menuPresidente(presidenteAutenticado);
				break;
			}
		} catch (InputMismatchException e) {
			logger.log(Level.WARNING, "Digite um valor do tipo inteiro válido!");
		}
	}
	
/*	public static void menu() throws IOException, InterruptedException {
>>>>>>> bb901a1 feat: Mudança nos menus, estruturação geral do projeto

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
	}*/
}
