package banco;

import java.util.List;

import contas.ContaAbstrata;
import exceções.ContaDuplicada;
import exceções.ContaNãoEncontrada;

/*
 * Aqui é criada uma Interface que contém os métodos padrões para qualquer banco que fará parte do sistema.
 * Dessa forma o code não fica amarrado a um tipo de banco concreto.
 */

public interface BancoGenerico {
	
	public String extrato(String numeroDaConta) throws ContaNãoEncontrada;

	public void creditar(String numeroDaConta, double valor) throws ContaNãoEncontrada;

	public void cadastrarConta(ContaAbstrata contaAbstrata) throws ContaDuplicada;

	public List<ContaAbstrata> listarContasCadastradas();

	public List<ContaAbstrata> listarContasPositivas();

	public List<ContaAbstrata> listarContasNegativas();
	}
