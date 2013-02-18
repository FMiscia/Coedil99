package ElaboraDistinta;

import java.util.ArrayList;

public class Distinta {

	private int id;
	RigheLavoro lavori = new RigheLavoro();
	DocumentoOttimizzazione ddo;

	public Distinta(){
		/*startup*/
		this.id = 1;
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


}