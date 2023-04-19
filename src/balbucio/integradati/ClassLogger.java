package balbucio.integradati;

/**
 * <p>Essa classe é usada para criar os métodos de logging padrão. Ela deve ser extendida, não instanciada.</p>
 * @author srbalbucio
 */
public class ClassLogger {

	/**
	 * Este método envia uma mensagem de log simples
	 * @param msg
	 */
	public static void log(String msg) {
		System.out.println("[CH+TI] LOG: "+msg);
	}
	
	/**
	 * Este método envia uma mensagem!
	 * @param msg
	 */
	public static void msg(String msg) {
		System.out.println("App: "+msg);
	}
	
	/**
	 * Este método cria a linha para resposta
	 */
	public static void reply(int sec, String name, String desc) {
		System.out.print("[RESPOSTA] Nome: "+name+" \nO que houve? "+desc+" ("+sec+")");
	}

	/**
	 * Este método corta linha
	 */
	public static void br() {
		System.out.println("---------------------------------------------------------------------------------------");
	}
	
	/**
	 * Envia uma mensagem pedindo para o usuário enviar um comando
	 */
	public static void prompt() {
		br();
		System.out.println("[x] Envie o século ou comando para saber mais:");
	}
	
	public static void to(String msg) {
		System.out.println(msg);
	}
}
