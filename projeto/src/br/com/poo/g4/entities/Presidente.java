package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.services.GerenteService;

public class Presidente extends Funcionario {

	public Presidente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.tipo = "PRESIDENTE";
	}
	
	//A ser implementado posteriormente
	public void listaDiretores() {
		
	}
	
	//A ser implementado posteriormente
	public double totalBanco() {
		return 0;
	}
	
	//A ser implementado posteriormente
	public void cadastrarConta(String cpf, String tipo, String agencia) {
		GerenteService.cadastrarConta(cpf, agencia, tipo);
	}
	
	public void cadastrarGerente(String nome, String cpf, String senha, String agencia) {
		Funcionario gerente = new Gerente(nome, cpf, senha, agencia);
	}
	
	public void cadastrarDiretor(String nome, String cpf, String senha) {
		Funcionario diretor = new Diretor(nome, cpf, senha);
	}

	@Override
	public String toString() {
		return " + Presidente " + nome + " | CPF: " + cpf + "\n";
	}
	
}
