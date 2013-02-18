package ElaboraDistinta.Model;


public class Item {

	private History history;
	private Geometria geometria;
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
	
	public void setGeometria(Geometria g){
		this.geometria = g;
	}


}