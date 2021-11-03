package contas;

import java.util.ArrayList;
import java.util.List;

import exce��es.SaldoInsuficiente;

import opera��es.Opera��oAbstrata;

public abstract class ContaAbstrata{
	
	private String numConta;
	private double saldo;
	private  List<Opera��oAbstrata> extrato;
	
	public ContaAbstrata(String numConta) {
		this.numConta = numConta;
		this.saldo = 0;
		this.extrato = new ArrayList<Opera��oAbstrata>();
	}
	
	//Criar uma exception para evitar a entrada de valores negativos. Isso deve ser feito tamb�m no banco.
	public abstract void creditar (double valor);
	
	//Criar uma exception para evitar a entrada de valores negativos. Isso deve ser feito tamb�m no banco.
	public abstract void debitar (double valor) throws SaldoInsuficiente;
	
	public abstract String exibirExtrato();
	
	//A manipula��o da conta gera um log que compor� o extrato da conta.
	protected void addOpera��o (Opera��oAbstrata op){
		this.extrato.add(op);
	}
	
	public String getNumConta() {
		return numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	protected List<Opera��oAbstrata> getExtrato() {
		return extrato;
	}
	
}
