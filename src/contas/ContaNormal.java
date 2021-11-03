package contas;

import exce��es.SaldoInsuficiente;
import opera��es.Opera��oAbstrata;
import opera��es.Opera��oNormal;

public class ContaNormal extends ContaAbstrata {

	public ContaNormal(String numConta) {
		super(numConta);
	}
	
	public void creditar (double valor){
		setSaldo(getSaldo()+valor);
		Opera��oAbstrata op = new Opera��oNormal("Cr�dito", valor);
		addOpera��o(op);
	}
	
	public void debitar (double valor) throws SaldoInsuficiente{
		if(getSaldo()>=valor){
			setSaldo(getSaldo()-valor);
			Opera��oAbstrata op = new Opera��oNormal("D�bito", valor);
			addOpera��o(op);
		}
		else{
			throw new SaldoInsuficiente(getSaldo(),valor);
		}
	}
	
	public String exibirExtrato(){
		String extrato = "Extrato da conta n�mero: "+getNumConta()+"\n";
		extrato += "Saldo Atual: "+getSaldo()+"\n";
		
		for (Opera��oAbstrata op : getExtrato()){
			extrato += op.toString();
		}
		
		return extrato;
	}

}
