package ElaboraDistinta;

public class RigaLavoro {
	private boolean _capitello;
	private String _profiloCapitello;
	private String _note;
	private int _numero;
	public Geometria _geometria;

	public void setCapitello(boolean aCapitello) {
		this._capitello = aCapitello;
	}

	public boolean isCapitello() {
		return this._capitello;
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