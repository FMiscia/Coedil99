package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import coedil99.model.Ordine;
import coedil99.model.OrdineFactory;




public class GestisciOrdineHandler {

	private int id;
	private ArrayList<Ordine> ordini = null;
	private static GestisciOrdineHandler instance;

	/**
	 * Costruttore
	 */
	private GestisciOrdineHandler() {
		this.ordini = new ArrayList<Ordine>(Arrays.asList(OrdineFactory.listOrdineByQuery(null, "ID")));
	}

	public void addOrdine(Ordine o) {
		this.ordini.add(o);
	}

	public ArrayList<Ordine> getOrdini(){
		return this.ordini;
	}
	
	public Ordine getOrdineById(int id){
		return OrdineFactory.getOrdineByORMID(id);
	}
	
	public static GestisciOrdineHandler getInstance() {
		if (GestisciOrdineHandler.instance == null) {
			GestisciOrdineHandler.instance = new GestisciOrdineHandler();
		}

		return GestisciOrdineHandler.instance;
	}

}
