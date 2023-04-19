package balbucio.integradati.prompt.impl;

import balbucio.integradati.ClassLogger;
import balbucio.integradati.prompt.Command;

public class ExitCommand extends ClassLogger implements Command{

	@Override
	public String getName() {
		return "exit";
	}

	@Override
	public void run() {
		System.exit(0);
		log("Fechando, bye!");
	}
}
