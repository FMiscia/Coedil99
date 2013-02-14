package ElaboraDistinta;

import java.util.ArrayList;
import java.util.ListIterator;

public class GestisciCommessaHandler {

	private int id;
	ArrayList<Commessa> commesse;
	private static GestisciCommessaHandler instance;

	private GestisciCommessaHandler() {
		this.commesse = new ArrayList<Commessa>();
	}

	public void add(Commessa commessa) {
		this.commesse.add(commessa);
	}

	/**
	 * 
	 * @param distinta
	 * @return
	 */
	public void associaDistinta(Distinta distinta, int idCommessa) {
		ListIterator<Commessa> it = this.commesse.listIterator();
		while (it.hasNext()) {
			if (it.next().getId() == idCommessa)
				it.previous().distinta = distinta;
		}
	}

	/**
	 * 
	 * @param idCommessa
	 * @return
	 */
	public void eliminaDistinta(int idCommessa) {
		ListIterator<Commessa> it = this.commesse.listIterator();
		while (it.hasNext()) {
			if (it.next().getId() == idCommessa)
				ElaboraDistintaHandler.getInstance().removeFromList(
						it.previous().distinta);
			it.previous().distinta = null;
		}

	}

	/**
	 * 
	 * @param id
	 * @return Commessa
	 */
	public Commessa getCommessaById(int id) {
		ListIterator<Commessa> it = this.commesse.listIterator();
		while (it.hasNext()) {
			if (it.next().getId() == id)
				return it.previous();
		}

		return null;

	}

	public int getId() {
		return id;
	}

	public static GestisciCommessaHandler getInstance() {
		if (GestisciCommessaHandler.instance == null) {
			GestisciCommessaHandler.instance = new GestisciCommessaHandler();
		}

		return GestisciCommessaHandler.instance;
	}

}