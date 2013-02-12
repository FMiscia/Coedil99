package ElaboraDistinta;

public class Item {

	History history;
	Geometria geometria;
	private String descrizione;

	
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


}