package ElaboraDistinta;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GestisciMagazzinoHandler implements ICommessaListener {

	ElaboraDistintaHandler cdistinta;
	List<Magazzino> magazzino;
	ListIterator<Magazzino> iteratorMagazzino;
	private static GestisciMagazzinoHandler instance = null;
	
	

	private GestisciMagazzinoHandler(){
		this.magazzino = new ArrayList<Magazzino>();
		this.iteratorMagazzino = this.magazzino.listIterator();
	}
	
	public Magazzino getMagazzinoByName(String name){
		while(this.iteratorMagazzino.hasNext())
			if(this.iteratorMagazzino.next().getName() == name)
				return this.iteratorMagazzino.previous();
		return null;
	}
	
	/**
	 * 
	 * @param items
	 * @return 
	 * 
	 * ritorna una map
	 */
	public void responseQuantity(List<Item> items) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ddo
	 * @return 
	 */
	public void update(DocumentoOttimizzazione ddo) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onPropertyEvent(Commessa commessa, String value) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Singleton
	 */
	public static GestisciMagazzinoHandler getInstance(){
		if (GestisciMagazzinoHandler.instance == null)
			GestisciMagazzinoHandler.instance = new GestisciMagazzinoHandler();
		
		return instance;
	}
	
}