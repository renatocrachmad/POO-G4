package br.com.poo.g4.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.poo.g4.entities.*;

public class GerenteService {
	
	public static void cadastrarConta(String cpf, String agencia, String tipo) {
		if (tipo.equalsIgnoreCase("CORRENTE")) {
			Conta contaCorrente = new ContaCorrente(cpf, agencia);
		} else if (tipo.equalsIgnoreCase("POUPANCA")) {
			try {	
				Scanner sc = new Scanner (System.in);		
				
				System.out.print("Digite a taxa de rendimento: ");			
				Double rendimento = sc.nextDouble();
				
				Conta contaPoupanca = new ContaPoupanca(cpf, agencia, rendimento);	
				
				sc.close();
			} catch (InputMismatchException e) {
				System.out.println(AutenticacaoService.VERMELHO + "Digite um tipo compatível!" + AutenticacaoService.RESET);
			}
		}
	}
}
