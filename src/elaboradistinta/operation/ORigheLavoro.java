package elaboradistinta.operation;

import java.util.Iterator;
import java.util.ListIterator;

import elaboradistinta.model.RigaLavoro;
import elaboradistinta.model.RigheLavoro;

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
		ListIterator<RigaLavoro> righeIterator = (ListIterator<RigaLavoro>) this.righe.righe.getIterator();;
		while (righeIterator.hasNext()) {
			if (righeIterator.next().getID() == rg.getID()) {
				this.righe.righe.set(righeIterator.previousIndex(), rg);
			}
		}
	}

	/**
	 * 
	 * @param rg
	 * @return
	 */
	public void delete(RigaLavoro rg) {
		ListIterator<RigaLavoro> righeIterator = (ListIterator<RigaLavoro>) this.righe.righe.getIterator();
		while (righeIterator.hasNext()) {
			if (righeIterator.next().getID() == rg.getID())
				righeIterator.remove();
		}
	}

	/**
	 * 
	 * @param rg
	 * @return
	 */
	public void add(RigaLavoro rg) {
		this.righe.righe.add(rg);
	}
	
	
}
