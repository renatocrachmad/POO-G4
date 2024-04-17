package br.com.poo.g4.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g4.entities.*;
import br.com.poo.g4.enums.TipoConta;
import br.com.poo.g4.enums.TipoFuncionario;
import br.com.poo.g4.util.Util;

public class RelatorioIO {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	private static Logger logger = Util.setupLogger();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	static DateTimeFormatter dtfBr = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] dados = linha.split(";");
				if (dados[0].equalsIgnoreCase(TipoFuncionario.GERENTE.name())) {
					Funcionario gerente = new Gerente(dados[1], dados[2], dados[3], Integer.parseInt(dados[4]));
					Funcionario.getMapaFuncionarios().put(dados[2], gerente);
					// logger.log(Level.INFO, gerente::toString);
				} else if (dados[0].equalsIgnoreCase(TipoFuncionario.DIRETOR.name())) {
					Funcionario diretor = new Diretor(dados[1], dados[2], dados[3]);
					Funcionario.getMapaFuncionarios().put(dados[2], diretor);
					// logger.log(Level.INFO, diretor::toString);
				} else if (dados[0].equalsIgnoreCase(TipoFuncionario.PRESIDENTE.name())) {
					Funcionario presidente = new Presidente(dados[1], dados[2], dados[3]);
					Funcionario.getMapaFuncionarios().put(dados[2], presidente);
					// logger.log(Level.INFO, presidente::toString);
				} else if (dados[0].equalsIgnoreCase(TipoConta.CORRENTE.name())) {
					Conta corrente = new ContaCorrente(dados[1], dados[2], Double.parseDouble(dados[3]));
					Conta.getMapaContas().put(dados[1], corrente);
					// logger.log(Level.INFO, corrente::toString);
				} else if (dados[0].equalsIgnoreCase(TipoConta.POUPANCA.name())) {
					Conta poupanca = new ContaPoupanca(dados[1], dados[2], Double.parseDouble(dados[3]));
					Conta.getMapaContas().put(dados[1], poupanca);
					// logger.log(Level.INFO, poupanca::toString);
				} else if (dados[0].equalsIgnoreCase("CLIENTE")) {
					Cliente cliente = new Cliente(dados[1], dados[2], dados[3]);
					Cliente.getMapaClientes().put(dados[2], cliente);
					// logger.log(Level.INFO, cliente::toString);
				}
			} else {
				break;
			}
		}
		buffRead.close();
	}

	public static void cadastrarCliente(String fileName, Cliente novoCliente) throws IOException {
		// Instancia o objeto da classe de escrita de arquivos no diretório "pathString"
		String pathString = PATH_BASICO + fileName + EXTENSAO;
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathString, true));

		// Escreve os dados ao final da linha do arquivo de texto
		writer.append("Cliente;" + novoCliente.getNome() + ";" + novoCliente.getCpf() + ";" + novoCliente.getSenha()
				+ ";\n");
		//writer.flush();
		writer.close();
	}
	
	public static void extratoSaque(Double quantidade) throws IOException {
		
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">=====================<\n");		
		buffWrite.append("         Saque realizado!\n");
		buffWrite.append("Data: " + dtfBr.format(ldt) + "\n");
		buffWrite.append("Valor: R$ " + quantidade + "\n");
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");
		
		buffWrite.close();			
	}
	
	public static void extratoDeposito(Double quantidade) throws IOException {
		
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">=====================<\n");		
		buffWrite.append("         Depósito realizado!\n");
		buffWrite.append("Data: " + dtfBr.format(ldt) + "\n");
		buffWrite.append("Valor: R$ " + quantidade + "\n");
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");
		
		buffWrite.close();
	}
	
	public static void extratoTransferencia(Conta destino, Double quantidade) throws IOException {
		
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">=====================<\n");		
		buffWrite.append("         Transferência realizada!\n");
		buffWrite.append("Data: " + dtfBr.format(ldt) + "\n");
		buffWrite.append("Valor: R$ " + quantidade + "\n");
		buffWrite.append("CPF Destinatário: " + destino.getCpf() + "\n");
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");
		
		buffWrite.close();		
	}
	
	public static void extratoSaldo(Conta conta) throws IOException {
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">=====================<\n");
		buffWrite.append("Saldo: R$ " + conta.getSaldo() + "\n");		
		buffWrite.append("Data: " + dtfBr.format(ldt) + "\n");
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");
		
		buffWrite.close();	
	}
	
	public static void extratoTributacao(Conta conta) throws IOException {
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO));

		buffWrite.append(">=====================<\n");
		buffWrite.append("Tributação total de saques: R$ " + ContaCorrente.getTributacoesSaque() + "\n");
		buffWrite.append("Tributação total de depósitos: R$" + ContaCorrente.getTributacoesDeposito() + "\n");
		buffWrite.append("Tributação total de transferências: R$ " + ContaCorrente.getTributacoesTransferencia() + "\n");		
		buffWrite.append("Data de atualização: " + dtfBr.format(ldt) + "\n");
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");
		
		buffWrite.close();
	}
	
	public static void simulacaoRendimento(Double valor, Integer prazo, Double rendimento) throws IOException {
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append(">=====================<\n");
		buffWrite.append("     Simulação de rendimento:");
		buffWrite.append("Valor inicial: R$" + valor + "\n");
		buffWrite.append("Prazo: " + prazo + "dias\n");		
		buffWrite.append("Valor final: " + (valor + (valor * rendimento * prazo)) + "\n");
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");
		
		buffWrite.close();	
	}
	
	public static void relatorioAgencia(String agencia) throws IOException {
		String nome = "relatorios";
		LocalDateTime ldt = LocalDateTime.now();
		
		Integer quantidadeContas = 0;
		Double saldoTotal = 0.0;
		Integer contasCorrente = 0;
		Integer contasPoupanca = 0;
		
		Map<String, Conta> mapaContas = Conta.getMapaContas();
		
		for (Conta conta : mapaContas.values()) {
			if (conta.getAgencia().equals(agencia)) {
				quantidadeContas += 1;
				saldoTotal += conta.getSaldo();
				if (conta.getTipo().equalsIgnoreCase("CORRENTE")) {
					contasCorrente += 1;
				} else if (conta.getTipo().equalsIgnoreCase("POUPANCA")) {
					contasPoupanca += 1;
				}
			}
		}
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append(">=====================<\n");
		buffWrite.append("       Agência #" + agencia + "\n");
		buffWrite.append("Quantidade de contas: " + quantidadeContas + "\n");
		buffWrite.append("Contas-corrente: " + contasCorrente + "\n");
		buffWrite.append("Contas-poupança: " + contasPoupanca + "\n");
		buffWrite.append("Total de saldo: R$ " + saldoTotal + "\n");
		buffWrite.append("Quantidade de saques: " + Conta.getSaquesTotais() + "\n");
		buffWrite.append("Quantidade de depósitos: " + Conta.getDepositosTotais() + "\n");
		buffWrite.append("Data de atualização: " + dtfBr.format(ldt) + "\n");
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");
		
		buffWrite.close();
	}
	
	public static void relatorioContas(Cliente cliente, Funcionario diretor) throws IOException {
		String nome = "relatorios";
		Map<String, Cliente> mapaClientes = cliente.getMapaClientes();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append(">=====================<\n");
		buffWrite.append("      Diretor " + diretor.getNome() + "\n\n");
		for (Cliente c : mapaClientes.values()) {
			buffWrite.append(c.toString());
		}
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");
	}
	
	public static void relatorioDiretores(Funcionario presidente) throws IOException {
		String nome = "relatorios";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		Map<String, Funcionario> mapaFuncionarios = Funcionario.getMapaFuncionarios();
		
		buffWrite.append(">=====================<\n");
		buffWrite.append("      Presidente " + presidente.getNome() + "\n\n");
		for (Funcionario funcionario : mapaFuncionarios.values()) {
			if (funcionario.getTipo().equalsIgnoreCase("DIRETOR")) {
				buffWrite.append(funcionario.toString());
			}
		}
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");		
	}
	
	public static void relatorioCapital(Funcionario presidente) throws IOException {
		String nome = "relatorios";
		LocalDateTime ldt = LocalDateTime.now();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		Double capitalTotal = 0.0;		
		Map<String, Conta> mapaContas = Conta.getMapaContas();
		
		for (Conta conta : mapaContas.values()) {
			capitalTotal += conta.getSaldo();
		}
		
		buffWrite.append(">=====================<\n");
		buffWrite.append("      Presidente " + presidente.getNome() + "\n\n");
		buffWrite.append("Total de capital: R$ " + capitalTotal + "\n");
		buffWrite.append("Data de atualização: " + dtfBr.format(ldt) + "\n");
		buffWrite.append("         UruBank\n");
		buffWrite.append(">=====================<\n\n");
	}
}


