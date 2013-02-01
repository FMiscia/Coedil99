package ElaboraDistinta;

public class RigaLavoro {

	Geometria geometria;
	private boolean capitello;
	private String profiloCapitello;
	private String note;
	private int numero;

	public boolean isCapitello() {
		return this.capitello;
	}

	public void setCapitello(boolean capitello) {
		this.capitello = capitello;
	}

	public String getProfiloCapitello() {
		return this.profiloCapitello;
	}

	public void setProfiloCapitello(String profiloCapitello) {
		this.profiloCapitello = profiloCapitello;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}