package ElaboraDistinta;

import java.util.ArrayList;
import java.util.ListIterator;

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
		this.getCommessaById(idCommessa).eliminaDistinta();
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
		this.getCommessaById(idCommessa).associaDistinta(d);
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
		while(it.hasNext()){
			if(it.next().getCodiceInterno().equals(ci) && it.previous().getDistinta() != null)
				it.next();
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