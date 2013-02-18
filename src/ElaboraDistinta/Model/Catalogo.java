package ElaboraDistinta.Model;

import java.util.ArrayList;
import java.util.HashMap;


public class Catalogo {

	HashMap<Item,Float> items;
	
	public Catalogo(){
		
		this.items = new HashMap<Item,Float>();
		
		/*Startup*/
		Item item1 = new Item(new Geometria(23,50,400),"Listelli Abete");
		Item item2 = new Item(new Geometria(23,50,300),"Listelli Scemi");
		Item item3 = new Item(new Geometria(23,50,200),"Pannelli Stupidi");
		Item item4 = new Item(new Geometria(23,50,100),"Pannelli Biricchini");
		
		this.addItem(item1,new Float(4.0));
		this.addItem(item2,new Float(3.0));
		this.addItem(item3,new Float(2.0));
		this.addItem(item4,new Float(1.0));
	}
	
	public void addItem(Item item, Float price){
		items.put(item, price);
	}

}