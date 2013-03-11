package ElaboraDistinta.Model;

import java.util.ArrayList;

public class DocumentoOttimizzazione {

	private ArrayList<Item> items = new ArrayList<Item>();

	public DocumentoOttimizzazione(ArrayList<Item> l) {
		items = new ArrayList<Item>(l);
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < this.getItems().size(); ++i) {
			s = s + this.getItems().get(i).toString() + "\n";
		}
		return s;

	}

	public ArrayList<Item> getItems() {
		return this.items;
	}

}