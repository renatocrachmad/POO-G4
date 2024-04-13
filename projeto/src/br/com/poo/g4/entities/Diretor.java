package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public class Diretor extends Funcionario {

	public Diretor() {
		super();
	}

	public Diretor(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.tipo = "DIRETOR";
	}
	
	//A ser implementado posteriormente
	public void relatorioContas() {
		
	}
	
	//A ser implementado posteriormente
	public void cadastrarConta(Integer cpf, String tipo, Integer agencia) {
		
	}
	
	public void cadastrarGerente(String nome, String cpf, String senha, Integer agencia) {
		Funcionario gerente = new Gerente(nome, cpf, senha, agencia);
	}

	@Override
	public String toString() {
		return "Diretor [nome=" + nome + ", cpf=" + cpf + "]";
	}
	
}
