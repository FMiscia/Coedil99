package ElaboraDistinta;

import java.util.Calendar;

public class StartUp {

	Distinta dist = new Distinta();
	public Ordine o;
	
	public StartUp(){
		Calendar inizio = Calendar.getInstance();
		Calendar fine = Calendar.getInstance();
		fine.add(Calendar.DAY_OF_MONTH, 1);
		
		o = new Ordine( null, "pippo", inizio , fine );
		
		Commessa c = new Commessa( o , dist , "tetto" , Calendar.getInstance() , Calendar.getInstance() , "mattina" , 
				"descrizione..." , "Christian" , 0);
		o.addCommessa(c);
		Item item1 = new Item(23,48,400,"Listelli Abete");
		Item item2 = new Item(3,35,300,"Pannelli Legno");
		Item item3 = new Item(3,50,100,"Pannelli Legno");
	}
	
}
