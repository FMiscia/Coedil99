package coedil99.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import coedil99.model.DocumentoOttimizzazione;
import coedil99.model.Item;
import coedil99.model.Magazzino;



public class GestisciMagazzinoHandler {

	List<Magazzino> magazzino;
	private static GestisciMagazzinoHandler instance = null;
	public static String IN_ARRIVO = "IN_ARRIVO";
	public static String RICHIESTO = "RICHIESTO";
	public static String IN_MAGAZZINO = "IN_MAGAZZINO";
	

	/**
	 * Costruttore
	 */
	private GestisciMagazzinoHandler(){
		this.magazzino = new ArrayList<Magazzino>();
	}
	
	/**
	 * Fornisce un magazzino dal nome
	 * @param name
	 * @return magazzino:Magazzino
	 */
	public Magazzino getMagazzinoByName(String name){
		ListIterator<Magazzino> iteratorMagazzino = this.magazzino.listIterator();
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