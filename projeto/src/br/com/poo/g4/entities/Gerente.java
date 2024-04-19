package br.com.poo.g4.entities;

import br.com.poo.g4.services.GerenteService;

public class Gerente extends Funcionario {

	public Gerente() {
		super();
	}
	
	public Gerente(String nome, String cpf, String senha, String agencia) {
		super(nome, cpf, senha);
		this.tipo ="GERENTE";
		this.agencia = agencia;
	}
	
	public void cadastrarConta(String cpf, String agencia, String tipo) {
		GerenteService.cadastrarConta(cpf, agencia, tipo);
	}

	@Override
	public String toString() {
		return " + Gerente " + nome + " | Agência: " + agencia + " | CPF: " + cpf + "\n";
	}

}
