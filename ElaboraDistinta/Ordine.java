package ElaboraDistinta;

import java.util.ArrayList;
import ElaboraDistinta.Commessa;

public class Ordine {
	private String _ordineGestionale;
	private Date _dataInizio;
	private Date _dataFine;
	public Cliente _cliente;
	public ArrayList<Commessa> _commessa = new ArrayList<Commessa>();

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

	public void setDataFine(Date aDataFine) {
		this._dataFine = aDataFine;
	}

	public Date getDataFine() {
		return this._dataFine;
	}
}