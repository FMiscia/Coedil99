package elaboradistinta.model;

import java.util.ArrayList;
import elaboradistinta.model.Item;

public class Catalogo {
	private ArrayList<Item> _items = new ArrayList<Item>();

	public void addItem(Item aItem) {
		throw new UnsupportedOperationException();
	}

	public Catalogo() {
		throw new UnsupportedOperationException();
	}

	public void addItems(Item aItems) {
		this._items.add(aItems);
	}

	public void removeItems(Item aItems) {
		this._items.remove(aItems);
	}

	public Item[] toItemsArray() {
		Item[] lItems_Temp = new Item[this._items.size()];
		this._items.toArray(lItems_Temp);
		return lItems_Temp;
	}
}