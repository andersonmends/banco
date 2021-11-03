package operações;


public class OperaçãoComBonus extends OperaçãoAbstrata {

	private double bonusGerado;
	
	public OperaçãoComBonus(String tipoOperação, double valorOperação, double bonusGerado) {
		super(tipoOperação, valorOperação);
		this.bonusGerado = bonusGerado;
	}

	public double getBonusGerado() {
		return bonusGerado;
	}

	@Override
	public String toString() {
		return "Tipo da operação: " + getTipoOperação()+" \t "+
			   "Valor da operação: " + getValorOperação()+" \t "+
			   "Bônus gerado: " + bonusGerado+" \t "+
			   "Data da operação: " + getdataOperaçãoFormatada()+" \n";
	}

}
