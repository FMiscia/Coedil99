package ElaboraDistinta.Model;

import java.util.ArrayList;



public class Catalogo {

	private ArrayList<Item> items;
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Catalogo(){
		
		this.items = new ArrayList<Item>();

		/*Startup*/
		Item item1 = new Item(new Geometria(23,50,400),"Listelli Abete");
		Item item2 = new Item(new Geometria(23,50,300),"Listelli Scemi");
		Item item3 = new Item(new Geometria(23,50,200),"Pannelli Stupidi");
		Item item4 = new Item(new Geometria(23,50,100),"Pannelli Biricchini");
		
		this.addItem(item1);
		this.addItem(item2);
		this.addItem(item3);
		this.addItem(item4);
	}
	
	public void addItem(Item item){
		items.add(item);
	}

}