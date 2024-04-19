package br.com.poo.g4.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.entities.Cliente;
import br.com.poo.g4.entities.Conta;
import br.com.poo.g4.io.RelatorioIO;
import br.com.poo.g4.util.Util;

public class SubMenuService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void subMenuCliente (Cliente clienteAutenticado, Conta conta) {
		
		Map<String, Conta> mapaContas = Conta.getMapaContas();
		
		try {
			
			Util.customizer();
			logger.log(Level.INFO, """
						[1] Saque
						[2] Depósito
						[3] Transferência
						[0] Voltar
						Digite uma opção:
						""");
			
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				logger.log(Level.INFO, "Digite a quantidade a ser sacada: ");
				double quantidadeSaque = sc.nextDouble();
				conta.sacar(quantidadeSaque);
				logger.log(Level.INFO, "Saque realizado com sucesso!\n");
				RelatorioIO.operacoes("Saque", conta);
				logger.log(Level.INFO, "Deseja imprimir o extrato? (s/n)");
				char decisao = sc.next().charAt(0);
				if (decisao == 's') {
					RelatorioIO.extratoSaque(quantidadeSaque);
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente(clienteAutenticado, conta);
					break;
				} else {
					subMenuCliente(clienteAutenticado, conta);
					break;
				}
			case 2:
				logger.log(Level.INFO, "Digite a quantidade a ser depositada: ");
				double quantidadeDeposito = sc.nextDouble();
				conta.depositar(quantidadeDeposito);
				logger.log(Level.INFO, "Depósito realizado com sucesso!\n");
				RelatorioIO.operacoes("Depósito", conta);
				logger.log(Level.INFO, "Deseja imprimir o extrato? (s/n)");
				char decisao2 = sc.next().charAt(0);
				if (decisao2 == 's') {
					RelatorioIO.extratoDeposito(quantidadeDeposito);
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente(clienteAutenticado, conta);
					break;
				} else {
					subMenuCliente(clienteAutenticado, conta);
					break;
				}
			case 3:
				logger.log(Level.INFO, "Digite a quantidade a ser transferida: ");
				double quantidadeTransferencia = sc.nextDouble();
				sc.nextLine();
				logger.log(Level.INFO, "Digite o CPF do destinatário: ");
				String cpfDestinatario = sc.nextLine();
				
				if (mapaContas.containsKey(cpfDestinatario)) {
					Conta destinatario = mapaContas.get(cpfDestinatario);
					conta.transferir(destinatario, quantidadeTransferencia);
					logger.log(Level.INFO, "Transferência realizada com sucesso!\n");
					RelatorioIO.operacoes("Transferência", conta);
					logger.log(Level.INFO, "Deseja imprimir o extrato? (s/n)");
					char decisao3 = sc.next().charAt(0);
					if (decisao3 == 's') {
						RelatorioIO.extratoTransferencia(destinatario, quantidadeTransferencia);
						logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
						subMenuCliente(clienteAutenticado, conta);
						break;
					} else {
						subMenuCliente(clienteAutenticado, conta);
						break;
					}
				} else {
					logger.log(Level.INFO, "CPF não encontrado!");
					subMenuCliente(clienteAutenticado, conta);
					break;
				}
			case 0:
				MenuService.menuCliente(clienteAutenticado, conta);
				break;
			default:
				logger.log(Level.WARNING, "Opção inválida!");
				subMenuCliente(clienteAutenticado, conta);
				break;
			}
		} catch (IOException e) {
			System.out.println("Erro de leitura");
		} catch (InputMismatchException e) {
			logger.log(Level.WARNING, "Erro na identificação de variável!");
		}
	}
	
	public static void subMenuCliente2 (Cliente clienteAutenticado, Conta conta) throws IOException {
		
		try {
			
			if (conta.getTipo().equalsIgnoreCase("CORRENTE")) {
				Util.customizer();
				logger.log(Level.INFO, """
							[1] Saldo
							[2] Relatório de tributação
							[0] Voltar
							""");
			} else if (conta.getTipo().equalsIgnoreCase("POUPANCA")) {
				Util.customizer();
				logger.log(Level.INFO, """
							[1] Saldo
							[2] Simulação de rendimento
							[0] Voltar
							""");
			}
			
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				logger.log(Level.INFO, "O seu saldo é de R$ " + conta.getSaldo());
				logger.log(Level.INFO, "Deseja imprimir o extrato? (s/n)");
				char decisao = sc.next().charAt(0);
				if (decisao == 's') {
					RelatorioIO.extratoSaldo(conta);
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente2(clienteAutenticado, conta);
					break;
				} else {
					subMenuCliente2(clienteAutenticado, conta);
					break;
				}
			case 2:
				if (conta.getTipo().equalsIgnoreCase("CORRENTE")) {
					RelatorioIO.extratoTributacao(conta);
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente2(clienteAutenticado, conta);
					break;
				} else if (conta.getTipo().equalsIgnoreCase("POUPANCA")) {
					logger.log(Level.INFO, "Qual o valor que deseja simular?");
					Double valor = sc.nextDouble();
					logger.log(Level.INFO, "Qual a quantidade de dias?");
					Integer prazo = sc.nextInt();
					
					RelatorioIO.simulacaoRendimento(valor, prazo, conta.getRendimento());
					logger.log(Level.INFO, "Relatório gerado em /temp/extrato.txt\n");
					subMenuCliente2(clienteAutenticado, conta);
					break;
				}
				break;
			case 0:
				MenuService.menuCliente(clienteAutenticado, conta);
				break;
			default:
				logger.log(Level.WARNING, "Opção inválida!");
				subMenuCliente2(clienteAutenticado, conta);
				break;
			}
		} catch (InputMismatchException e) {
			logger.log(Level.WARNING, "Erro na identificação de variável!");
		}
	}
}