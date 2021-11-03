package banco;

import java.util.List;

import contas.ContaAbstrata;
import exceções.ContaDuplicada;
import exceções.ContaNãoEncontrada;

//Aqui é criada uma Interface contendo os métodos base de qualquer tipo de repositório que controle contas.
//Dessa forma, é garantido que, independente da forma de armazenamento, a classe que controle a persitência terá esses métodos padrões.

public interface RepositorioDeContas {
	
	void cadastrarConta(ContaAbstrata contaAbstrata) throws ContaDuplicada;
	
	ContaAbstrata procurarConta(String numeroDaConta);
	
	void removerConta(String numeroDaConta) throws ContaNãoEncontrada;
	
	List<ContaAbstrata> listarContasCadastradas();
	
	List<ContaAbstrata> listarContasPositivas();
	
	List<ContaAbstrata> listarContasNegativas();
}
