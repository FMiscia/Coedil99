package ElaboraDistinta;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Ordine {

	Cliente cliente;
	List<Commessa> commesse;
	private String ordineGestionale;
	private Calendar dataInizio;
	private Calendar dataScadenza;
	private Calendar dataFine;
	private Integer anno;
	private Integer numeroOrdine;
	private String OC;
	private static int counter = 0;

	
	private Boolean isDateNull(){
		return (this.dataInizio == null); 
	}
	
	public Ordine(Cliente c, String og, Integer anno){
		Ordine.counter = Ordine.counter+ 1;
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
	
	
	public void addCommessa( Commessa c ){
		this.commesse.add(c);
		if(this.isDateNull()){
			this.dataInizio = c.getEmissioneCommessa();
			this.dataScadenza = c.getScadenzaCommessa();
		}else
			this.checkDate(c);
	}
	

	private void checkDate(Commessa c) {
		if(c.getEmissioneCommessa().compareTo(this.getDataInizio())<0){
			this.dataInizio = c.getEmissioneCommessa();
		}
		if(c.getScadenzaCommessa().compareTo(this.getDataScadenza())>0){
			this.dataScadenza = c.getFineCommessa();
		}
		
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
	

}