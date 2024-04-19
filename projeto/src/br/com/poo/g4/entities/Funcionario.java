package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public abstract class Funcionario {
	protected String nome;
	protected String cpf;
	protected String senha;
	protected String tipo;
	protected String agencia;
	
	static Map<String, Funcionario> mapaFuncionarios = new HashMap<>();

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.tipo = "FUNCIONARIO";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public static Map<String, Funcionario> getMapaFuncionarios() {
		return mapaFuncionarios;
	}

	public static void setMapaFuncionarios(Map<String, Funcionario> mapaFuncionarios) {
		Funcionario.mapaFuncionarios = mapaFuncionarios;
	}

	public String getCpf() {
		return cpf;
	}

	public String toString() {
		return "Funcionario [cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
	
}