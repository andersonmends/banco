package banco;

import java.util.List;

import contas.ContaAbstrata;
import exceções.ContaDuplicada;
import exceções.ContaNãoEncontrada;

/*
 * Aqui é criada um tipo de banco concreto. Nessa classe são colocados os códigos específicos para este tipo de banco.
 */

public class Banco implements BancoGenerico {
	private RepositorioDeContas repositorio;
	
	public Banco(){
		repositorio = new ControleDeContas();
	}
	
	public String extrato(String numeroDaConta) throws ContaNãoEncontrada{
		ContaAbstrata conta = repositorio.procurarConta(numeroDaConta);
		
		if (conta == null){
			throw new ContaNãoEncontrada(numeroDaConta);
		}else{
			return conta.exibirExtrato();
		}
	}
	
	public void creditar(String numeroDaConta, double valor) throws ContaNãoEncontrada{
		ContaAbstrata conta = repositorio.procurarConta(numeroDaConta);
		if (conta == null){
			throw new ContaNãoEncontrada(numeroDaConta);
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
