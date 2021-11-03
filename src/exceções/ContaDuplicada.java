package exceções;

public class ContaDuplicada extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaDuplicada (String numero){
		super("Já existe uma conta cadastrada com o número "+numero+
				". Por favor, escolha outro número para a sua conta.");
	}
}
