package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;
import org.orm.PersistentException;

import GUI.RDACenter;

import coedil99.model.MRDA;
import coedil99.model.Subject;
import coedil99.persistentModel.RDA;
import coedil99.persistentModel.RDAFactory;
import coedil99.persistentModel.RigaRDA;

public class GestisciRDAHandler extends coedil99.model.Observer {

	private ArrayList<MRDA> arrayMRDA = null;
	private static GestisciRDAHandler instance;

	public static String CONGELATA = "CONGELATA";
	public static String RIFIUTATA = "RIFIUTATA";
	public static String ATTESA_CONFERMA = "ATTESA_CONFERMA";
	public static String CONFERMATA = "CONFERMATA";

	/**
	 * Costruttore
	 */
	private GestisciRDAHandler() {

		try {
			this.arrayMRDA = this.changeToMRDA(new ArrayList<RDA>(Arrays.asList(RDAFactory
					.listRDAByQuery(null, "ID"))));
			this.setSubject(new ArrayList<Subject>(arrayMRDA));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private ArrayList<MRDA> changeToMRDA(ArrayList<RDA> aRDA) {
		ArrayList<MRDA> aMRDA = new ArrayList<MRDA>();
		for (RDA rda : aRDA) {
			MRDA mrda = new MRDA(rda.getID());
			aMRDA.add(mrda);
		}
		return aMRDA;
	}

	/**
	 * Aggiunge un MRDA alla lista MRDA nella posizione richiesta
	 * 
	 * @param pos
	 *            :int
	 * @param mrda
	 *            :MRDA
	 */
	public void addMRDA(int pos, MRDA mrda) {
		this.arrayMRDA.add(pos, mrda);
		mrda.Attach(this);
	}

	/**
	 * Fornisce tutte le MRDA
	 * 
	 * @return arrayMRDA:ArrayList<MRDA>
	 */
	public ArrayList<MRDA> getArrayMRDA() {
		return this.arrayMRDA;
	}

	/**
	 * Fornisce le MRDA in base allo stato
	 * 
	 * @param state
	 *            :String
	 * @return filteredArrayMRDA:ArrayList<MRDA>
	 */
	public ArrayList<MRDA> getArrayMRDA(String state) {
		ArrayList<MRDA> filteredArrayMRDA = null;
		ArrayList<RDA> filteredArrayRDA = null;
		try {
			filteredArrayRDA = new ArrayList<RDA>(Arrays.asList(RDAFactory
					.listRDAByQuery("State =  '" + state + "' ",
							"Date desc, ID desc")));
			filteredArrayMRDA = this.changeToMRDA(filteredArrayRDA);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filteredArrayMRDA;
	}

	/**
	 * Fornisce la MRDA da un id
	 * 
	 * @param id
	 *            :int
	 * @return mrda:MRDA
	 */
	public MRDA getMRDAById(int id) {
		try {
			return new MRDA(RDAFactory.getRDAByORMID(id).getID());
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Singleton
	 * 
	 * @return instance:GestisciRDAHandler
	 */
	public static GestisciRDAHandler getInstance() {
		if (GestisciRDAHandler.instance == null) {
			GestisciRDAHandler.instance = new GestisciRDAHandler();
		}

		return GestisciRDAHandler.instance;
	}

	/**
	 * Fornisce il numero totale di RDA
	 * 
	 * @return size:int
	 */
	public int getNumOfMRDA() {
		// TODO Auto-generated method stub
		return this.arrayMRDA.size();
	}

	/**
	 * Salva un RDA nel DB e lo aggiunge alla lista delle RDA in ram
	 * 
	 * @param r
	 *            :RDA
	 * 
	 */
	public void saveAndAddRDA(MRDA r) {

		r.save();
		if (!this.arrayMRDA.contains(r))
			this.addMRDA(0, r);
		r.Notify();

	}

	/**
	 * Elimina un RDA nel DB e lo rimuove dalla lista delle RDA in ram
	 * 
	 * @param r
	 *            :RDA
	 * 
	 */
	public void deleteAndRemoveMRDA(MRDA r) {
		try {
			@SuppressWarnings("unchecked")
			ArrayList<RigaRDA> listarighe = new ArrayList<RigaRDA>(
					r.getPersistentModel().righeRDA.getCollection());
			for (RigaRDA temp : listarighe) {
				this.arrayMRDA.remove(temp);
				temp.deleteAndDissociate();
			}
			r.delete();
			this.arrayMRDA.remove(r);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * metodo Observer
	 */
	@Override
	public ArrayList<Subject> getSubject() {
		// TODO Auto-generated method stub
		return new ArrayList<Subject>(this.arrayMRDA);
	}

	/**
	 * metodo Observer
	 */
	@Override
	public void setSubject(ArrayList<Subject> s) {
		this.subjects = s;

	}

	/**
	 * Aggiorna il ClipPanel per le notifiche delle RDA
	 */
	@Override
	public void Update() {
		RDACenter.getInstance().getClipPanel().updateNotifiche();

	}

}
