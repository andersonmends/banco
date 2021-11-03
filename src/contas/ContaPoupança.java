package contas;

import operações.OperaçãoAbstrata;
import operações.OperaçãoNormal;
import operações.OperaçãoComBonus;
import exceções.SaldoInsuficiente;

public class ContaPoupança extends ContaAbstrata {

	private double bonusAcumulado;
	private double percentualDeBonus;
	
	public ContaPoupança(String numConta) {
		super(numConta);
		this.bonusAcumulado = 0;
		this.percentualDeBonus = 0.01;
	}

	public double getBonusAcumulado() {
		return bonusAcumulado;
	}

	protected void setBonusAcumulado(double bonusAcumulado) {
		this.bonusAcumulado = bonusAcumulado;
	}

	public double getPercentualDeBonus() {
		return percentualDeBonus;
	}

	public void setPercentualDeBonus(double percentualDeBonus) {
		this.percentualDeBonus = percentualDeBonus;
	}

	@Override
	public void creditar(double valor) {
		setSaldo(getSaldo()+ valor + getBonusGerado(valor));
		setBonusAcumulado(getBonusAcumulado()+ getBonusGerado(valor));
		OperaçãoAbstrata op = new OperaçãoComBonus("Crédito", valor, getBonusGerado(valor));
		addOperação(op);
	}
	
	private double getBonusGerado (double valor){
		return valor*getPercentualDeBonus();
	}

	@Override
	public void debitar(double valor) throws SaldoInsuficiente {
		if(getSaldo()>=valor){
			setSaldo(getSaldo()-valor);
			OperaçãoAbstrata op = new OperaçãoNormal("Débito", valor);
			addOperação(op);
		}
		else{
			throw new SaldoInsuficiente(getSaldo(),valor);
		}

	}

	@Override
	public String exibirExtrato() {
		String extrato = "Extrato da conta número: "+getNumConta()+"\n";
		extrato += "Saldo Atual: "+getSaldo()+"\n";
		extrato += "Bônus acumulado: "+this.getBonusAcumulado()+"\n";
		extrato += "Porcentagem de bônus: "+this.getPercentualDeBonus()+"%\n";
		
		for (OperaçãoAbstrata op : getExtrato()){
			extrato += op.toString();
		}
		
		return extrato;
	}

}
