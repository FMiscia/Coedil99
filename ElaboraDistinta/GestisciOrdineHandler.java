package ElaboraDistinta;

import java.util.ArrayList;

public class GestisciOrdineHandler {

	ArrayList<Ordine> ordini = null;

	/**
	 * Costruttore
	 */
	public GestisciOrdineHandler() {
		this.ordini = new ArrayList<Ordine>();
	}

	public void addOrdine(Ordine o) {
		this.ordini.add(o);
	}

	// Cliente c, List<Commessa> lc, String og, Date inizio, Date fine

}
