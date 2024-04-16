package br.com.poo.g4.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
					Conta.getMapaContas().put(dados[2], corrente);
					// logger.log(Level.INFO, corrente::toString);
				} else if (dados[0].equalsIgnoreCase(TipoConta.POUPANCA.name())) {
					Conta poupanca = new ContaPoupanca(dados[1], dados[2], Double.parseDouble(dados[3]));
					Conta.getMapaContas().put(dados[2], poupanca);
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
}

/*
 * public static void relatorioListaUsuarios(List<Usuario> nomesUsuarios) throws
 * IOException { String nome = "lista-nomes-usuarios";
 * 
 * BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO +
 * nome + EXTENSAO, true));
 * 
 * buffWrite.append("-------RELATÓRIO: LISTA NOMES DE USUARIOS------\n\n"); if
 * (!nomesUsuarios.isEmpty()) { // Foreach para percorrer a lista de nomes dos
 * pets de um em um for (Usuario usuario : nomesUsuarios) {
 * buffWrite.append(usuario.getNome() + "\n"); } } LocalDateTime ldt =
 * LocalDateTime.now(); buffWrite.append("\nData da requisição: " +
 * dtfBr.format(ldt));
 * buffWrite.append("\n\n---------FIM DA LISTA NOMES DE USUARIOS--------\n\n");
 * buffWrite.close(); }
 * 
 * public static void relatorioListaDenuncia(List<Denuncia> denuncias) throws
 * IOException { String nome = "lista-denuncias";
 * 
 * BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO +
 * nome + EXTENSAO, true));
 * 
 * buffWrite.append("-------RELATÓRIO: LISTA DE DENUNCIAS------\n\n"); if
 * (!denuncias.isEmpty()) { // Foreach para percorrer a lista de nomes dos pets
 * de um em um for (Denuncia denuncia : denuncias) { buffWrite.append(
 * "Detalhamento:" + denuncia.getDetalhamento() + "\nAnônimo: " +
 * denuncia.getAnonimo() + "\n"); } } LocalDateTime ldt = LocalDateTime.now();
 * buffWrite.append("\nData da requisição: " + dtfBr.format(ldt));
 * buffWrite.append("\n\n---------FIM DA LISTA DE DENUNCIAS--------\n\n");
 * buffWrite.close(); }
 * 
 * public static void relatorioListaDenunciaUsuario(List<Denuncia> denuncias,
 * List<Usuario> usuarios) throws IOException { String nome =
 * "lista-denuncias-usuarios";
 * 
 * BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO +
 * nome + EXTENSAO, true));
 * 
 * buffWrite.
 * append("-------RELATÓRIO: LISTA DE DENUNCIAS POR USUARIOS------\n\n"); if
 * (!denuncias.isEmpty() && !usuarios.isEmpty()) { // Foreach para percorrer a
 * lista de nomes dos pets de um em um for (Denuncia denuncia : denuncias) { for
 * (Usuario usuario : usuarios) { if (denuncia.getFkUsu() == usuario.getId()) {
 * buffWrite.append("Detalhamento:" + denuncia.getDetalhamento() + " Anônimo: "
 * + denuncia.getAnonimo() + " Usuário:" + usuario.getNome() + "\n"); } } } }
 * LocalDateTime ldt = LocalDateTime.now();
 * buffWrite.append("\nData da requisição: " + dtfBr.format(ldt)); buffWrite.
 * append("\n\n---------FIM DA LISTA DE DENUNCIAS POR USUARIOS--------\n\n");
 * buffWrite.close(); } }
 */
