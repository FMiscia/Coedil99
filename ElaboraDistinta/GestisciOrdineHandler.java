package ElaboraDistinta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestisciOrdineHandler {

List<Ordine> ordini = null;

/**
 * Costruttore
 */
public GestisciOrdineHandler(){
	this.ordini = new ArrayList<Ordine>();
}

public void addOrdine( Ordine o ){
	this.ordini.add(o);
}



// Cliente c, List<Commessa> lc, String og, Date inizio, Date fine

}