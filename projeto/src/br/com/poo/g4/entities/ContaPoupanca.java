package br.com.poo.g4.entities;

public class ContaPoupanca extends Conta {

	Double rendimento;
	
	public ContaPoupanca() {
		super();
			}

	public ContaPoupanca(String cpf, String agencia, String tipo, Double rendimento) {
		super(cpf, agencia, tipo );
		this.rendimento = rendimento;
	}
	
	public Double getRendimento() {
		return rendimento;
	}

	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [rendimento=" + rendimento + "]";
	}				
}
