package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public class Gerente extends Funcionario {
	private Integer agencia;

	public Gerente() {
		super();
	}
	
	public Gerente(String nome, Integer cpf, String senha, Integer agencia) {
		super(nome, cpf, senha);
		this.tipo ="GERENTE";
		this.agencia = agencia;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	
	//A ser implementado posteriormente
	public int totalContas() {
		return 0;
	}
	
	//A ser implementado posteriormente
	public void relatorioContas() {
		
	}
	
	//A ser implementado posteriormente
	public void cadastrarConta(Integer cpf, String tipo, Integer agencia) {
		
	}

	@Override
	public String toString() {
		return "Gerente [agencia=" + agencia + ", nome=" + nome + ", cpf=" + cpf + "]";
	}

}
