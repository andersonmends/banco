package opera��es;


public class Opera��oComBonus extends Opera��oAbstrata {

	private double bonusGerado;
	
	public Opera��oComBonus(String tipoOpera��o, double valorOpera��o, double bonusGerado) {
		super(tipoOpera��o, valorOpera��o);
		this.bonusGerado = bonusGerado;
	}

	public double getBonusGerado() {
		return bonusGerado;
	}

	@Override
	public String toString() {
		return "Tipo da opera��o: " + getTipoOpera��o()+" \t "+
			   "Valor da opera��o: " + getValorOpera��o()+" \t "+
			   "B�nus gerado: " + bonusGerado+" \t "+
			   "Data da opera��o: " + getdataOpera��oFormatada()+" \n";
	}

}
