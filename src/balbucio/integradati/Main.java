package balbucio.integradati;

import java.util.Scanner;

import balbucio.integradati.prompt.PromptManager;

public class Main extends ClassLogger {

	public static void main(String[] args) {
		new Main();
	}

	private Scanner scanner = new Scanner(System.in);
	private boolean running = false;

	public Main() {
		log("Criado por João Gabriel (vulgo SrBalbucio)");
		log("github/SrBalbucio");
		running = true;
		while (running) {
			prompt();
			to(">> ");
			while(scanner.hasNext()) {
				String cmd = scanner.next();
				PromptManager.resolve(cmd);
			}
		}
	}
	
}