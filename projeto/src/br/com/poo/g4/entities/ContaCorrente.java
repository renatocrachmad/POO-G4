package br.com.poo.g4.entities;
public class ContaCorrente extends Conta {
	Double taxa;
	
	public ContaCorrente() {
		super();
	}		
	
	public ContaCorrente(String cpf, String agencia, Double taxa) {
		super(cpf, agencia, "CORRENTE");
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