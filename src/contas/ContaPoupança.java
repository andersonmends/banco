package contas;

import opera��es.Opera��oAbstrata;
import opera��es.Opera��oNormal;
import opera��es.Opera��oComBonus;
import exce��es.SaldoInsuficiente;

public class ContaPoupan�a extends ContaAbstrata {

	private double bonusAcumulado;
	private double percentualDeBonus;
	
	public ContaPoupan�a(String numConta) {
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
		Opera��oAbstrata op = new Opera��oComBonus("Cr�dito", valor, getBonusGerado(valor));
		addOpera��o(op);
	}
	
	private double getBonusGerado (double valor){
		return valor*getPercentualDeBonus();
	}

	@Override
	public void debitar(double valor) throws SaldoInsuficiente {
		if(getSaldo()>=valor){
			setSaldo(getSaldo()-valor);
			Opera��oAbstrata op = new Opera��oNormal("D�bito", valor);
			addOpera��o(op);
		}
		else{
			throw new SaldoInsuficiente(getSaldo(),valor);
		}

	}

	@Override
	public String exibirExtrato() {
		String extrato = "Extrato da conta n�mero: "+getNumConta()+"\n";
		extrato += "Saldo Atual: "+getSaldo()+"\n";
		extrato += "B�nus acumulado: "+this.getBonusAcumulado()+"\n";
		extrato += "Porcentagem de b�nus: "+this.getPercentualDeBonus()+"%\n";
		
		for (Opera��oAbstrata op : getExtrato()){
			extrato += op.toString();
		}
		
		return extrato;
	}

}
