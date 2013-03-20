package elaboradistinta.operation;

import elaboradistinta.StandardOttimizzatoreStrategy;
import elaboradistinta.controller.OttimizzatoreHandler;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.RigaLavoro;

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
		this.distinta.getLavori().righe.add(rg);
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
		this.distinta.save();
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
