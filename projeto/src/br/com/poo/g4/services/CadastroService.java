package br.com.poo.g4.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.com.poo.g4.entities.Cliente;
import br.com.poo.g4.io.RelatorioIO;

public class CadastroService {

	static Scanner sc = new Scanner(System.in);

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
