package ElaboraDistinta;

public class Item {

	History history;
	Geometria geometria;
	private String descrizione;

	
	public Item(float b, float a, float l, String d){
		this.geometria = new Geometria(b,a,l);
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