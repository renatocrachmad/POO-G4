package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public class Presidente extends Funcionario {
	static Map mapaDiretores = new HashMap<>();

	public Presidente(Integer cpf, String senha) {
		super(cpf, senha);
		this.tipo = "PRESIDENTE";
	}

	public static Map getMapaDiretores() {
		return mapaDiretores;
	}

	public static void setMapaDiretores(Map mapaDiretores) {
		Presidente.mapaDiretores = mapaDiretores;
	}
	
	public void listaDiretores() {
		
	}
	
	public double totalBanco() {
		return 0;
	}
	
	public void cadastrarConta(Integer cpf, String tipo, Integer agencia) {
		
	}
	
	public void cadastrarGerente(Integer cpf, String senha, Integer agencia) {
		Funcionario gerente = new Gerente(cpf, senha, agencia);
	}
	
	public void cadastrarDiretor(Integer cpf, String senha) {
		Funcionario diretor = new Diretor(cpf, senha);
	}
}
