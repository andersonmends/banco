package operações;

public class OperaçãoNormal extends OperaçãoAbstrata {

	public OperaçãoNormal(String tipoOperação, double valorOperação) {
		super(tipoOperação, valorOperação);
	}

	@Override
	public String toString() {
		return "Tipo da operação: " + getTipoOperação()+" \t "+
			   "Valor da operação: " + getValorOperação()+" \t "+
			   "Data da operação: "+getdataOperaçãoFormatada()+"\n";
	}

}
