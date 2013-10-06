package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.orm.PersistentException;

import coedil99.model.RDA;
import coedil99.model.RDAFactory;




public class GestisciRDAHandler {

	private ArrayList<RDA> arrayRDA = null;
	private static GestisciRDAHandler instance;

	/**
	 * Costruttore
	 */
	private GestisciRDAHandler() {
		try {
			this.arrayRDA = new ArrayList<RDA>(Arrays.asList(RDAFactory.listRDAByQuery(null, "ID")));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRDA(RDA rda) {
		this.arrayRDA.add(rda);
	}

	public ArrayList<RDA> getArrayRDA(){
		return this.arrayRDA;
	}
	
	public RDA getRDAById(int id){
		try {
			return RDAFactory.getRDAByORMID(id);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static GestisciRDAHandler getInstance() {
		if (GestisciRDAHandler.instance == null) {
			GestisciRDAHandler.instance = new GestisciRDAHandler();
		}

		return GestisciRDAHandler.instance;
	}

	public int getNumOfRDA() {
		// TODO Auto-generated method stub
		return this.arrayRDA.size();
	}

}
