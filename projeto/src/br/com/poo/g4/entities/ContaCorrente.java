package br.com.poo.g4.entities;

public class ContaCorrente extends Conta {
	private Double saldo;
	private static Double tributacoesSaque = 0.0;
	private static Double tributacoesDeposito = 0.0;
	private static Double tributacoesTransferencia = 0.0;
	private Double taxa;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String cpf, String agencia) {
		super(cpf, agencia, "CORRENTE");
	}

	public static Double getTributacoesSaque() {
		return tributacoesSaque;
	}

	public static Double getTributacoesDeposito() {
		return tributacoesDeposito;
	}

	public static Double getTributacoesTransferencia() {
		return tributacoesTransferencia;
	}

	@Override
	public void sacar(double valor) {
		this.taxa = 0.10;
		if (saldo >= valor + taxa) {
			saldo -= valor + taxa;
			this.tributacoesSaque += taxa;
			saquesTotais += 1;
		} else {
			System.out.println("Saldo insuficiente para saque.");
		}
	}

	@Override
	public void depositar(double valor) {
		this.taxa = 0.10;
		saldo += valor - taxa;
		this.tributacoesDeposito += taxa;
		depositosTotais += 1;
	}

	@Override
	public void transferir(Conta contaDestino, double valor) {
		this.taxa = 0.20;
		if (saldo >= valor + taxa) {
			saldo -= valor + taxa;
			contaDestino.depositar(valor);
			this.tributacoesTransferencia += taxa;
		} else {
			System.out.println("Saldo insuficiente para transferência.");
		}
	}
	
	@Override
	public String toString() {
		return "\n + Conta Corrente | CPF: " + cpf + " | Agência: " + agencia + " | Saldo: " + saldo + "\n";
	}
}