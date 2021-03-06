package ElaboraDistinta.Controller;

import java.util.ArrayList;
import java.util.ListIterator;

import ElaboraDistinta.Model.Commessa;
import ElaboraDistinta.Model.Distinta;



public class GestisciCommessaHandler {

	private int id;
	private ArrayList<Commessa> commesse;
	private static GestisciCommessaHandler instance;

	
	private GestisciCommessaHandler() {
		this.commesse = new ArrayList<Commessa>();
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
			if (it.next().getId() == id)
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

	/**
	 * 
	 * @param a
	 * @return
	 */
	public Commessa getCommessaByIndex(int a) {
		// TODO Auto-generated method stub
		return this.commesse.get(a);
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