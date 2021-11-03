package exceções;

public class SaldoInsuficiente extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInsuficiente(double saldo, double valor){
		super("O seu saldo de "+saldo+" é insuficiente para a realização do débito no valor de "+valor+".");
	}
	
	public SaldoInsuficiente(double saldo, double valor,double limiteDisponível, double jurosOperação){
		super("O seu saldo de "+saldo+" somado ao seu limite de "+limiteDisponível+" são insuficientes para a realização do débito no valor de "+valor+" e juros de "+jurosOperação+".");
	}
}
