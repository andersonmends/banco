package banco;

import java.util.List;

import contas.ContaAbstrata;
import exce��es.ContaDuplicada;
import exce��es.ContaN�oEncontrada;

/*
 * Aqui � criada um tipo de banco concreto. Nessa classe s�o colocados os c�digos espec�ficos para este tipo de banco.
 */

public class Banco implements BancoGenerico {
	private RepositorioDeContas repositorio;
	
	public Banco(){
		repositorio = new ControleDeContas();
	}
	
	public String extrato(String numeroDaConta) throws ContaN�oEncontrada{
		ContaAbstrata conta = repositorio.procurarConta(numeroDaConta);
		
		if (conta == null){
			throw new ContaN�oEncontrada(numeroDaConta);
		}else{
			return conta.exibirExtrato();
		}
	}
	
	public void creditar(String numeroDaConta, double valor) throws ContaN�oEncontrada{
		ContaAbstrata conta = repositorio.procurarConta(numeroDaConta);
		if (conta == null){
			throw new ContaN�oEncontrada(numeroDaConta);
		}else{
			conta.creditar(valor);
		}
	}
	
	public void cadastrarConta(ContaAbstrata contaAbstrata) throws ContaDuplicada{
		repositorio.cadastrarConta(contaAbstrata);
	}
	
	public List<ContaAbstrata> listarContasCadastradas(){
		return repositorio.listarContasCadastradas();
	}
	
	public List<ContaAbstrata> listarContasPositivas(){
		return repositorio.listarContasPositivas();
	}
	public List<ContaAbstrata> listarContasNegativas(){
		return repositorio.listarContasNegativas();
	}
}
