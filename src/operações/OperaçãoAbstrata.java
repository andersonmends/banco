package opera��es;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Opera��oAbstrata {
	private String tipoOpera��o;
	private double valorOpera��o;
	private Date dataOpera��o;
	
	public Opera��oAbstrata(String tipoOpera��o, double valorOpera��o) {
		super();
		this.tipoOpera��o = tipoOpera��o;
		this.valorOpera��o = valorOpera��o;
		this.dataOpera��o = getDataOpera��o();
	}

	protected String getTipoOpera��o() {
		return tipoOpera��o;
	}

	protected void setTipoOpera��o(String tipoOpera��o) {
		this.tipoOpera��o = tipoOpera��o;
	}

	protected double getValorOpera��o() {
		return valorOpera��o;
	}

	protected void setValorOpera��o(double valorOpera��o) {
		this.valorOpera��o = valorOpera��o;
	}

	protected Date getDataOpera��o() {
		Calendar cal = new GregorianCalendar();
		return cal.getTime();
	}
	
	protected String getdataOpera��oFormatada (){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return formato.format(this.dataOpera��o);
	}
	
	//M�todo que ir� guardar as opera��es de forma mais organizada para futuramente serem usadas no extrato.
	public abstract String toString(); 
	
	
	
}
