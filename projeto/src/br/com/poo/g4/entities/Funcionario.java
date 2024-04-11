package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public abstract class Funcionario {
	protected Integer cpf;
	protected String senha;
	protected String tipo;
	
	static Map<Integer, Funcionario> mapaFuncionarios = new HashMap<>();

	public Funcionario() {
		super();
	}

	//Fazer override pra só criar tipo dependendo da classe
	public Funcionario(Integer cpf, String senha) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.tipo = "FUNCIONARIO";
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

	public static Map<Integer, Funcionario> getMapaFuncionarios() {
		return mapaFuncionarios;
	}

	public static void setMapaFuncionarios(Map<Integer, Funcionario> mapaFuncionarios) {
		Funcionario.mapaFuncionarios = mapaFuncionarios;
	}

	public Integer getCpf() {
		return cpf;
	}

	public String toString() {
		return "Funcionario [cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
	
}
