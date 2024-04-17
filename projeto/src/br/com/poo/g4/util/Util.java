package br.com.poo.g4.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Util {

	// Cria uma instância do Logger com o nome da classe Util
	private static Logger logger = Logger.getLogger(Util.class.getName());

	// Construtor privado para evitar a instanciação da classe Util
	private Util() {
		// Lança uma exceção IllegalStateException se alguém tentar criar uma instância
		// desta classe
		throw new IllegalStateException(Util.class.getName());
	}

	// Configura e retorna um Logger personalizado
	public static Logger setupLogger() {
		// Desativa o uso dos Handlers do Logger pai (se houver algum)
		logger.setUseParentHandlers(false);

		// Cria um ConsoleHandler personalizado
		ConsoleHandler customHandler = new ConsoleHandler();

		// Define um Formatter personalizado para o ConsoleHandler
		customHandler.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord rec) {
				// Define o formato da mensagem de log a ser exibida no console
				return rec.getMessage();
			}
		});

		// Adiciona o ConsoleHandler personalizado ao Logger
		logger.addHandler(customHandler);

		// Retorna o Logger configurado
		return logger;
	}

	// Remove todos os Handlers extras do Logger
	public static void customizer() {
		if (logger.getHandlers().length > 1) {
			for (Handler log : logger.getHandlers()) {// iteracao
				logger.removeHandler(log);
				if (logger.getHandlers().length == 1) {
					break;
				}
			}
		}
	}
}
