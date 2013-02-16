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

	public int getNumOfCommesse(){
		return this.commesse.size();
	}
	/**
	 * 
	 * @param idCommessa
	 * @return
	 */
	public void eliminaDistinta(int idCommessa) {
		Commessa temp = this.getCommessaById(idCommessa);
		temp.eliminaDistinta();
		ElaboraDistintaHandler.getInstance().removeFromList(temp.distinta);
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

	public Commessa getCommessaByIndex(int a) {
		// TODO Auto-generated method stub
		return this.commesse.get(a);
	}

}