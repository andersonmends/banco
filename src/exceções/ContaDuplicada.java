package exce��es;

public class ContaDuplicada extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaDuplicada (String numero){
		super("J� existe uma conta cadastrada com o n�mero "+numero+
				". Por favor, escolha outro n�mero para a sua conta.");
	}
}
