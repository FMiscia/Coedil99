package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

import coedil99.model.MOrdine;
import coedil99.persistentmodel.Ordine;
import coedil99.persistentmodel.OrdineFactory;




public class GestisciOrdineHandler {

	private ArrayList<MOrdine> ordini = null;
	private static GestisciOrdineHandler instance;

	/**
	 * Costruttore
	 */
	private GestisciOrdineHandler() {
		try {
			this.ordini = this.changeToMOrdini(new ArrayList<Ordine>(Arrays.asList(OrdineFactory.listOrdineByQuery(null, "ID"))));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Elabora e ritorna una lista di MOrdine partendo da una lista di Ordine
	 * @param aOrdini
	 * @return ArrayList<MOrdine>
	 */
	private ArrayList<MOrdine> changeToMOrdini(ArrayList<Ordine> aOrdini) {

			ArrayList<MOrdine> aMOrdine = new ArrayList<MOrdine>();
			for (Ordine o : aOrdini) {
				MOrdine mOrdine = new MOrdine(o.getID());
				aMOrdine.add(mOrdine);
			}
			return aMOrdine;

	}

	/**
	 * Aggiunge un ordine al programma lavori
	 * 
	 * @param o:MOrdine
	 */
	public void addMOrdine(MOrdine o) {
		this.ordini.add(o);
	}

	/**
	 * Fornisce tutti gli ordini
	 * 
	 * @return ordini:ArrayList<MOrdine>
	 */
	public ArrayList<MOrdine> getMOrdini(){
		return this.ordini;
	}
	
	/**
	 * Fornisce un ordine da un id
	 * 
	 * @param id:int
	 * @return ordine:Ordine
	 */
	public MOrdine getMOrdineById(int id){

			return new MOrdine(id);
	}
	
	public int getNextOrdineContratto(){
		return this.ordini.size()+1;
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
