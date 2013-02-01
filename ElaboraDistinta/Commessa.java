package ElaboraDistinta;

public class Commessa {

	Ordine ordine;
	ListaRintracciabilita ldr;
	GestisciCommessaHandler ccommessa;
	ICommessaListener[] lcommessa;
	Distinta distinta;
	private String elementoStrutturale;
	private Date scadenza;
	private Date emissione;
	private String orario;
	private String descrizione;
	private String responsabile;
	private int ritardo;

	public String getElementoStrutturale() {
		return this.elementoStrutturale;
	}

	public void setElementoStrutturale(String elementoStrutturale) {
		this.elementoStrutturale = elementoStrutturale;
	}

	public Date getScadenza() {
		return this.scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public Date getEmissione() {
		return this.emissione;
	}

	public void setEmissione(Date emissione) {
		this.emissione = emissione;
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

	public int getRitardo() {
		return this.ritardo;
	}

	public void setRitardo(int ritardo) {
		this.ritardo = ritardo;
	}

	/**
	 * 
	 * @param distinta
	 * @return 
	 */
	public void associaDistinta(Distinta distinta) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	public void eliminaDistinta() {
		throw new UnsupportedOperationException();
	}

}