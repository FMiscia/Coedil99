package ElaboraDistinta.Model;

import java.util.ArrayList;

public class DocumentoOttimizzazione {

	private ArrayList<Item> items = new ArrayList<Item>();

	public DocumentoOttimizzazione(ArrayList<Item> l) {
		items = new ArrayList<Item>(l);
	}

	public ArrayList<Item> getItems() {
		return this.items;
	}
	

}