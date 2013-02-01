package ElaboraDistinta;

public class Item {
	private String _descrizione;
	public History _history;
	public Geometria _geometria;

	public void setDescrizione(String aDescrizione) {
		this._descrizione = aDescrizione;
	}

	public String getDescrizione() {
		return this._descrizione;
	}
}