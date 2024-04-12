package br.com.poo.g4.entities;

public class ContaCorrente extends Conta {

	Double taxa;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String cpf, double saldo, String agencia, String tipo, Double rendimento, Double taxa) {
		super(cpf, saldo, agencia, tipo, rendimento);
		this.taxa = taxa;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	@Override
	public String toString() {
		return "ContaCorrente [taxa=" + taxa + "]";
	}				
}