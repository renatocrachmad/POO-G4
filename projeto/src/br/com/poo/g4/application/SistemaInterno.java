package br.com.poo.g4.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.poo.g4.controllers.AutenticacaoController;
import br.com.poo.g4.entities.Conta;
import br.com.poo.g4.entities.Funcionario;
import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.services.MenuService;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, InterruptedException {
		RelatorioIO.leitor("banco");
		
		List <Funcionario> listaFuncionarios = new ArrayList<>(Funcionario.getMapaFuncionarios().values());
		
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getTipo().equalsIgnoreCase("GERENTE")) {
				System.out.println(funcionario.toString());
			} else if (funcionario.getTipo().equalsIgnoreCase("DIRETOR")) {
				System.out.println(funcionario.toString());
			} else if (funcionario.getTipo().equalsIgnoreCase("PRESIDENTE")) {
				System.out.println(funcionario.toString());
			}
		}
	}

}
