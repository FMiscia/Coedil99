package ElaboraDistinta.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Magazzino {

	Catalogo catalogo;
	private HashMap<Item,Integer> items;
	private String name;

	public Magazzino(){
		/*esegue lo startup*/
		this.items = new HashMap<Item,Integer>();
		this.catalogo = new Catalogo();
		ArrayList<Item> cItem = new ArrayList<Item>(this.catalogo.getItems());
		Iterator<Item> i = cItem.iterator();
		while(i.hasNext()){
			this.items.put(i.next(), 1);
		}
	}
	
	public HashMap<Item,Integer> getItems(){
		return this.items;
	}
	
	public Catalogo getCatalogo(){
		return this.catalogo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}