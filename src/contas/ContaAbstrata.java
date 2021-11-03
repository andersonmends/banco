package contas;

import java.util.ArrayList;
import java.util.List;

import exceções.SaldoInsuficiente;

import operações.OperaçãoAbstrata;

public abstract class ContaAbstrata{
	
	private String numConta;
	private double saldo;
	private  List<OperaçãoAbstrata> extrato;
	
	public ContaAbstrata(String numConta) {
		this.numConta = numConta;
		this.saldo = 0;
		this.extrato = new ArrayList<OperaçãoAbstrata>();
	}
	
	//Criar uma exception para evitar a entrada de valores negativos. Isso deve ser feito também no banco.
	public abstract void creditar (double valor);
	
	//Criar uma exception para evitar a entrada de valores negativos. Isso deve ser feito também no banco.
	public abstract void debitar (double valor) throws SaldoInsuficiente;
	
	public abstract String exibirExtrato();
	
	//A manipulação da conta gera um log que comporá o extrato da conta.
	protected void addOperação (OperaçãoAbstrata op){
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

	protected List<OperaçãoAbstrata> getExtrato() {
		return extrato;
	}
	
}
