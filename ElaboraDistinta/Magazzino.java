package ElaboraDistinta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Magazzino {

	Catalogo catalogo;
	HashMap<Item,Integer> items;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Magazzino(){
		/*esegue lo startup*/
		this.catalogo = new Catalogo();
		List<Item> cItem = new ArrayList<Item>(this.catalogo.items);
		Iterator<Item> i = cItem.iterator();
		while(i.hasNext()){
			items.put(i.next(), 1);
		}
	}
	
	public void addItem(Item item){
		Integer oldValue = items.get(item);
		items.put(item, ++oldValue);
	}

}