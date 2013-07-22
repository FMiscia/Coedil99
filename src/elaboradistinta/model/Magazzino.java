package elaboradistinta.model;

import java.util.HashMap;

public class Magazzino {
	
	private java.util.HashMap<Item, Integer> _items;
	private String _name;
	Catalogo _catalogo;

	public Magazzino() {
		throw new UnsupportedOperationException();
	}

	public java.util.HashMap<Item, Integer> getItems() {
		return this._items;
	}

	public void setName(String aName) {
		this._name = aName;
	}

	public String getName() {
		return this._name;
	}

	public Catalogo getCatalogo() {
		return this._catalogo;
	}
}