package br.com.poo.g4.entities;

import java.util.HashMap;
import java.util.Map;

public abstract class Conta {
	
	protected String cpf;
	protected Double saldo;
	protected String agencia;
	protected String tipo;
			
	public Conta() {
		super();
	}
	public Conta(String cpf, Double saldo, String agencia, String tipo) {
		super();
		this.cpf = cpf;
		this.saldo = saldo;
		this.agencia = agencia;
		this.tipo = tipo;		
	}
	
	static Map<Integer, Conta> mapaContas = new HashMap<>();
	
	public static Map<Integer, Conta> getMapaContas() {
		return mapaContas;
	}

	public static void setMapaContas(Map<Integer, Conta> mapaContas) {
		Conta.mapaContas = mapaContas;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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
	public void depositar(double valor) {
		// verificar se o valor é diferente de negativo e diferente de 0
		if (valor <= 0) {
			System.out.println("O valor é invalido");
		}else {
			this.saldo += valor; {
				System.out.println("Saldo atulizado :" + saldo);
			} 							
		}				
	}
	public void sacar(double valor) {
		// verificar se o valor é diferente de negativo e diferente de 0
		if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso. Saldo atual: " + this.saldo);
        } else {
            System.out.println("Saque não realizado. Verifique o valor desejado e o saldo disponível.");
        }
    }		
	
	public void transferir(Conta destino, double valor) {
	    // verificar se o valor é diferente de negativo e diferente de 0
	    if (valor > 0 && valor <= this.saldo) {
	        this.saldo -= valor;
	        destino.saldo += valor;
	        System.out.println("Transferência realizada com sucesso. Saldo atual: " + this.saldo);
	    } else {
	        System.out.println("Transferência não realizada. Verifique o valor desejado e o saldo disponível.");
	    }
	}
	@Override
	public String toString() {
		return "Conta [cpf=" + cpf + ", saldo=" + saldo + ", agencia=" + agencia + ", tipo=" + tipo + "]";
	}

}
