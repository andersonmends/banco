package opera��es;

public class Opera��oNormal extends Opera��oAbstrata {

	public Opera��oNormal(String tipoOpera��o, double valorOpera��o) {
		super(tipoOpera��o, valorOpera��o);
	}

	@Override
	public String toString() {
		return "Tipo da opera��o: " + getTipoOpera��o()+" \t "+
			   "Valor da opera��o: " + getValorOpera��o()+" \t "+
			   "Data da opera��o: "+getdataOpera��oFormatada()+"\n";
	}

}
