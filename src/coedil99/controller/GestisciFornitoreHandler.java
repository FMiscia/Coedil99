package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

import coedil99.model.CatalogoFornitore;
import coedil99.model.CatalogoFornitoreFactory;
import coedil99.model.RDAFactory;

public class GestisciFornitoreHandler {

	private ArrayList<CatalogoFornitore> arrayFornitori = null;
	private static GestisciFornitoreHandler instance;
	
	/**
	 * Costruttore
	 */
	private GestisciFornitoreHandler() {
		
		try {
			this.arrayFornitori = new ArrayList<CatalogoFornitore>(Arrays.asList(CatalogoFornitoreFactory.listCatalogoFornitoreByQuery(null, "ID")));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static GestisciFornitoreHandler getInstance() {
		if (GestisciFornitoreHandler.instance == null) {
			GestisciFornitoreHandler.instance = new GestisciFornitoreHandler();
		}

		return GestisciFornitoreHandler.instance;
	}

	public ArrayList<CatalogoFornitore> getArrayFornitori() {
		return arrayFornitori;
	}
	
	public CatalogoFornitore getFornitoreByName(String nome){
		try {
			return CatalogoFornitoreFactory.loadCatalogoFornitoreByQuery(" Name = " + "'" + nome + "'", null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
