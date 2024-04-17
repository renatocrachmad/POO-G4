package br.com.poo.g4.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.entities.Cliente;
import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.util.Util;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class AutenticacaoService {

	private static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);
	public static final String RESET = "\u001B[0m";
	public static final String VERDE = "\u001B[32m";
	
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

	public static void autenticacao() {

		// Inserir logo do banco
		// System.out.println("Logo");
		// Evita duplicação da mensagem
		Util.customizer();
		logger.log(Level.INFO, "===============================\n" 
					+ "     Menu de autenticação\n\n"
					+ " * CPF ___.___.___-__\n" 
					+ "===============================\n" 
					+ "Digite seu CPF:");
		// Recebe o cpf digitado
		String cpf = sc.nextLine();
		// Cria um mapa local para ser acessado e atribui ele ao mapa de clientes, que
		// possui os dados do banco
		Map<String, Cliente> mapaClientes = Cliente.getMapaClientes();
		// Verifica se o mapa de clientes possui o cpf informado
		if (mapaClientes.containsKey(cpf)) {
			// Cria um objeto do tipo Cliente para essa pessoa que possui tal cpf
			Cliente cliente = mapaClientes.get(cpf);
			logger.log(Level.INFO, "===============================\n" 
							+ "     Menu de autenticação\n\n" 
							+ " * CPF: " + cpf + "\n"
							+ " * Senha: ____________\n" 
							+ "===============================\n" 
							+ "Digite sua senha: ");
			// Recebe a senha digitada
			String senha = sc.nextLine();
			// Verifica se a senha do usuário está correta
			if (senha.equals(cliente.getSenha())) {
				logger.log(Level.INFO, "Bem-vindo, " + cliente.getNome() + "!");
				// Inserir lógica de verificação das permissões e encaminhar pro seu respectivo
				// menu
			} else {
				logger.log(Level.INFO, "Senha incorreta. Verifique sua escrita e tente novamente.");
				// Volta o usuário para o menu de autenticação
				autenticacao();
			}
		} else {
			logger.log(Level.INFO, "CPF não encontrado. Verifique sua escrita e tente novamente.");
			autenticacao();
		}
	}

	public static void leitorCadastro() throws IOException {
		System.out.println("Digite o seu nome: ");
		String nome = sc.next();
		System.out.println("Digite seu CPF: ");
		String cpf = sc.next();
		System.out.println("Digite uma senha: ");
		String senha = sc.next();

		Cliente novoCliente = new Cliente(nome, cpf, senha);

		RelatorioIO.cadastrarCliente("banco", novoCliente);

	}
}
