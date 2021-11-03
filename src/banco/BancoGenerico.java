package banco;

import java.util.List;

import contas.ContaAbstrata;
import exce��es.ContaDuplicada;
import exce��es.ContaN�oEncontrada;

/*
 * Aqui � criada uma Interface que cont�m os m�todos padr�es para qualquer banco que far� parte do sistema.
 * Dessa forma o code n�o fica amarrado a um tipo de banco concreto.
 */

public interface BancoGenerico {
	
	public String extrato(String numeroDaConta) throws ContaN�oEncontrada;

	public void creditar(String numeroDaConta, double valor) throws ContaN�oEncontrada;

	public void cadastrarConta(ContaAbstrata contaAbstrata) throws ContaDuplicada;

	public List<ContaAbstrata> listarContasCadastradas();

	public List<ContaAbstrata> listarContasPositivas();

	public List<ContaAbstrata> listarContasNegativas();
	}
