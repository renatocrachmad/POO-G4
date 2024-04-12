package br.com.poo.g4.application;

import br.com.poo.g4.entities.ContaCorrente;

public class SistemaInterno {

	public static void main(String[] args) {
		
		ContaCorrente contaCorrente = new ContaCorrente("123.456.789-11",500.00,"011","Conta corrente",0.10,0.10);
		//metodo depositar
		//contaCorrente.depositar(-400.00);
		//metodo sacar
		//contaCorrente.sacar(300.00);
		//metodo transferir
		contaCorrente.transferir(contaCorrente, 200);
	}

}
