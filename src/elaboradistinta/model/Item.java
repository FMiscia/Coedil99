package elaboradistinta.model;

public class Item {
	private int _iD;
	
	private String _descrizione;
	private Float _prezzo;
	private History _history;
	private Geometria _geometria;

	public Item(Geometria aG, String aD) {
		throw new UnsupportedOperationException();
	}

	public void setHistory(History aHistory) {
		this._history = aHistory;
	}

	public History getHistory() {
		return this._history;
	}

	public void setGeometria(Geometria aGeometria) {
		this._geometria = aGeometria;
	}

	public Geometria getGeometria() {
		return this._geometria;
	}

	public void setDescrizione(String aDescrizione) {
		this._descrizione = aDescrizione;
	}

	public String getDescrizione() {
		return this._descrizione;
	}

	public void setPrezzo(Float aPrezzo) {
		this._prezzo = aPrezzo;
	}

	public Float getPrezzo() {
		return this._prezzo;
	}
}