package coedil99.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import org.orm.PersistentException;

import coedil99.model.MCommessa;
import coedil99.model.MDistinta;
import coedil99.persistentModel.Commessa;
import coedil99.persistentModel.CommessaFactory;
import coedil99.persistentModel.Distinta;
import coedil99.persistentModel.RigaLavoro;




public class GestisciCommessaHandler {

	private int id;
	private ArrayList<MCommessa> commesse;
	private static GestisciCommessaHandler instance;

	/**
	 * Costruttore
	 */
	private GestisciCommessaHandler() {
		this.commesse = new ArrayList<MCommessa>();
		try {
			ArrayList<Commessa> persistent_commesse = new ArrayList<Commessa>(Arrays.asList(CommessaFactory.listCommessaByQuery(null, "ID")));
			for(Commessa c : persistent_commesse){
				this.commesse.add(new MCommessa(c.getID()));
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	

	
	/**
	 * 
	 * @param commessa:Commessa
	 * 
	 */
	public void add(MCommessa commessa) {
		this.commesse.add(commessa);
	}
	

	/**
	 * 
	 * @param idCommessa:int
	 */
	public void eliminaDistinta(int idCommessa) {
		this.getCommessaById(idCommessa).delete();
	}

	/**
	 * 
	 * @param id:int
	 * @return commessa:Commessa
	 */
	public MCommessa getCommessaById(int id) {
		ListIterator<MCommessa> it = this.commesse.listIterator();
		while (it.hasNext()) {
			if (it.next().getPersistentModel().getID() == id)
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
			this.getCommessaById(idCommessa).getPersistentModel().setDistinta(d);
	}
	
	/**
	 * Fornisce le commesse
	 * @return commesse:ArrayList<MCommessa>
	 */
	public ArrayList<MCommessa> getCommesse(){
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
	 * @return commessa:MCommessa
	 */
	public MCommessa getCommessaByCodiceInterno(String q){
		MCommessa c = null;
		for(int i=0; i<this.commesse.size(); ++i){
			if(this.commesse.get(i).getPersistentModel().getCodiceInterno() == q)
				c=this.commesse.get(i);
		}
		return c;
	}

	/**
	 * 
	 * @param a:int
	 * @return c:MCommessa
	 */
	public MCommessa getCommessaByIndex(int a) {
		MCommessa c = null;
		for(int i=0; i<this.commesse.size(); ++i){
			if(this.commesse.get(i).getPersistentModel().getID() == a)
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
		ListIterator<MCommessa> it = this.commesse.listIterator();
		MCommessa temp;
		while(it.hasNext()){
			temp = it.next();
			if(temp.getPersistentModel().getCodiceInterno().equals(ci) && temp.getPersistentModel().getDistinta() != null)
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
		MDistinta odistinta = new MDistinta(this.getCommessaById(id_commessa).getPersistentModel().getDistinta().getID());
		odistinta.modificaRigaLavoro(rg);
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