package br.com.poo.g4.application;

import java.io.IOException;

import br.com.poo.g4.io.RelatorioIO;

import br.com.poo.g4.entities.ContaCorrente;


public class SistemaInterno {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RelatorioIO.leitor("banco");
		
		ContaCorrente contaCorrente = new ContaCorrente("123.456.789-11",500.00,"011","Conta corrente",0.10);
		//metodo depositar
		//contaCorrente.depositar(-400.00);
		//metodo sacar
		//contaCorrente.sacar(300.00);
		//metodo transferir
		contaCorrente.transferir(contaCorrente, 200);

	}

}
