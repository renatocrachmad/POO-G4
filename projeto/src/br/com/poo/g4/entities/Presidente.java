package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public class Presidente extends Funcionario {

	public Presidente(String nome, Integer cpf, String senha) {
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
	public void cadastrarConta(Integer cpf, String tipo, Integer agencia) {
		
	}
	
	public void cadastrarGerente(String nome, Integer cpf, String senha, Integer agencia) {
		Funcionario gerente = new Gerente(nome, cpf, senha, agencia);
	}
	
	public void cadastrarDiretor(String nome, Integer cpf, String senha) {
		Funcionario diretor = new Diretor(nome, cpf, senha);
	}

	@Override
	public String toString() {
		return "Presidente [nome=" + nome + ", cpf=" + cpf + "]";
	}
	
}
