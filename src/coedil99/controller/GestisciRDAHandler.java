package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import org.orm.PersistentException;

import GUI.RDACenter;

import coedil99.model.RDA;
import coedil99.model.RDAFactory;
import coedil99.model.RigaRDA;
import coedil99.model.Subject;




public class GestisciRDAHandler extends coedil99.model.Observer{

	private ArrayList<RDA> arrayRDA = null;
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
			this.arrayRDA = new ArrayList<RDA>(Arrays.asList(RDAFactory.listRDAByQuery(null, "ID")));
			this.setSubject(new ArrayList<Subject>(arrayRDA));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addRDA(int pos,RDA rda) {
		this.arrayRDA.add(pos,rda);
		rda.Attach(this);
	}

	public ArrayList<RDA> getArrayRDA(){
		return this.arrayRDA;
	}
	
	public ArrayList<RDA> getArrayRDA(String state) {
		ArrayList<RDA> filteredAdday = null;
		try {
			filteredAdday = new ArrayList<RDA>(Arrays.asList(RDAFactory.listRDAByQuery("State =  '"+state+"' ", "Date desc, ID desc")));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filteredAdday;
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
	
	public void saveAndAddRDA(RDA r){
		try {
			r.save();
			if(!this.arrayRDA.contains(r))
				this.addRDA(0, r);
			r.Notify();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAndRemoveRDA(RDA r){
		try {
			ArrayList<RigaRDA> listarighe = new ArrayList<RigaRDA>( r.righeRDA.getCollection() );
			for (RigaRDA temp : listarighe){
				this.arrayRDA.remove(temp);
				temp.deleteAndDissociate();
			}
			r.delete();
			this.arrayRDA.remove(r);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Subject> getSubject() {
		// TODO Auto-generated method stub
		return new ArrayList<Subject>(this.arrayRDA);
	}

	@Override
	public void setSubject(ArrayList<Subject> s) {
		this.subjects = s;
		
	}

	@Override
	public void Update() {
		RDACenter.getInstance().getClipPanel().updateNotifiche();
		
	}
	

}
