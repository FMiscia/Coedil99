package ElaboraDistinta.Model;

import java.util.ArrayList;

import ElaboraDistinta.StandardOttimizzatoreStrategy;
import ElaboraDistinta.Controller.OttimizzatoreHandler;

public class Distinta {

	private static int count;
	private int id;
	private RigheLavoro lavori = new RigheLavoro();
	private DocumentoOttimizzazione ddo = null;
	

	public Distinta(){
		/*startup*/
		this.count++;
		this.id = count;
	}
	
	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void addRigaLavoro(RigaLavoro rg){
		this.lavori.add(rg);
	}
	
	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void modificaRigaLavoro(RigaLavoro rg) {
		this.lavori.update(rg);
	}

	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void eliminaRigaLavoro(RigaLavoro rg) {
		this.lavori.delete(rg);
	}

	/**
	 * 
	 * @return 
	 */
	public void creaDDO() {
		this.ddo = new OttimizzatoreHandler(new StandardOttimizzatoreStrategy()).eseguiOttimizzazione(this);
	}

	public int getId() {
		return id;
	}
	

	public ArrayList<RigaLavoro> getRigheLavoro(){
		return this.lavori.getRigheLavoro();
	}

	public DocumentoOttimizzazione getDdo() {
		
		return ddo;
	}

	public void setDdo(DocumentoOttimizzazione ddo) {
		this.ddo = ddo;
	}

	public boolean hasDdo() {
		// TODO Auto-generated method stub
		return (this.ddo != null);
	}
	


}