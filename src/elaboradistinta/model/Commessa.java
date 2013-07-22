package elaboradistinta.model;

import java.util.Date;
import java.util.Calendar;

public class Commessa {
	private String _codiceInterno;
	private String _elementoStrutturale;
	private Date _scadenzaCommessa;
	/**
	 * sviluppo della commessa
	 */
	private Date _emissioneCommessa;
	/**
	 * sviluppo della commessa
	 */
	private Date _fineCommessa;
	/**
	 * sviluppo della commessa
	 */
	private Date _inizioProduzione;
	private Date _scadenzaProduzione;
	private Date _fineProduzione;
	private Integer _ritardoProduzione;
	/**
	 * giorni
	 */
	private Date _primaConsegna;
	private Integer _ritardoConsegna;
	/**
	 * giorni
	 */
	private String _orario;
	/**
	 * consegna: del tipo Mattina o Pomeriggio
	 */
	private String _descrizione;
	private String _responsabile;
	/**
	 * dipendente
	 */
	private static int _counter = 0;
	private int _iD;
	private Ordine _ordine;
	private ListaRintracciabilita _ldr;
	private Distinta _distinta;

	public Integer getOrdineId() {
		throw new UnsupportedOperationException();
	}

	public Calendar getScadenza() {
		throw new UnsupportedOperationException();
	}

	public void setScadenza(Calendar aScadenza) {
		throw new UnsupportedOperationException();
	}

	public Ordine getOrdine() {
		return this._ordine;
	}

	public void setDistinta(Distinta aDistinta) {
		this._distinta = aDistinta;
	}

	public Distinta getDistinta() {
		return this._distinta;
	}

	public void setCodiceInterno(String aCodiceInterno) {
		this._codiceInterno = aCodiceInterno;
	}

	public String getCodiceInterno() {
		return this._codiceInterno;
	}

	public void setElementoStrutturale(String aElementoStrutturale) {
		this._elementoStrutturale = aElementoStrutturale;
	}

	public String getElementoStrutturale() {
		return this._elementoStrutturale;
	}

	public void setScadenzaCommessa(Date aScadenzaCommessa) {
		this._scadenzaCommessa = aScadenzaCommessa;
	}

	public Date getScadenzaCommessa() {
		return this._scadenzaCommessa;
	}

	public void setEmissioneCommessa(Date aEmissioneCommessa) {
		this._emissioneCommessa = aEmissioneCommessa;
	}

	public Date getEmissioneCommessa() {
		return this._emissioneCommessa;
	}

	public void setFineCommessa(Date aFineCommessa) {
		this._fineCommessa = aFineCommessa;
	}

	public Date getFineCommessa() {
		return this._fineCommessa;
	}

	public void setInizioProduzione(Date aInizioProduzione) {
		this._inizioProduzione = aInizioProduzione;
	}

	public Date getInizioProduzione() {
		return this._inizioProduzione;
	}

	public void setScadenzaProduzione(Date aScadenzaProduzione) {
		this._scadenzaProduzione = aScadenzaProduzione;
	}

	public Date getScadenzaProduzione() {
		return this._scadenzaProduzione;
	}

	public void setFineProduzione(Date aFineProduzione) {
		this._fineProduzione = aFineProduzione;
	}

	public Date getFineProduzione() {
		return this._fineProduzione;
	}

	public void setRitardoProduzione(Integer aRitardoProduzione) {
		this._ritardoProduzione = aRitardoProduzione;
	}

	public Integer getRitardoProduzione() {
		return this._ritardoProduzione;
	}

	public void setPrimaConsegna(Date aPrimaConsegna) {
		this._primaConsegna = aPrimaConsegna;
	}

	public Date getPrimaConsegna() {
		return this._primaConsegna;
	}

	public void setRitardoConsegna(Integer aRitardoConsegna) {
		this._ritardoConsegna = aRitardoConsegna;
	}

	public Integer getRitardoConsegna() {
		return this._ritardoConsegna;
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

	public int getID() {
		return this._iD;
	}
}