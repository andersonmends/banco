package operações;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class OperaçãoAbstrata {
	private String tipoOperação;
	private double valorOperação;
	private Date dataOperação;
	
	public OperaçãoAbstrata(String tipoOperação, double valorOperação) {
		super();
		this.tipoOperação = tipoOperação;
		this.valorOperação = valorOperação;
		this.dataOperação = getDataOperação();
	}

	protected String getTipoOperação() {
		return tipoOperação;
	}

	protected void setTipoOperação(String tipoOperação) {
		this.tipoOperação = tipoOperação;
	}

	protected double getValorOperação() {
		return valorOperação;
	}

	protected void setValorOperação(double valorOperação) {
		this.valorOperação = valorOperação;
	}

	protected Date getDataOperação() {
		Calendar cal = new GregorianCalendar();
		return cal.getTime();
	}
	
	protected String getdataOperaçãoFormatada (){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return formato.format(this.dataOperação);
	}
	
	//Método que irá guardar as operações de forma mais organizada para futuramente serem usadas no extrato.
	public abstract String toString(); 
	
	
	
}
