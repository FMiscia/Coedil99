package elaboradistinta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import elaboradistinta.model.Commessa;
import elaboradistinta.model.CommessaFactory;
import elaboradistinta.model.Distinta;



public class GestisciCommessaHandler {

	private int id;
	private ArrayList<Commessa> commesse;
	private static GestisciCommessaHandler instance;

	
	private GestisciCommessaHandler() {
		this.commesse = new ArrayList<Commessa>(Arrays.asList(CommessaFactory.listCommessaByQuery(null, "ID")));
	}
	

	
	/**
	 * 
	 * @param commessa
	 * @return
	 */
	public void add(Commessa commessa) {
		this.commesse.add(commessa);
	}
	

	/**
	 * 
	 * @param idCommessa
	 * @return
	 */
	public void eliminaDistinta(int idCommessa) {
		this.getCommessaById(idCommessa).setDistinta(null);
	}

	/**
	 * 
	 * @param id
	 * @return Commessa
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
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * 
	 * @param d
	 * @param idCommessa
	 */
	public void associaDistinta(Distinta d, int idCommessa){
		if(this.getCommessaById(idCommessa) != null)
			this.getCommessaById(idCommessa).setDistinta(d);
	}
	
	/**
	 * 
	 * @return commesse
	 */
	public ArrayList<Commessa> getCommesse(){
		return this.commesse;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumOfCommesse(){
		return this.commesse.size();
	}
	
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
	 * @param a
	 * @return
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
	 * 
	 * @param codiceinterno
	 * @return
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
	 * 
	 * @return
	 */
	public static GestisciCommessaHandler getInstance() {
		if (GestisciCommessaHandler.instance == null) {
			GestisciCommessaHandler.instance = new GestisciCommessaHandler();
		}

		return GestisciCommessaHandler.instance;
	}
	

}