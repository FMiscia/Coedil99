package elaboradistinta.model;

public class RigaLavoro {
	private int _iD;
	private boolean _capitello;
	private String _profiloCapitello;
	private String _note;
	private int _numero;
	private Geometria _geometria;

	public RigaLavoro(int aId, Geometria aG, boolean aC, String aPc, String aNote, int aN) {
		throw new UnsupportedOperationException();
	}

	public boolean getCapitello() {
		return this._capitello;
	}

	public void setGeometria(Geometria aGeometria) {
		this._geometria = aGeometria;
	}

	public Geometria getGeometria() {
		return this._geometria;
	}

	public int getID() {
		return this._iD;
	}

	public void setCapitello(boolean aCapitello) {
		this._capitello = aCapitello;
	}

	public void setProfiloCapitello(String aProfiloCapitello) {
		this._profiloCapitello = aProfiloCapitello;
	}

	public String getProfiloCapitello() {
		return this._profiloCapitello;
	}

	public void setNote(String aNote) {
		this._note = aNote;
	}

	public String getNote() {
		return this._note;
	}

	public void setNumero(int aNumero) {
		this._numero = aNumero;
	}

	public int getNumero() {
		return this._numero;
	}
}