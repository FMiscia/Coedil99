package ElaboraDistinta.Model;

public class RigaLavoro {

	private int id;
	private Geometria geometria;
	private boolean capitello;
	private String profiloCapitello;
	private String note;
	private int numero;

	public RigaLavoro(int id, Geometria g, boolean c, String pc, String note, int n) {
		this.id = id;
		this.geometria = g;
		this.capitello = c;
		this.profiloCapitello = pc;
		this.note = note;
		this.numero = n;

	}


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

	public int getId() {
		return id;
	}
	
	public Geometria getGeometria(){
		return this.geometria;
	}
	
	public void setGeometria(Geometria g){
		this.geometria = g;
	}

	/*
	 * public void setId(int id) { this.id = id; }
	 */

}