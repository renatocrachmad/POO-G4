package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public class Cliente {

	private String nome;
	private String cpf;
	private String senha;

	static Map<String, Cliente> mapaClientes = new HashMap<>();

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
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

	public static Map<String, Cliente> getMapaClientes() {
		return mapaClientes;
	}

	public static void setMapaClientes(Map<String, Cliente> mapaClientes) {
		Cliente.mapaClientes = mapaClientes;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "\n + Cliente " + nome + " |  CPF: " + cpf + "\n";
	}
}