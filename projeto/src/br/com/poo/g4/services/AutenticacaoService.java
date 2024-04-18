package br.com.poo.g4.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.entities.Cliente;
import br.com.poo.g4.entities.Conta;
import br.com.poo.g4.entities.ContaCorrente;
import br.com.poo.g4.entities.ContaPoupanca;
import br.com.poo.g4.entities.Diretor;
import br.com.poo.g4.entities.Funcionario;
import br.com.poo.g4.entities.Gerente;
import br.com.poo.g4.entities.Presidente;
import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.util.Util;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class AutenticacaoService {

	private static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);
	public static final String RESET = "\u001B[0m";
	public static final String VERDE = "\u001B[32m";
	public static final String VERMELHO = "\u001B[31m";
	
	public static void logo() {
		System.out.println(VERDE + "   _   _   _    _    _            ____              _       _   _   _  \r\n"
				+ "  | | | | | |  | |  | |          |  _ \\            | |     | | | | | | \r\n"
				+ " / __) __) __) | |  | |_ __ _   _| |_) | __ _ _ __ | | __ / __) __) __)\r\n"
				+ " \\__ \\__ \\__ \\ | |  | | '__| | | |  _ < / _` | '_ \\| |/ / \\__ \\__ \\__ \\\r\n"
				+ " (   (   (   / | |__| | |  | |_| | |_) | (_| | | | |   <  (   (   (   /\r\n"
				+ "  |_| |_| |_|   \\____/|_|   \\__,_|____/ \\__,_|_| |_|_|\\_\\  |_| |_| |_| \r\n"
				+ "                                                                       \r\n"
				+ "                                                                       " + RESET);
	}
	
	public static void verificacao() {
		try {
			logo();
			Util.customizer();
			logger.log(Level.INFO, "===============================\n"
						+ "    Bem-vindo ao UruBank!\n"
						+ "    Selecione uma opção:\n"
						+ "[1] Cliente\n"
						+ "[2] Gerente\n"
						+ "[3] Diretor\n"
						+ "[4] Presidente\n"
						+ "[0] Cadastre-se\n"
						+ "===============================\n"
						+ "Digite a opção:");
			
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1: 
				autenticacaoCliente();
				break;
			case 2:
				autenticacaoGerente();
				break;
			case 3:
				autenticacaoDiretor();
				break;
			case 4: 
				autenticacaoPresidente();
				break;
			case 0:
				leitorCadastro();
			default: 
				logger.log(Level.INFO, "Opção inválida!");
				verificacao();
				break;
			}
		} catch (InputMismatchException e) {
			logger.log(Level.WARNING, "Digite um valor do tipo inteiro válido!");
		} catch (IOException e) {
			logger.log(Level.WARNING, "Erro de leitura e/ou escrita!");
		}
	}
	
	public static void autenticacaoCliente() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, "===============================\n" 
					+ "     Menu de autenticação\n\n"
					+ " * CPF ___.___.___-__\n" 
					+ "===============================\n" 
					+ "Digite seu CPF:");

		String cpf = sc.nextLine();
		
		Map<String, Cliente> mapaClientes = Cliente.getMapaClientes();
		Map<String, Conta> mapaContas = Conta.getMapaContas();
		Conta contaCorrente = null;
		Conta contaPoupanca = null;

		if (mapaClientes.containsKey(cpf)) {
			Cliente cliente = mapaClientes.get(cpf);
			logger.log(Level.INFO, "===============================\n" 
							+ "     Menu de autenticação\n\n" 
							+ " * CPF: " + cpf + "\n"
							+ " * Senha: ____________\n" 
							+ "===============================\n" 
							+ "Digite sua senha: ");

			String senha = sc.nextLine();
	
			if (senha.equals(cliente.getSenha())) {
				logger.log(Level.INFO, "Bem-vindo, " + cliente.getNome() + "!");
				Cliente clienteAutenticado = new Cliente(cliente.getNome(), cliente.getCpf(), cliente.getSenha());
				System.out.println("DEBUG AUTENTICACAOSERVICE: " + clienteAutenticado.toString());
				
				if (mapaContas.containsKey(clienteAutenticado.getCpf())) {			
					Conta conta = mapaContas.get(clienteAutenticado.getCpf());
					if (conta.getTipo().equalsIgnoreCase("CORRENTE")) {
						contaCorrente = new ContaCorrente(conta.getCpf(), conta.getAgencia());
						System.out.println("Criação de conta corrente na autenticação: " + contaCorrente.toString());
						MenuService.menuCliente(clienteAutenticado, contaCorrente);
					} else if (conta.getTipo().equalsIgnoreCase("POUPANCA")) {
						contaPoupanca = new ContaPoupanca(conta.getCpf(), conta.getAgencia(), conta.getRendimento());
						System.out.println("Criação de conta poupança na autenticação: " + contaPoupanca.toString());
						MenuService.menuCliente(clienteAutenticado, contaPoupanca);
					}
				} else {
					Util.customizer();
					logger.log(Level.INFO, "Você não possui nenhuma conta bancária cadastrada! Entre em contato com um gerente.");
					verificacao();
				}
			} else {
				logger.log(Level.INFO, "Senha incorreta. Verifique sua escrita e tente novamente.");
				autenticacaoCliente();
			}
		} else {
			logger.log(Level.INFO, "CPF não encontrado. Verifique sua escrita e tente novamente.");
			autenticacaoCliente();
		}
	}
	
	public static void autenticacaoGerente() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, "===============================\n" 
					+ "     Menu de autenticação\n\n"
					+ " * CPF ___.___.___-__\n" 
					+ "===============================\n" 
					+ "Digite seu CPF:");

		String cpf = sc.nextLine();
		
		Map<String, Funcionario> mapaFuncionarios = Funcionario.getMapaFuncionarios();

		if (mapaFuncionarios.containsKey(cpf)) {
			Funcionario gerente = mapaFuncionarios.get(cpf);
			if (gerente.getTipo().equalsIgnoreCase("GERENTE")) {
				logger.log(Level.INFO, "===============================\n" 
								+ "     Menu de autenticação\n\n" 
								+ " * CPF: " + cpf + "\n"
								+ " * Senha: ____________\n" 
								+ "===============================\n" 
								+ "Digite sua senha: ");
	
				String senha = sc.nextLine();
		
				if (senha.equals(gerente.getSenha())) {
					logger.log(Level.INFO, "Bem-vindo, " + gerente.getNome() + "!");
					Funcionario gerenteAutenticado = new Gerente(gerente.getNome(), gerente.getCpf(), gerente.getSenha(), gerente.getAgencia());
					MenuService.menuGerente(gerenteAutenticado);
				} else {
					logger.log(Level.INFO, "Senha incorreta. Verifique sua escrita e tente novamente.");
					autenticacaoGerente();
				}
			}
		} else {
			logger.log(Level.INFO, "CPF não encontrado. Verifique sua escrita e tente novamente.");
			autenticacaoGerente();
		}	
	}
	
	public static void autenticacaoDiretor() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, "===============================\n" 
					+ "     Menu de autenticação\n\n"
					+ " * CPF ___.___.___-__\n" 
					+ "===============================\n" 
					+ "Digite seu CPF:");

		String cpf = sc.nextLine();
		
		Map<String, Funcionario> mapaFuncionarios = Funcionario.getMapaFuncionarios();

		if (mapaFuncionarios.containsKey(cpf)) {
			Funcionario diretor = mapaFuncionarios.get(cpf);
			if (diretor.getTipo().equalsIgnoreCase("DIRETOR")) {
				logger.log(Level.INFO, "===============================\n" 
								+ "     Menu de autenticação\n\n" 
								+ " * CPF: " + cpf + "\n"
								+ " * Senha: ____________\n" 
								+ "===============================\n" 
								+ "Digite sua senha: ");
	
				String senha = sc.nextLine();
		
				if (senha.equals(diretor.getSenha())) {
					logger.log(Level.INFO, "Bem-vindo, " + diretor.getNome() + "!");
					Funcionario diretorAutenticado = new Diretor(diretor.getNome(), diretor.getCpf(), diretor.getSenha());
					MenuService.menuDiretor(diretorAutenticado);
				} else {
					logger.log(Level.INFO, "Senha incorreta. Verifique sua escrita e tente novamente.");
					autenticacaoDiretor();
				}
			}
		} else {
			logger.log(Level.INFO, "CPF não encontrado. Verifique sua escrita e tente novamente.");
			autenticacaoDiretor();
		}	
	}
	
	public static void autenticacaoPresidente() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, "===============================\n" 
					+ "     Menu de autenticação\n\n"
					+ " * CPF ___.___.___-__\n" 
					+ "===============================\n" 
					+ "Digite seu CPF:");

		String cpf = sc.nextLine();
		
		Map<String, Funcionario> mapaFuncionarios = Funcionario.getMapaFuncionarios();

		if (mapaFuncionarios.containsKey(cpf)) {
			Funcionario presidente = mapaFuncionarios.get(cpf);
			if (presidente.getTipo().equalsIgnoreCase("PRESIDENTE")) {
				logger.log(Level.INFO, "===============================\n" 
								+ "     Menu de autenticação\n\n" 
								+ " * CPF: " + cpf + "\n"
								+ " * Senha: ____________\n" 
								+ "===============================\n" 
								+ "Digite sua senha: ");
	
				String senha = sc.nextLine();
		
				if (senha.equals(presidente.getSenha())) {
					logger.log(Level.INFO, "Bem-vindo, " + presidente.getNome() + "!");
					Funcionario presidenteAutenticado = new Presidente(presidente.getNome(), presidente.getCpf(), presidente.getSenha());
					MenuService.menuPresidente(presidenteAutenticado);
				} else {
					logger.log(Level.INFO, "Senha incorreta. Verifique sua escrita e tente novamente.");
					autenticacaoPresidente();
				}
			}
		} else {
			logger.log(Level.INFO, "CPF não encontrado. Verifique sua escrita e tente novamente.");
			autenticacaoPresidente();
		}	
	}

	public static void leitorCadastro() throws IOException {
		Util.customizer();
		logger.log(Level.INFO, "Digite seu nome: ");
		String nome = sc.nextLine();
		logger.log(Level.INFO, "Digite seu cpf: ");
		String cpf = sc.nextLine();
		logger.log(Level.INFO, "Digite uma senha: ");
		String senha = sc.nextLine();

		Cliente cliente = new Cliente(nome, cpf, senha);
		Cliente.getMapaClientes().put(cpf, cliente);

		RelatorioIO.cadastrarCliente("banco", cliente);
		
		sc.close();
	}
}
