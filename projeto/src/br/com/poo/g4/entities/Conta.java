package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public abstract class Conta {

	private Integer cpf;
	private double saldo;
	private String agencia;
	private String tipo;

	static Map<Integer, Conta> mapaConta = new HashMap<>();

	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conta(Integer cpf, String agencia, String tipo) {
		super();
		this.cpf = cpf;
		this.saldo = 0.0;
		this.agencia = agencia;
		this.tipo = tipo;
	}

	public Integer getCpf() {
		return cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static Map<Integer, Conta> getMapaConta() {
		return mapaConta;
	}

	public static void setMapaConta(Map<Integer, Conta> mapaConta) {
		Conta.mapaConta = mapaConta;
	}

	public void deposito(Double quantidade) {
		this.saldo += quantidade;
	}

	public void transferencia(Double quantidade, Integer cpfDestinatario) {
		this.saldo -= quantidade;
		// fazer a validação de valor na variavel que esta vindo(quantidade)

		if (quantidade < 0) {
			throw new IllegalArgumentException("quantidade nao pode ser negativa");
		} else {
			this.saldo = quantidade;
		}
		// se existir diminuir a quantidade do transferente e somar o valor no saldo do
		// cpf destinatario
		if (this.saldo < quantidade) {
			throw new IllegalArgumentException("saldo insuficiente para transferencia");
			
		}
		// fazer a verificação se o cpf do destinatario existe
		Conta contaDestinatario = Conta.getMapaConta().get(cpfDestinatario);
		if (contaDestinatario == null) {
			throw new IllegalArgumentException("cpf do destinatario não existe");
		} else {
			this.saldo -= quantidade;
			contaDestinatario.deposito(quantidade);
		}
		// se existir diminuir a quantidade do transferente e somar o valor no saldo do
		// cpf destinatario

		// foram tranferidos o valor xx para o cpf xxx

		// senão printar o valor nao foi possivel a transferencia

		this.saldo -= quantidade;
		Conta destinatario = null;
		destinatario.deposito(quantidade);

		System.out.println("Transferência realizada. Foram transferidos " + quantidade + " para o CPF " + destinatario.getCpf());

	}

	public void saque(Double quantidade) {
		this.saldo -= quantidade;
	}
}
