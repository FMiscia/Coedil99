package elaboradistinta.model;

import java.util.ArrayList;
import elaboradistinta.model.Item;

public class DocumentoOttimizzazione {
	private int _iD;
	private ArrayList<Item> _items = new ArrayList<Item>();

	public DocumentoOttimizzazione(java.util.ArrayList<Item> aL) {
		throw new UnsupportedOperationException();
	}

	public Item[] toItemsArray() {
		Item[] lItems_Temp = new Item[this._items.size()];
		this._items.toArray(lItems_Temp);
		return lItems_Temp;
	}
}