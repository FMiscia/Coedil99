package elaboradistinta.controller;

import java.util.ArrayList;
import java.util.Arrays;

import elaboradistinta.model.Ordine;


public class GestisciOrdineHandler {

	private int id;
	private ArrayList<Ordine> ordini = null;
	private static GestisciOrdineHandler instance;

	/**
	 * Costruttore
	 */
	private GestisciOrdineHandler() {
		this.ordini = new ArrayList<Ordine>();
	}

	public void addOrdine(Ordine o) {
		this.ordini.add(o);
	}

	public ArrayList<Ordine> getOrdini(){
		return this.ordini;
	}
	
	public Ordine getOrdineById(int id){
		for(Ordine o: this.ordini){
			if(o.get_iD()==id)
				return o;
		}
		return null;
	}
	
	public static GestisciOrdineHandler getInstance() {
		if (GestisciOrdineHandler.instance == null) {
			GestisciOrdineHandler.instance = new GestisciOrdineHandler();
		}

		return GestisciOrdineHandler.instance;
	}

}
