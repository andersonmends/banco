package operações;

public class OperaçãoComJuros extends OperaçãoAbstrata{

	private double jurosDaOperação;
	
	public OperaçãoComJuros(String tipoOperação, double valorOperação, double jurosGerado) {
		super(tipoOperação, valorOperação);
		this.jurosDaOperação = jurosGerado;
	}

	public double getJurosDaOperação() {
		return jurosDaOperação;
	}

	@Override
	public String toString() {
		return "Tipo da operação: " + getTipoOperação()+" \t "+
			   "Valor da operação: " + getValorOperação()+" \t "+
			   "Juros gerado: " + jurosDaOperação+" \t "+
			   "Data da operação: " + getdataOperaçãoFormatada()+" \n";
	}

}
