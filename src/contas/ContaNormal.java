package contas;

import exceções.SaldoInsuficiente;
import operações.OperaçãoAbstrata;
import operações.OperaçãoNormal;

public class ContaNormal extends ContaAbstrata {

	public ContaNormal(String numConta) {
		super(numConta);
	}
	
	public void creditar (double valor){
		setSaldo(getSaldo()+valor);
		OperaçãoAbstrata op = new OperaçãoNormal("Crédito", valor);
		addOperação(op);
	}
	
	public void debitar (double valor) throws SaldoInsuficiente{
		if(getSaldo()>=valor){
			setSaldo(getSaldo()-valor);
			OperaçãoAbstrata op = new OperaçãoNormal("Débito", valor);
			addOperação(op);
		}
		else{
			throw new SaldoInsuficiente(getSaldo(),valor);
		}
	}
	
	public String exibirExtrato(){
		String extrato = "Extrato da conta número: "+getNumConta()+"\n";
		extrato += "Saldo Atual: "+getSaldo()+"\n";
		
		for (OperaçãoAbstrata op : getExtrato()){
			extrato += op.toString();
		}
		
		return extrato;
	}

}
