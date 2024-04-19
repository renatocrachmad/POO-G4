package br.com.poo.g4.entities;

public class Diretor extends Funcionario {

	public Diretor() {
		super();
	}

	public Diretor(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.tipo = "DIRETOR";
	}
	
	public void cadastrarGerente(String nome, String cpf, String senha, String agencia) {
		Funcionario gerente = new Gerente(nome, cpf, senha, agencia);
	}

	@Override
	public String toString() {
		return " + Diretor " + nome + " | CPF: " + cpf + "\n";
	}
	
}
