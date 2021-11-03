package banco;

import java.util.ArrayList;
import java.util.List;

import contas.ContaAbstrata;
import exce��es.ContaDuplicada;
import exce��es.ContaN�oEncontrada;

public class ControleDeContas implements RepositorioDeContas {
	private List<ContaAbstrata> contasDoBanco; 
	
	public ControleDeContas() {
		this.contasDoBanco = new ArrayList<ContaAbstrata>();
	}
	
	@Override
	public void cadastrarConta(ContaAbstrata contaAbstrata) throws ContaDuplicada {
		ContaAbstrata conta = this.procurarConta(contaAbstrata.getNumConta());
		if(conta==null){
			this.contasDoBanco.add(contaAbstrata);
		}
		else{
			throw new ContaDuplicada(contaAbstrata.getNumConta());
		}
	}

	@Override
	public ContaAbstrata procurarConta(String numeroDaConta) {
		ContaAbstrata contaProcurada = null;
		for (ContaAbstrata conta : this.contasDoBanco){
			if (conta.getNumConta().equals(numeroDaConta)){
				contaProcurada = conta;
				break;
			}
		}
		return contaProcurada;
	}

	@Override
	public void removerConta(String numeroDaConta) throws ContaN�oEncontrada {
		ContaAbstrata conta = procurarConta(numeroDaConta);
		if(conta==null){
			throw new ContaN�oEncontrada(numeroDaConta);
		}
		else{
			this.contasDoBanco.remove(conta);
		}
		
	}

	@Override
	public List<ContaAbstrata> listarContasCadastradas() {
		
		return this.contasDoBanco;
	}

	@Override
	public List<ContaAbstrata> listarContasPositivas() {
		
		List<ContaAbstrata> contasPositivas = new ArrayList<ContaAbstrata>();
		
		for (ContaAbstrata conta : this.contasDoBanco){
			if (conta.getSaldo() >= 0){
				contasPositivas.add(conta);
			}
		}
		return contasPositivas;
	}

	@Override
	public List<ContaAbstrata> listarContasNegativas() {

		List<ContaAbstrata> contasNegativas = new ArrayList<ContaAbstrata>();
		for (ContaAbstrata conta : this.contasDoBanco){
			if (conta.getSaldo() < 0){
				contasNegativas.add(conta);
			}
		}
		return contasNegativas;
	}
	
	
	
}
