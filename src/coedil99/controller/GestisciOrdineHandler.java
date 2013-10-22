package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

import coedil99.model.Ordine;
import coedil99.model.OrdineFactory;




public class GestisciOrdineHandler {

	private ArrayList<Ordine> ordini = null;
	private static GestisciOrdineHandler instance;

	/**
	 * Costruttore
	 */
	private GestisciOrdineHandler() {
		try {
			this.ordini = new ArrayList<Ordine>(Arrays.asList(OrdineFactory.listOrdineByQuery(null, "ID")));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Aggiunge un ordine al programma lavori
	 * 
	 * @param o:Ordine
	 */
	public void addOrdine(Ordine o) {
		this.ordini.add(o);
	}

	/**
	 * Fornisce tutti gli ordini
	 * 
	 * @return ordini:ArrayList<Ordine>
	 */
	public ArrayList<Ordine> getOrdini(){
		return this.ordini;
	}
	
	/**
	 * Fornisce un ordine da un id
	 * 
	 * @param id:int
	 * @return ordine:Ordine
	 */
	public Ordine getOrdineById(int id){
		try {
			return OrdineFactory.getOrdineByORMID(id);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Singleton
	 * 
	 * @return instance:GestisciOrdineHandler
	 */
	public static GestisciOrdineHandler getInstance() {
		if (GestisciOrdineHandler.instance == null) {
			GestisciOrdineHandler.instance = new GestisciOrdineHandler();
		}

		return GestisciOrdineHandler.instance;
	}

}
