package exce��es;

public class ContaN�oEncontrada extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaN�oEncontrada(String numeroDaConta){
		super("A conta de n�mero "+numeroDaConta+" n�o foi encontrada em nossos sistemas.");
	}
}
