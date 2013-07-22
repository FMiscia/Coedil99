package elaboradistinta.model;

public class Cantiere {
	private int _iD;
	private String _nome;
	private String _indirizzo;

	public Cantiere(String aNome, String aIndirizzo) {
		throw new UnsupportedOperationException();
	}

	public void setNome(String aNome) {
		this._nome = aNome;
	}

	public String getNome() {
		return this._nome;
	}

	public void setIndirizzo(String aIndirizzo) {
		this._indirizzo = aIndirizzo;
	}

	public String getIndirizzo() {
		return this._indirizzo;
	}
}