package opera��es;

public class Opera��oComJuros extends Opera��oAbstrata{

	private double jurosDaOpera��o;
	
	public Opera��oComJuros(String tipoOpera��o, double valorOpera��o, double jurosGerado) {
		super(tipoOpera��o, valorOpera��o);
		this.jurosDaOpera��o = jurosGerado;
	}

	public double getJurosDaOpera��o() {
		return jurosDaOpera��o;
	}

	@Override
	public String toString() {
		return "Tipo da opera��o: " + getTipoOpera��o()+" \t "+
			   "Valor da opera��o: " + getValorOpera��o()+" \t "+
			   "Juros gerado: " + jurosDaOpera��o+" \t "+
			   "Data da opera��o: " + getdataOpera��oFormatada()+" \n";
	}

}
