package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import org.orm.PersistentException;

import coedil99.model.Commessa;
import coedil99.model.CommessaFactory;
import coedil99.model.Distinta;
import coedil99.model.RigaLavoro;




public class GestisciCommessaHandler {

	private int id;
	private ArrayList<Commessa> commesse;
	private static GestisciCommessaHandler instance;

	/**
	 * Costruttore
	 */
	private GestisciCommessaHandler() {
		try {
			this.commesse = new ArrayList<Commessa>(Arrays.asList(CommessaFactory.listCommessaByQuery(null, "ID")));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	/**
	 * 
	 * @param commessa:Commessa
	 * 
	 */
	public void add(Commessa commessa) {
		this.commesse.add(commessa);
	}
	

	/**
	 * 
	 * @param idCommessa:int
	 */
	public void eliminaDistinta(int idCommessa) {
		this.getCommessaById(idCommessa).setDistinta(null);
	}

	/**
	 * 
	 * @param id:int
	 * @return commessa:Commessa
	 */
	public Commessa getCommessaById(int id) {
		ListIterator<Commessa> it = this.commesse.listIterator();
		while (it.hasNext()) {
			if (it.next().getID() == id)
				return it.previous();
		}

		return null;

	}
	

	/**
	 * Commessa id
	 * @return id:int
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * Associa la distinta alla Commessa
	 * @param d:Distina
	 * @param idCommessa:int
	 */
	public void associaDistinta(Distinta d, int idCommessa){
		if(this.getCommessaById(idCommessa) != null)
			this.getCommessaById(idCommessa).setDistinta(d);
	}
	
	/**
	 * Fornisce le commesse
	 * @return commesse:ArrayList<Commessa>
	 */
	public ArrayList<Commessa> getCommesse(){
		return this.commesse;
	}
	
	/**
	 * Fornisce il numero di commesse esistenti
	 * @return numeroCommesse:int
	 */
	public int getNumOfCommesse(){
		return this.commesse.size();
	}
	
	/**
	 * Fornisce la commessa in base al codice interno
	 * @param q:String
	 * @return commessa:Commessa
	 */
	public Commessa getCommessaByCodiceInterno(String q){
		Commessa c = null;
		for(int i=0; i<this.commesse.size(); ++i){
			if(this.commesse.get(i).getCodiceInterno() == q)
				c=this.commesse.get(i);
		}
		return c;
	}

	/**
	 * 
	 * @param a:int
	 * @return c:Commessa
	 */
	public Commessa getCommessaByIndex(int a) {
		Commessa c = null;
		for(int i=0; i<this.commesse.size(); ++i){
			if(this.commesse.get(i).getID() == a)
				c = this.commesse.get(i);
		}
		return c;
	}
	
	/**
	 * Comunica se la commesa possiede una distinta
	 * @param codiceinterno:String
	 * @return boolean:Boolean
	 */
	public Boolean hasDistinta(String ci){
		ListIterator<Commessa> it = this.commesse.listIterator();
		Commessa temp;
		while(it.hasNext()){
			temp = it.next();
			if(temp.getCodiceInterno().equals(ci) && temp.getDistinta() != null)
				return true;
		}
		return false;
	}
	
	/**
	 * Modifica la rigaLavoro di una distinta associata alla commessa
	 * @param id_commessa:int
	 * @param rg:RigaLavoro
	 */
	public void modificaRigaLavoro(int id_commessa, RigaLavoro rg){
		this.getCommessaById(id_commessa).getOdistinta().modificaRigaLavoro(rg);
	}
	
	/**
	 * Singleton
	 * @return instance:GestisciCommessaHandler
	 */
	public static GestisciCommessaHandler getInstance() {
		if (GestisciCommessaHandler.instance == null) {
			GestisciCommessaHandler.instance = new GestisciCommessaHandler();
		}

		return GestisciCommessaHandler.instance;
	}
	

}