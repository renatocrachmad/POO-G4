package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.g4.util.Util;

public class Gerente extends Funcionario {
	private Integer agencia;

	public Gerente() {
		super();
	}
	
	public Gerente(String nome, String cpf, String senha, Integer agencia) {
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
		if (tipo.equalsIgnoreCase("CORRENTE")) {
			// Instanciar nova conta corrente
		} else if (tipo.equalsIgnoreCase("POUPANCA")) {
			// Instanciar nova conta poupanca
		} else {
			// Msg de erro
		}
	}

	@Override
	public String toString() {
		return "Gerente [agencia=" + agencia + ", nome=" + nome + ", cpf=" + cpf + "]";
	}

}
