package banco;

import java.util.List;

import contas.ContaAbstrata;
import exce��es.ContaDuplicada;
import exce��es.ContaN�oEncontrada;

//Aqui � criada uma Interface contendo os m�todos base de qualquer tipo de reposit�rio que controle contas.
//Dessa forma, � garantido que, independente da forma de armazenamento, a classe que controle a persit�ncia ter� esses m�todos padr�es.

public interface RepositorioDeContas {
	
	void cadastrarConta(ContaAbstrata contaAbstrata) throws ContaDuplicada;
	
	ContaAbstrata procurarConta(String numeroDaConta);
	
	void removerConta(String numeroDaConta) throws ContaN�oEncontrada;
	
	List<ContaAbstrata> listarContasCadastradas();
	
	List<ContaAbstrata> listarContasPositivas();
	
	List<ContaAbstrata> listarContasNegativas();
}
