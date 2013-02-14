package ElaboraDistinta;

import java.util.ArrayList;

public class Distinta {

	private int id;
	RigheLavoro lavori = new RigheLavoro();
	DocumentoOttimizzazione ddo = new DocumentoOttimizzazione();

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
	public void createDDO() {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return id;
	}
	

	public ArrayList<RigaLavoro> getRigheLavoro(){
		return this.lavori.getRigheLavoro();
	}


}