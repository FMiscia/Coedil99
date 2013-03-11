package ElaboraDistinta.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Ordine {

	private Cliente cliente;
	private List<Commessa> commesse;
	
	private String ordineGestionale;
	private Calendar dataInizio;
	private Calendar dataScadenza;
	private Calendar dataFine;
	private Integer anno;
	private Integer numeroOrdine;
	private String OC;
	private static int counter = 0;

	public Ordine(Cliente c, String og, Integer anno){
		Ordine.counter++;
		this.setNumeroOrdine(Ordine.counter);
		this.anno = new Integer(anno);
		this.cliente = c;
		this.ordineGestionale = og;
		this.numeroOrdine = Ordine.counter;
		this.commesse = new ArrayList<Commessa>();
	}
	
	public Integer getAnno(){
		return this.anno;
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
	
	public Cliente getCliente(){
		return this.cliente;
	}

	public Integer getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(Integer numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public String getOC() {
		return OC;
	}

	public void setOC(String oC) {
		OC = oC;
	}

	public Calendar getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Calendar dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	public List<Commessa> getCommesse() {
		return commesse;
	}

	public void setCommesse(List<Commessa> commesse) {
		this.commesse = commesse;
	}


}