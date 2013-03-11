package ElaboraDistinta.Operation;

import ElaboraDistinta.StandardOttimizzatoreStrategy;
import ElaboraDistinta.Controller.OttimizzatoreHandler;
import ElaboraDistinta.Model.Distinta;
import ElaboraDistinta.Model.RigaLavoro;

public class ODistinta {

	private Distinta distinta;
	
	
	public ODistinta(Distinta d){
		this.distinta = d;
	}
	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void addRigaLavoro(RigaLavoro rg){
		this.distinta.getRigheLavoro().add(rg);
	}
	
	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void modificaRigaLavoro(RigaLavoro rg) {
		this.distinta.getORigheLavoro().update(rg);
	}

	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void eliminaRigaLavoro(RigaLavoro rg) {
		this.distinta.getORigheLavoro().delete(rg);
	}
	
	/**
	 * 
	 * @return 
	 */
	public void creaDDO() {
		this.distinta.setDdo(new OttimizzatoreHandler(new StandardOttimizzatoreStrategy()).eseguiOttimizzazione(this.distinta));
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasDdo() {
		// TODO Auto-generated method stub
		return (this.distinta.getDdo() != null);
	}
	
	public Distinta getDistinta() {
		return distinta;
	}
	
}
