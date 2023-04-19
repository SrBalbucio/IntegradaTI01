package balbucio.integradati.prompt;

import java.util.ArrayList;
import java.util.List;

import balbucio.integradati.ClassLogger;
import balbucio.integradati.prompt.impl.*;
import balbucio.integradati.search.SearchEngine;

public class PromptManager extends ClassLogger {

	private static List<Command> commands = new ArrayList<>();
	private static SearchEngine engine;

	static {
		engine = new SearchEngine();
	}

	/**
	 * Registra os comandos padrões do app
	 */
	public static void registerCommands() {
		commands.add(new ExitCommand());
		commands.add(new HelpCommand());
	}

	/**
	 * Resolve o prompt enviado pelo usuário
	 *
	 * @param cmd
	 */
	public static void resolve(String cmd) {
		if (commands.stream().anyMatch(c -> c.getName().equalsIgnoreCase(cmd))) {
			Command command = commands.stream().filter(c -> c.getName().equalsIgnoreCase(cmd)).findFirst().orElse(null);
			command.run();
			return;
		}

		if (cmd.startsWith("add")) {
			String[] command = cmd.split(" ");
			if (command.length < 3) {
				msg("Uso incorreto! Use: add <name> <seculo> <description>");
				return;
			}

			engine.addAcontecimento(command[1], Integer.parseInt(command[2]), command[3]);
			msg("Adicionado!");
			return;
		}

		try {
			int seculo = Integer.parseInt(cmd);
			List<Object[]> objs = engine.getAcontecimentos();
			for (Object[] o : objs) {
				if ((Integer) o[0] == seculo) {
					reply(seculo, (String) o[1], (String) o[2]);
				}
			}
		} catch (Exception e) {
			msg("Se você está tentando fazer uma pesquisa envie apenas o número, se não use help para verificar os comandos disponíveis, pois este não existe!");
		}
	}

}
