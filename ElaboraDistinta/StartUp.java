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
	}
	
}
