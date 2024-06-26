package br.com.poo.g4.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import br.com.poo.g4.entities.*;
import br.com.poo.g4.enums.TipoConta;
import br.com.poo.g4.enums.TipoFuncionario;

public class RelatorioIO {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
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
					Funcionario gerente = new Gerente(dados[1], dados[2], dados[3], dados[4]);
					Funcionario.getMapaFuncionarios().put(dados[2], gerente);
				} else if (dados[0].equalsIgnoreCase(TipoFuncionario.DIRETOR.name())) {
					Funcionario diretor = new Diretor(dados[1], dados[2], dados[3]);
					Funcionario.getMapaFuncionarios().put(dados[2], diretor);
				} else if (dados[0].equalsIgnoreCase(TipoFuncionario.PRESIDENTE.name())) {
					Funcionario presidente = new Presidente(dados[1], dados[2], dados[3]);
					Funcionario.getMapaFuncionarios().put(dados[2], presidente);
				} else if (dados[0].equalsIgnoreCase(TipoConta.CORRENTE.name())) {
					Conta corrente = new ContaCorrente(dados[1], dados[2]);
					Conta.getMapaContas().put(dados[1], corrente);
				} else if (dados[0].equalsIgnoreCase(TipoConta.POUPANCA.name())) {
					Conta poupanca = new ContaPoupanca(dados[1], dados[2], Double.parseDouble(dados[3]));
					Conta.getMapaContas().put(dados[1], poupanca);
				} else if (dados[0].equalsIgnoreCase("CLIENTE")) {
					Cliente cliente = new Cliente(dados[1], dados[2], dados[3]);
					Cliente.getMapaClientes().put(dados[2], cliente);
				}
			} else {
				break;
			}
		}
		buffRead.close();
	}

	public static void cadastrarCliente(Cliente cliente) throws IOException {
		String nome = "banco";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append("\n").append("Cliente;" + cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getSenha()
				+ ";");
		buffWrite.close();
	}
	
	public static void cadastrarGerente(Funcionario gerente) throws IOException {
		String nome = "banco";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append("\n").append("Gerente;" + gerente.getNome() + ";" + gerente.getCpf() + ";" + gerente.getSenha()
				+ ";" + gerente.getAgencia() + ";");
		buffWrite.close();
	}
	
	public static void cadastrarDiretor(Funcionario diretor) throws IOException {
		String nome = "banco";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append("\n").append("Diretor;" + diretor.getNome() + ";" + diretor.getCpf() + ";" + diretor.getSenha()
				+ ";");
		buffWrite.close();
	}
	
	public static void cadastrarConta(Conta conta) throws IOException {
		String nome = "banco";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append("\n").append(conta.getTipo() + ";" + conta.getCpf() + ";" + conta.getAgencia()
				+ ";");
		buffWrite.close();
	}
	
	public static void extratoSaque(Double quantidade) throws IOException {
		
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">========================================<\n");		
		buffWrite.append("              Saque realizado!\n\n");
		buffWrite.append(" Data: " + dtfBr.format(ldt) + "\n");
		buffWrite.append(" Valor: R$ " + quantidade + "\n\n");
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();			
	}
	
	public static void extratoDeposito(Double quantidade) throws IOException {
		
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">========================================<\n");		
		buffWrite.append("            Depósito realizado!\n\n");
		buffWrite.append(" Data: " + dtfBr.format(ldt) + "\n");
		buffWrite.append(" Valor: R$ " + quantidade + "\n\n");
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();
	}
	
	public static void extratoTransferencia(Conta destino, Double quantidade) throws IOException {
		
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">========================================<\n");		
		buffWrite.append("          Transferência realizada!\n\n");
		buffWrite.append(" Data: " + dtfBr.format(ldt) + "\n");
		buffWrite.append(" Valor: R$ " + quantidade + "\n");
		buffWrite.append(" CPF Destinatário: " + destino.getCpf() + "\n\n");
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();		
	}
	
	public static void extratoSaldo(Conta conta) throws IOException {
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">========================================<\n\n");
		buffWrite.append(" Saldo: R$ " + conta.getSaldo() + "\n");		
		buffWrite.append(" Data: " + dtfBr.format(ldt) + "\n\n");
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();	
	}
	
	public static void extratoTributacao(Conta conta) throws IOException {
		String nome = "extrato";
		LocalDateTime ldt = LocalDateTime.now();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">========================================<\n\n");
		buffWrite.append(" Tributação total de saques: R$ " + ContaCorrente.getTributacoesSaque() + "\n");
		buffWrite.append(" Tributação total de depósitos: R$ " + ContaCorrente.getTributacoesDeposito() + "\n");
		buffWrite.append(" Tributação total de transferências: R$ " + ContaCorrente.getTributacoesTransferencia() + "\n");		
		buffWrite.append(" Data de atualização: " + dtfBr.format(ldt) + "\n\n");
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();
	}
	
	public static void simulacaoRendimento(Double valor, Integer prazo, Double rendimento) throws IOException {
		String nome = "extrato";
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append(">========================================<\n");
		buffWrite.append("         Simulação de rendimento:\n\n");
		buffWrite.append(" Valor inicial: R$" + valor + "\n");
		buffWrite.append(" Prazo: " + prazo + "dias\n");		
		buffWrite.append(" Valor final: " + (valor + (valor * rendimento * prazo)) + "\n\n");
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();	
	}
	
	public static void relatorioAgencia(String agencia, Map<String, Conta> mapaContas) throws IOException {
		String nome = "relatorios";
		LocalDateTime ldt = LocalDateTime.now();
		
		Integer quantidadeContas = 0;
		Double saldoTotal = 0.0;
		Integer contasCorrente = 0;
		Integer contasPoupanca = 0;

		
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
		
		buffWrite.append(">========================================<\n");
		buffWrite.append("               Agência #" + agencia + "\n\n");
		buffWrite.append(" Quantidade de contas: " + quantidadeContas + "\n");
		buffWrite.append(" Contas-corrente: " + contasCorrente + "\n");
		buffWrite.append(" Contas-poupança: " + contasPoupanca + "\n");
		buffWrite.append(" Total de saldo: R$ " + saldoTotal + "\n");
		buffWrite.append(" Quantidade de saques: " + Conta.getSaquesTotais() + "\n");
		buffWrite.append(" Quantidade de depósitos: " + Conta.getDepositosTotais() + "\n");
		buffWrite.append(" Data de atualização: " + dtfBr.format(ldt) + "\n\n");
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();
	}
	
	public static void relatorioContasGerente(Funcionario gerente) throws IOException {
		String nome = "relatorios";
		Map<String, Conta> mapaContas = Conta.getMapaContas();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append(">========================================<\n");
		buffWrite.append("               Agência #" + gerente.getAgencia() + "\n\n");
		for (Conta c : mapaContas.values()) {
			if (c.getAgencia().equals(gerente.getAgencia())) {
				buffWrite.append(" " + c.toString() + "\n");
			}
		}
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();	
	}
	
	public static void relatorioDiretores(Funcionario presidente) throws IOException {
		String nome = "relatorios";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		Map<String, Funcionario> mapaFuncionarios = Funcionario.getMapaFuncionarios();
		
		buffWrite.append(">========================================<\n");
		buffWrite.append("      Presidente " + presidente.getNome() + "\n\n");
		for (Funcionario funcionario : mapaFuncionarios.values()) {
			if (funcionario.getTipo().equalsIgnoreCase("DIRETOR")) {
				buffWrite.append(" " + funcionario.toString() + "\n");
			}
		}
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");		
		
		buffWrite.close();	
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
		
		buffWrite.append(">========================================<\n");
		buffWrite.append("      Presidente " + presidente.getNome() + "\n\n");
		buffWrite.append(" Total de capital: R$ " + capitalTotal + "\n");
		buffWrite.append(" Data de atualização: " + dtfBr.format(ldt) + "\n\n");
		buffWrite.append("                 UruBank\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();	
	}
	
	public static void operacoes(String operacao, Conta conta) throws IOException {
		String nome = "operacoes";
		
		LocalDateTime ldt = LocalDateTime.now();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		
		buffWrite.append(">========================================<\n");
		buffWrite.append("      Operação " + operacao + " realizada!\n");
		buffWrite.append("Conta " + conta.getTipo() + " CPF: " + conta.getCpf() + " Data: " + dtfBr.format(ldt) + "\n");
		buffWrite.append(">========================================<\n\n");
		
		buffWrite.close();	
	}
}

