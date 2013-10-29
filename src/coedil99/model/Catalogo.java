package coedil99.model;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;



public class Catalogo implements IModelComponent{

	private ArrayList<Item> items;
	
	public ArrayList<Item> getItems() {
		return this.items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Catalogo() throws PersistentException{
		
		this.items = new ArrayList<Item>(Arrays.asList(ItemFactory.listItemByQuery(null, null)));

	}
	
	public void addItem(Item item){
		items.add(item);
	}

}