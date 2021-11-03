package contas;

import operações.OperaçãoAbstrata;
import operações.OperaçãoComJuros;
import operações.OperaçãoNormal;
import exceções.SaldoInsuficiente;

public class ContaEspecial extends ContaAbstrata {

	private double limite;
	private double juros;
	
	public ContaEspecial(String numConta) {
		super(numConta);
		this.limite = 200;
		this.juros = 0.1;
	}

	
	
	private double getLimiteDisponível() {
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
			OperaçãoAbstrata op = new OperaçãoNormal("Crédito", valor);
			addOperação(op);
		}
		else{
			OperaçãoAbstrata op = new OperaçãoNormal("Crédito", valor);
			addOperação(op);
		}
	}

	@Override
	public void debitar(double valor) throws SaldoInsuficiente {
		if (valor <= getSaldo()){
			setSaldo(getSaldo()-valor);
			OperaçãoAbstrata op = new OperaçãoNormal("Débito", valor);
			addOperação(op);
		}
		else{
			double saldoParcial = getSaldo() - valor;
			double jurosGerado = jurosDaOperação(-saldoParcial);
			double saldoFinal = saldoParcial - jurosGerado;
			if (-saldoFinal > getLimite()){
				throw new SaldoInsuficiente(getSaldo(), valor, getLimiteDisponível(), jurosGerado);
			}
			else{
				setSaldo(saldoFinal);
				OperaçãoAbstrata opj = new OperaçãoComJuros("Débito", valor, jurosGerado);
				addOperação(opj);
			}
		}
	}
	
	private double jurosDaOperação(double excedente){
		return excedente*getJuros();
	}

	@Override
	public String exibirExtrato() {
		String extrato = "Extrato da conta número: "+getNumConta()+"\n";
		extrato += "Saldo Atual: R$"+getSaldo()+"\n";
		extrato += "Limite disponível: R$"+getLimiteDisponível()+"\n";
		extrato += "Limite especial: R$"+getLimite()+"\n";
		extrato += "Taxa de juros da sua conta: "+getJuros()*100+"%\n";
		
		for (OperaçãoAbstrata op : getExtrato()){
			extrato += op.toString();
		}
		
		return extrato;
	}

}
