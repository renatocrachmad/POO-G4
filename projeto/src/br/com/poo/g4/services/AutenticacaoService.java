package br.com.poo.g4.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.entities.Cliente;
import br.com.poo.g4.util.Util;

import java.util.Map;
import java.util.Scanner;

public class AutenticacaoService {
	
	private static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);
	
	public static void autenticacao() {
		
		System.out.println("Logo");
		Util.customizer();
		logger.log(Level.INFO, "===============================\n"
					+ "     Menu de autenticação\n\n"
					+ " * CPF ___.___.___-__\n"
					+ "===============================\n"
					+ "Digite seu CPF:");
		
		String cpf = sc.nextLine();
		
		Map<String, Cliente> mapaClientes = Cliente.getMapaClientes();
		
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
				//Lógica de verificação das permissões e encaminhar pro seu respectivo menu
			} else {
				logger.log(Level.INFO, "Senha incorreta. Verifique sua escrita e tente novamente.");
				autenticacao();
			}
		} else {
			logger.log(Level.INFO, "CPF não encontrado. Verifique sua escrita e tente novamente.");
			autenticacao();
		}
		
		
		sc.close();
		
	}
}
