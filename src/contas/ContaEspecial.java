package contas;

import opera��es.Opera��oAbstrata;
import opera��es.Opera��oComJuros;
import opera��es.Opera��oNormal;
import exce��es.SaldoInsuficiente;

public class ContaEspecial extends ContaAbstrata {

	private double limite;
	private double juros;
	
	public ContaEspecial(String numConta) {
		super(numConta);
		this.limite = 200;
		this.juros = 0.1;
	}

	
	
	private double getLimiteDispon�vel() {
		return getSaldo()+getLimite();
	}


	private double getLimite() {
		return limite;
	}



	private double getJuros() {
		return juros;
	}



	public void setLimite(double limite) {
		this.limite = limite;
	}



	public void setJuros(double juros) {
		this.juros = juros;
	}



	@Override
	public void creditar(double valor) {
		setSaldo(getSaldo()+valor);
		if(getSaldo() >= 0){
			Opera��oAbstrata op = new Opera��oNormal("Cr�dito", valor);
			addOpera��o(op);
		}
		else{
			Opera��oAbstrata op = new Opera��oNormal("Cr�dito", valor);
			addOpera��o(op);
		}
	}

	@Override
	public void debitar(double valor) throws SaldoInsuficiente {
		if (valor <= getSaldo()){
			setSaldo(getSaldo()-valor);
			Opera��oAbstrata op = new Opera��oNormal("D�bito", valor);
			addOpera��o(op);
		}
		else{
			double saldoParcial = getSaldo() - valor;
			double jurosGerado = jurosDaOpera��o(-saldoParcial);
			double saldoFinal = saldoParcial - jurosGerado;
			if (-saldoFinal > getLimite()){
				throw new SaldoInsuficiente(getSaldo(), valor, getLimiteDispon�vel(), jurosGerado);
			}
			else{
				setSaldo(saldoFinal);
				Opera��oAbstrata opj = new Opera��oComJuros("D�bito", valor, jurosGerado);
				addOpera��o(opj);
			}
		}
	}
	
	private double jurosDaOpera��o(double excedente){
		return excedente*getJuros();
	}

	@Override
	public String exibirExtrato() {
		String extrato = "Extrato da conta n�mero: "+getNumConta()+"\n";
		extrato += "Saldo Atual: R$"+getSaldo()+"\n";
		extrato += "Limite dispon�vel: R$"+getLimiteDispon�vel()+"\n";
		extrato += "Limite especial: R$"+getLimite()+"\n";
		extrato += "Taxa de juros da sua conta: "+getJuros()*100+"%\n";
		
		for (Opera��oAbstrata op : getExtrato()){
			extrato += op.toString();
		}
		
		return extrato;
	}

}
