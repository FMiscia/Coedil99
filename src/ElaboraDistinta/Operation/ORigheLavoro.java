package ElaboraDistinta.Operation;

import java.util.ListIterator;

import ElaboraDistinta.Model.RigaLavoro;
import ElaboraDistinta.Model.RigheLavoro;

public class ORigheLavoro {
	
	private RigheLavoro righe;

	public ORigheLavoro(RigheLavoro r){
		this.righe = r;
	}
	
	public RigheLavoro getRighe() {
		return righe;
	}

	/**
	 * 
	 * @param rg
	 * @return
	 */
	public void update(RigaLavoro rg) {
		ListIterator<RigaLavoro> righeIterator = this.righe.getRigheLavoro().listIterator();
		while (righeIterator.hasNext()) {
			if (righeIterator.next().getId() == rg.getId()) {
				this.righe.getRigheLavoro().set(righeIterator.previousIndex(), rg);
			}
		}
	}

	/**
	 * 
	 * @param rg
	 * @return
	 */
	public void delete(RigaLavoro rg) {
		ListIterator<RigaLavoro> righeIterator = this.righe.getRigheLavoro().listIterator();
		while (righeIterator.hasNext()) {
			if (righeIterator.next().getId() == rg.getId())
				righeIterator.remove();
		}
	}

	/**
	 * 
	 * @param rg
	 * @return
	 */
	public void add(RigaLavoro rg) {
		this.righe.getRigheLavoro().add(rg);
	}
	
	
}
