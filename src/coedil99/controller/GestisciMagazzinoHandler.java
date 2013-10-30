package coedil99.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import coedil99.model.MMagazzino;
import coedil99.persistentModel.DocumentoOttimizzazione;
import coedil99.persistentModel.Item;


public class GestisciMagazzinoHandler {

	List<MMagazzino> magazzino;
	private static GestisciMagazzinoHandler instance = null;
	public static String IN_ARRIVO = "IN_ARRIVO";
	public static String RICHIESTO = "RICHIESTO";
	public static String IN_MAGAZZINO = "IN_MAGAZZINO";
	

	/**
	 * Costruttore
	 */
	private GestisciMagazzinoHandler(){
		this.magazzino = new ArrayList<MMagazzino>();
	}
	
	/**
	 * Fornisce un magazzino dal nome
	 * @param name
	 * @return magazzino:MMagazzino
	 */
	public MMagazzino getMagazzinoByName(String name){
		ListIterator<MMagazzino> iteratorMagazzino = this.magazzino.listIterator();
		while(iteratorMagazzino.hasNext())
			if(iteratorMagazzino.next().getName() == name)
				return iteratorMagazzino.previous();
		return null;
	}
	
	/**
	 * TO DO iterazione Gestisci Magazzino
	 * @param items:List<item>
	 * 
	 * 
	 */
	public void responseQuantity(List<Item> items) {
		throw new UnsupportedOperationException();
	}

	/**
	 * TO DO iterazione Gestisci Magazzino
	 * 
	 * @param ddo:DocumentoOttimizzazione
	 * @return 
	 */
	public void update(DocumentoOttimizzazione ddo) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Singleton
	 * 
	 * @return instance:GestisciMagazzinoHandler
	 */
	public static GestisciMagazzinoHandler getInstance(){
		if (GestisciMagazzinoHandler.instance == null)
			GestisciMagazzinoHandler.instance = new GestisciMagazzinoHandler();
		
		return instance;
	}
	
}