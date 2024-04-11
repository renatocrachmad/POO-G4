package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public class Diretor extends Funcionario {
	static Map<Integer, Diretor> mapaDiretores = new HashMap<>();

	public Diretor() {
		super();
	}

	public Diretor(Integer cpf, String senha) {
		super(cpf, senha);
		this.tipo = "DIRETOR";
	}

	public static Map<Integer, Diretor> getMapaDiretores() {
		return mapaDiretores;
	}

	public static void setMapaDiretores(Map<Integer, Diretor> mapaDiretores) {
		Diretor.mapaDiretores = mapaDiretores;
	}
	
	public void relatorioContas() {
		
	}
	
	public void cadastrarConta(Integer cpf, String tipo, Integer agencia) {
		
	}
	
	public void cadastrarGerente(Integer cpf, String senha, Integer agencia) {
		Funcionario gerente = new Gerente(cpf, senha, agencia);
	}

	@Override
	public String toString() {
		return "Diretor [cpf=" + cpf + ", tipo=" + tipo + "]";
	}
	
}
