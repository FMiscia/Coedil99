package ElaboraDistinta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Ordine {

	Cliente cliente;
	List<Commessa> commesse;
	private String ordineGestionale;
	private Calendar dataInizio;
	private Calendar dataFine;

	public Ordine(Cliente c, String og, Calendar inizio, Calendar fine){
		this.cliente = c;
		this.ordineGestionale = og;
		this.dataInizio = inizio;
		this.dataFine = fine;
		this.commesse = new ArrayList<Commessa>();
	}
	
	public void addCommessa( Commessa c ){
		this.commesse.add(c);
	}
	

	public String getOrdineGestionale() {
		return this.ordineGestionale;
	}

	public void setOrdineGestionale(String ordineGestionale) {
		this.ordineGestionale = ordineGestionale;
	}

	public Calendar getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Calendar dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Calendar getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Calendar dataFine) {

		this.dataFine = dataFine;
	}

}