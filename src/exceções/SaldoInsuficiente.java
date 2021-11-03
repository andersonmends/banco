package exce��es;

public class SaldoInsuficiente extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInsuficiente(double saldo, double valor){
		super("O seu saldo de "+saldo+" � insuficiente para a realiza��o do d�bito no valor de "+valor+".");
	}
	
	public SaldoInsuficiente(double saldo, double valor,double limiteDispon�vel, double jurosOpera��o){
		super("O seu saldo de "+saldo+" somado ao seu limite de "+limiteDispon�vel+" s�o insuficientes para a realiza��o do d�bito no valor de "+valor+" e juros de "+jurosOpera��o+".");
	}
}
