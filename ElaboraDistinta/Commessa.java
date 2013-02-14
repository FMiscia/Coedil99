package ElaboraDistinta;


import java.util.Calendar;
import java.util.List;

public class Commessa {

	Ordine ordine;
	ListaRintracciabilita ldr;
	GestisciCommessaHandler ccommessa;
	List<ICommessaListener> lcommessa;
	protected Distinta distinta;
	private int id;
	private String elementoStrutturale;
	private Calendar scadenza;
	private Calendar emissione;
	private String orario;
	private String descrizione;
	private String responsabile; // dipendente
	private int ritardo;

	public Commessa(Ordine o, Distinta d, String es, Calendar s, Calendar e, String orario , String desc, String resp, int rit ){
		this.ordine = o;
		this.distinta = d;
		this.elementoStrutturale = es;
		this.scadenza = s;
		this.emissione = e;
		this.orario = orario;
		this.descrizione = desc;
		this.responsabile = resp;
		this.ritardo = rit;
		/*startup*/
		this.id = 1;
	} 
	

	public String getElementoStrutturale() {
		return this.elementoStrutturale;
	}

	public void setElementoStrutturale(String elementoStrutturale) {
		this.elementoStrutturale = elementoStrutturale;
	}

	public Calendar getScadenza() {
		return this.scadenza;
	}

	public void setScadenza(Calendar scadenza) {
		this.scadenza = scadenza;
	}

	public Calendar getEmissione() {
		return this.emissione;
	}

	public void setEmissione(Calendar emissione) {

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


}