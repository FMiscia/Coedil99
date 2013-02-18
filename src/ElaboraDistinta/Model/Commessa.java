package ElaboraDistinta.Model;


import java.util.Calendar;
import java.util.List;

import ElaboraDistinta.ICommessaListener;
import ElaboraDistinta.Controller.GestisciCommessaHandler;

public class Commessa {

	Ordine ordine;
	ListaRintracciabilita ldr;
	GestisciCommessaHandler ccommessa;
	List<ICommessaListener> lcommessa;
	protected Distinta distinta;
	private int id;
	private String codiceInterno;
	private String elementoStrutturale;
	private Calendar scadenzaCommessa; //sviluppo della commessa
	private Calendar emissioneCommessa; //sviluppo della commessa
	private Calendar fineCommessa; //sviluppo della commessa
	private Calendar inizioProduzione; 
	private Calendar scadenzaProduzione;
	private Calendar fineProduzione;
	private Integer ritardoProduzione; //giorni
	private Calendar primaConsegna;
	private Integer ritardoConsegna; //giorni
	private String orario; //consegna: del tipo Mattina o Pomeriggio
	private String descrizione;
	private String responsabile; // dipendente
	private static int counter = 0;

	public Commessa(Ordine o, Distinta d, String es, Calendar s, Calendar e, String orario , String desc, String resp ){
		Commessa.counter = Commessa.counter+1;
		this.ordine = o;
		this.distinta = d;
		this.elementoStrutturale = es;
		this.scadenzaCommessa = s;
		this.emissioneCommessa = e;
		this.orario = orario;
		this.descrizione = desc;
		this.responsabile = resp;
		/*startup*/
		this.id = Commessa.counter;
		this.codiceInterno = Integer.toString(e.get(Calendar.YEAR))+"-"+o.getNumeroOrdine()+"-"+Integer.toString(this.id);

	} 
	
	public Integer getOrdineId() {
		return this.ordine.getNumeroOrdine();
	}
	
	public Ordine getOrdine() {
		return this.ordine;
	}
	
	public String getElementoStrutturale() {
		return this.elementoStrutturale;
	}

	public void setElementoStrutturale(String elementoStrutturale) {
		this.elementoStrutturale = elementoStrutturale;
	}

	public Calendar getScadenza() {
		return this.scadenzaCommessa;
	}

	public void setScadenza(Calendar scadenza) {
		this.scadenzaCommessa = scadenza;
	}

	public String getOrario() {
		return this.orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getResponsabile() {
		return this.responsabile;
	}

	public void setResponsabile(String responsabile) {
		this.responsabile = responsabile;
	}

	/**
	 * 
	 * @param distinta
	 * @return 
	 */
	public void associaDistinta(Distinta distinta) {
		this.distinta = distinta;
	}

	/**
	 * 
	 * @return 
	 */
	public void eliminaDistinta() {
		this.distinta = null;
	}


	public int getId() {
		return id;
	}
	
	public Distinta getDistinta(){
		return this.distinta;
	}
	
	public void setDistinta(Distinta d){
		this.distinta = d;
	}

	public Calendar getScadenzaCommessa() {
		return scadenzaCommessa;
	}

	public void setScadenzaCommessa(Calendar scadenzaCommessa) {
		this.scadenzaCommessa = scadenzaCommessa;
	}

	public Calendar getEmissioneCommessa() {
		return emissioneCommessa;
	}

	public void setEmissioneCommessa(Calendar emissioneCommessa) {
		this.emissioneCommessa = emissioneCommessa;
	}

	public Calendar getFineCommessa() {
		return fineCommessa;
	}

	public void setFineCommessa(Calendar fineCommessa) {
		this.fineCommessa = fineCommessa;
	}

	public Calendar getInizioProduzione() {
		return inizioProduzione;
	}

	public void setInizioProduzione(Calendar inizioProduzione) {
		this.inizioProduzione = inizioProduzione;
	}

	public Calendar getScadenzaProduzione() {
		return scadenzaProduzione;
	}

	public void setScadenzaProduzione(Calendar scadenzaProduzione) {
		this.scadenzaProduzione = scadenzaProduzione;
	}

	public Calendar getFineProduzione() {
		return fineProduzione;
	}

	public void setFineProduzione(Calendar fineProduzione) {
		this.fineProduzione = fineProduzione;
	}

	public Calendar getPrimaConsegna() {
		return primaConsegna;
	}

	public void setPrimaConsegna(Calendar primaConsegna) {
		this.primaConsegna = primaConsegna;
	}

	public Integer getRitardoConsegna() {
		return ritardoConsegna;
	}

	public void setRitardoConsegna(Integer ritardoConsegna) {
		this.ritardoConsegna = ritardoConsegna;
	}

	public Integer getRitardoProduzione() {
		return ritardoProduzione;
	}

	public void setRitardoProduzione(Integer ritardoProduzione) {
		this.ritardoProduzione = ritardoProduzione;
	}

	public String getCodiceInterno() {
		return codiceInterno;
	}

	public void setCodiceInterno(String codiceInterno) {
		this.codiceInterno = codiceInterno;
	}


}