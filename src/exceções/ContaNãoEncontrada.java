package exceções;

public class ContaNãoEncontrada extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaNãoEncontrada(String numeroDaConta){
		super("A conta de número "+numeroDaConta+" não foi encontrada em nossos sistemas.");
	}
}
