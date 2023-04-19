package balbucio.integradati.prompt.impl;

import balbucio.integradati.ClassLogger;
import balbucio.integradati.prompt.Command;

public class HelpCommand extends ClassLogger implements Command {

	@Override
	public String getName() {
		return "help";
	}

	@Override
	public void run() {
		msg("Para adicionar um novo acontecimento, use o comando add <name> <seculo> <descrição> e ele adicionará ao banco de dados.");
		msg("Comandos disponíveis:");
		msg("help - Envia esta mensagem");
		msg("exit - Fecha o app");
	}

}
