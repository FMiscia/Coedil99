package elaboradistinta.model;

import java.util.Date;
import java.util.ArrayList;
import elaboradistinta.model.Commessa;

public class Ordine {
	private int _iD;
	private String _ordineGestionale;
	private Date _dataInizio;
	private Date _dataScadenza;
	private Date _dataFine;
	private Integer _anno;
	private Integer _numeroOrdine;
	private String _oC;
	private static int _counter = 0;
	private ArrayList<Commessa> _commesse = new ArrayList<Commessa>();
	public Cliente _cliente;

	private Boolean isDateNull() {
		throw new UnsupportedOperationException();
	}

	public Ordine(Cliente aC, String aOg, Integer aAnno) {
		throw new UnsupportedOperationException();
	}

	private void checkDate(Commessa aC) {
		throw new UnsupportedOperationException();
	}

	public void addCommesse(Commessa aCommesse) {
		this._commesse.add(aCommesse);
	}

	public void removeCommesse(Commessa aCommesse) {
		this._commesse.remove(aCommesse);
	}

	public Commessa[] toCommesseArray() {
		Commessa[] lCommesse_Temp = new Commessa[this._commesse.size()];
		this._commesse.toArray(lCommesse_Temp);
		return lCommesse_Temp;
	}

	public void setOrdineGestionale(String aOrdineGestionale) {
		this._ordineGestionale = aOrdineGestionale;
	}

	public String getOrdineGestionale() {
		return this._ordineGestionale;
	}

	public void setDataInizio(Date aDataInizio) {
		this._dataInizio = aDataInizio;
	}

	public Date getDataInizio() {
		return this._dataInizio;
	}

	public void setDataScadenza(Date aDataScadenza) {
		this._dataScadenza = aDataScadenza;
	}

	public Date getDataScadenza() {
		return this._dataScadenza;
	}

	public void setDataFine(Date aDataFine) {
		this._dataFine = aDataFine;
	}

	public Date getDataFine() {
		return this._dataFine;
	}

	public Integer getAnno() {
		return this._anno;
	}

	public void setNumeroOrdine(Integer aNumeroOrdine) {
		this._numeroOrdine = aNumeroOrdine;
	}

	public Integer getNumeroOrdine() {
		return this._numeroOrdine;
	}

	public void setOC(String aOC) {
		this._oC = aOC;
	}

	public String getOC() {
		return this._oC;
	}

	public int get_iD() {
		return this._iD;
	}
}