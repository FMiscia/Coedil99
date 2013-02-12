package ElaboraDistinta;

import java.util.List;

public class Catalogo {

	List<Item> items;
	
	public Catalogo(){
		/*Startup*/
		Item item1 = new Item(new Geometria(23,48,400),"Listelli Abete");
		Item item2 = new Item(new Geometria(3,35,300),"Pannelli Legno");
		Item item3 = new Item(new Geometria(3,50,100),"Pannelli Legno");
		
		this.addItem(item1);
		this.addItem(item2);
		this.addItem(item3);
	}
	
	public void addItem(Item item){
		items.add(item);
	}

}