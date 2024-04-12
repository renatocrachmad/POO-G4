package br.com.poo.g4.entities;

public abstract class Conta {
	
	protected String cpf;
	protected double saldo;
	protected String agencia;
	protected String tipo;
	protected Double rendimento;
		
	
	public Conta() {
		
	}
	public Conta(String cpf, double saldo, String agencia, String tipo, Double rendimento) {
		super();
		this.cpf = cpf;
		this.saldo = saldo;
		this.agencia = agencia;
		this.tipo = tipo;
		this.rendimento = rendimento;
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
	public void setSaldo(double saldo) {
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
	public Double getRendimento() {
		return rendimento;
	}
	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
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
		return "Conta [cpf=" + cpf + ", saldo=" + saldo + ", agencia=" + agencia + ", tipo=" + tipo + ", rendimento="
				+ rendimento + "]";
	}
}
