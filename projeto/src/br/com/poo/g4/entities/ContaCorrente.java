package br.com.poo.g4.entities;

public class ContaCorrente extends Conta {
	private double saldo;
	private double totalGasto;	
	private double taxa;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String cpf, String agencia, Double taxa) {
		super(cpf, agencia, "CORRENTE");
		this.taxa = taxa;
	}

	@Override
	public void sacar(double valor) {
		this.taxa = 0.10;
		if (saldo >= valor + taxa) {
			saldo -= valor + taxa;
			totalGasto += taxa;
		} else {
			System.out.println("Saldo insuficiente para saque.");
		}
	}

	@Override
	public void depositar(double valor) {
		this.taxa = 0.10;
		saldo += valor - taxa;
		totalGasto += taxa;
	}

	@Override
	public void transferir(Conta contaDestino, double valor) {
		this.taxa = 0.20;
		if (saldo >= valor + taxa) {
			saldo -= valor + taxa;
			contaDestino.depositar(valor);
			totalGasto += taxa;
		} else {
			System.out.println("Saldo insuficiente para transferência.");
		}
	}

	public void relatorioTributacao() {
		System.out.println("Total gasto em operações: R$" + totalGasto);
		System.out.println("Taxa por saque: R$" + taxa);
		System.out.println("Taxa por depósito: R$" + taxa);
		System.out.println("Taxa por transferência: R$" + taxa);
	}
}