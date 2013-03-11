package ElaboraDistinta.Model;


public class Item {

	private History history;
	private Geometria geometria;
	private String descrizione;
	private Float prezzo;
	

	public Item(Geometria g, String d){
		this.geometria = g;
		this.descrizione = d;
	}
	
	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Geometria getGeometria(){
		return this.geometria;
	}
	
	public void setGeometria(Geometria g){
		this.geometria = g;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	@Override
	public String toString() {
		String i = "";
		i = i + "Descrizione: " + this.getDescrizione() + " Prezzo: "
				+ this.getPrezzo() + " Altezza: "
				+ this.getGeometria().getAltezza() + " Base: "
				+ this.getGeometria().getBase() + " Lunghezza: "
				+ this.getGeometria().getLunghezza();
		return i;
	}




}