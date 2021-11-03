package principal;

import javax.swing.JOptionPane;

import contas.ContaAbstrata;
import contas.ContaEspecial;
import contas.ContaNormal;
import contas.ContaPoupan�a;
import exce��es.ContaDuplicada;
import exce��es.ContaN�oEncontrada;

import banco.Banco;
import banco.BancoGenerico;

//Talvez seja necess�rio criar outras exceptions.

public class MainBanco {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*Note que � criada uma inst�ncia do nosso banco concreto, mas est� � guardada em uma vari�vel do tipo 
		 * BancoGenerico (uma Interface), a qual � mais gen�rica. Com isso, o nosso sistema fica mais independente
		 * de classes concretas, que podem ter seu funcionamento mudado. Esta manobra tamb�m permite que
		 * facilmente a classe concreta a ser utilizada seja alterada, pois para trocar de Banco para OutroBanco() bastaria
		 * mudar o tipo de classe ap�s o comando new. Atrav�s do polimorfismo o programa se adaptaria facilmente � nova classe
		 * concreta.
		 */
		BancoGenerico banco = new Banco();
		
		//Voc�s podem modificar a estrutura dos menus para deix�-los mais organizados por tipos de fun��o.
		menuPrincipal(banco);
		
	}
	
	private static void menuPrincipal(BancoGenerico banco){
		while (true){
			int opcaoMenuPrincipal = Integer.parseInt(JOptionPane.showInputDialog("Escolha sua op��o:\n" +
					"<1> Administrar Conta\n" +
					"<2> Administrar Banco\n" +
					"<3> Sair"));
			switch (opcaoMenuPrincipal) {
			case 1:
				//DICA: Ao segurar control e clicar no nome do m�todo o eclipse te leva para a implementa��o do m�todo.
				administrarConta(banco);
				break;
			case 2:
				administrarBanco(banco);
				break;
			case 3:
				//Ecerrar o programa
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
				break;
			}
		}
	}
	
	private static void administrarConta(BancoGenerico banco){
		int opcaoAdministrarBanco = Integer.parseInt(JOptionPane.showInputDialog("Escolha a op��o de Administrador de Conta:\n" +
				"<1> Cadastrar Conta\n" +
				"<2> Remover Conta\n" +
				"<3> Creditar\n" +
				"<4> Debitar\n" +
				"<5> Transferir\n" +
				"<6> Exibir Saldo\n" +
				"<7> Extrato\n" +
				"<8> Menu Principal"));
		switch (opcaoAdministrarBanco) {
		case 1:
			cadastroContas(banco);
			break;
		case 2:
			//criar a op��o de remover conta cadastrada. Lembrar de remover o extrato (em cascata) quando estiver usando Banco de dados.
			break;
		case 3:
			//criar op��o de creditar na conta escolhida um valor escolhido. Lembrar de impedir, na classe Banco, a entrada de valores negativos.
			try {
				banco.creditar(numeroConta(), valorOpera��o());
			} catch (ContaN�oEncontrada e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 4:
			//criar op��o de debitar na conta escolhida um valor escolhidoLembrar de impedir, na classe Banco, a entrada de valores negativos.
			break;
		case 5:
			//criar op��o de transferir dinheiro de uma conta escolhida para outra conta informando o valor desejado. Lembrar de impedir, na classe Banco, a entrada de valores negativos.
			break;
		case 6:
			//criar op��o de exibir saldo da conta escolhida.
			break;
		case 7:
			//criar op��o de exibir extrato da conta escolhida.
			try {
				JOptionPane.showMessageDialog(null, banco.extrato(numeroConta()));
			} catch (ContaN�oEncontrada e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 8:
			//Eu coloquei todas as �ltimas op��es com a funcionalidade de voltar para o menu principal. Voc�s podem tamb�m criar uma op��o para voltar ao menu anterior seguindo este exemplo.
			menuPrincipal(banco);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
			break;
		}
		
	}
	
	private static void administrarBanco(BancoGenerico banco){
		int opcaoAdministrarBanco = Integer.parseInt(JOptionPane.showInputDialog("Escolha a op��o de Administrador do Banco:\n" +
				"<1> Listar contas cadastradas\n" +
				"<2> Listar contas positivas\n" +
				"<3> Listar contas negativas\n" +
				"<4> Saldo total do banco\n" +
				"<5> Relat�rio de banco\n" +
				"<6> Menu Principal"));
		switch (opcaoAdministrarBanco) {
		case 1:
			String contas ="";
			for (ContaAbstrata contaAbstrata : banco.listarContasCadastradas()){
				contas += "N�mero da conta: "+contaAbstrata.getNumConta()+"\t Saldo: "+contaAbstrata.getSaldo()+"\n";
			}
			JOptionPane.showMessageDialog(null, contas);
			break;
		case 2:
			String contasPositivas ="";
			for (ContaAbstrata contaAbstrata : banco.listarContasPositivas()){
				contasPositivas += "N�mero da conta: "+contaAbstrata.getNumConta()+"\t Saldo: "+contaAbstrata.getSaldo()+"\n";
			}
			JOptionPane.showMessageDialog(null, contasPositivas);
			break;
		case 3:
			String contasNegativas ="";
			for (ContaAbstrata contaAbstrata : banco.listarContasNegativas()){
				contasNegativas += "N�mero da conta: "+contaAbstrata.getNumConta()+"\t Saldo: "+contaAbstrata.getSaldo()+"\n";
			}
			JOptionPane.showMessageDialog(null, contasNegativas);
			break;
		case 4:
			//Somar o saldo de todas as contas do banco
			break;
		case 5:
			//Mostrar o n�mero de contas cadastradas, saldo total, n�mero de contas positivas e n�mero de contas negativas
			break;
		case 6:
			menuPrincipal(banco);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
			break;
		}
	}
	
	private static void cadastroContas(BancoGenerico banco){
		int opcaoCadastro = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de conta:\n" +
				"<1> Conta Normal\n" +
				"<2> Conta Poupan�a\n" +
				"<3> Conta Especial\n" +
				"<4> Menu Principal"));
		switch (opcaoCadastro) {
		case 1:
			try {
				banco.cadastrarConta(new ContaNormal(numeroConta()));
			} catch (ContaDuplicada e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 2:
			try {
				banco.cadastrarConta(new ContaPoupan�a(numeroConta()));
			} catch (ContaDuplicada e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 3:
			try {
				banco.cadastrarConta(new ContaEspecial(numeroConta()));
			} catch (ContaDuplicada e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
		case 4: 
			menuPrincipal(banco);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
			break;
		}
	}
	
	private static String numeroConta(){
		return JOptionPane.showInputDialog("Digite o n�mero da conta:");
	}
	
	private static double valorOpera��o(){
		return Double.parseDouble(JOptionPane.showInputDialog("Digite o valor desejado:"));
	}

}
