package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public class Cliente {
	
	private String nome;
	private Integer cpf;
	private String senha;
	
	private Map<Integer, Cliente> mapaClientes = new HashMap<>();

	public Cliente() {
		super();
	}

	public Cliente(String nome, Integer cpf, String senha, Map<Integer, Cliente> mapaClientes) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.mapaClientes = mapaClientes;
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

	public Map<Integer, Cliente> getMapaClientes() {
		return mapaClientes;
	}

	public void setMapaClientes(Map<Integer, Cliente> mapaClientes) {
		this.mapaClientes = mapaClientes;
	}

	public Integer getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", mapaClientes=" + mapaClientes + "]";
	}
}
