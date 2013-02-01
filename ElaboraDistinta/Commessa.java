package ElaboraDistinta;

import java.util.ArrayList;
import ElaboraDistinta.ICommessaListener;

public class Commessa {
	private String _elementoStrutturale;
	private Date _scadenza;
	private Date _emissione;
	private String _orario;
	private String _descrizione;
	private String _responsabile;
	private int _ritardo;
	public Ordine _ordine;
	public ListaRintracciabilita _ldr;
	public GestisciCommessaHandler _ccommessa;
	public ArrayList<ICommessaListener> _lcommessa = new ArrayList<ICommessaListener>();
	public Distinta _distinta;

	public void associaDistinta(Distinta aDistinta) {
		throw new UnsupportedOperationException();
	}

	public void eliminaDistinta() {
		throw new UnsupportedOperationException();
	}

	public void setElementoStrutturale(String aElementoStrutturale) {
		this._elementoStrutturale = aElementoStrutturale;
	}

	public String getElementoStrutturale() {
		return this._elementoStrutturale;
	}

	public void setScadenza(Date aScadenza) {
		this._scadenza = aScadenza;
	}

	public Date getScadenza() {
		return this._scadenza;
	}

	public void setEmissione(Date aEmissione) {
		this._emissione = aEmissione;
	}

	public Date getEmissione() {
		return this._emissione;
	}

	public void setOrario(String aOrario) {
		this._orario = aOrario;
	}

	public String getOrario() {
		return this._orario;
	}

	public void setDescrizione(String aDescrizione) {
		this._descrizione = aDescrizione;
	}

	public String getDescrizione() {
		return this._descrizione;
	}

	public void setResponsabile(String aResponsabile) {
		this._responsabile = aResponsabile;
	}

	public String getResponsabile() {
		return this._responsabile;
	}

	public void setRitardo(int aRitardo) {
		this._ritardo = aRitardo;
	}

	public int getRitardo() {
		return this._ritardo;
	}
}