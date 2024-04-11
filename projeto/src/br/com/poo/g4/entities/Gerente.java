package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public class Gerente extends Funcionario {
	private Integer agencia;
	
	static Map<Integer, Gerente> mapaGerentes = new HashMap<>();

	public Gerente() {
		super();
	}
	
	public Gerente(Integer cpf, String senha, Integer agencia) {
		super(cpf, senha);
		this.tipo ="GERENTE";
		this.agencia = agencia;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public static Map<Integer, Gerente> getMapaGerentes() {
		return mapaGerentes;
	}

	public static void setMapaGerentes(Map<Integer, Gerente> mapaGerentes) {
		Gerente.mapaGerentes = mapaGerentes;
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
		return "Gerente [cpf =" + cpf + ", tipo =" + tipo + ", agencia =" + agencia + "]";
	}

}
