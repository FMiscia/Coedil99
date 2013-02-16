package ElaboraDistinta;

import java.util.ArrayList;
import java.util.ListIterator;

public class RigheLavoro {

	ArrayList<RigaLavoro> righe;
	ListIterator<RigaLavoro> righeIterator;

	public RigheLavoro() {
		this.righe = new ArrayList<RigaLavoro>();
		this.righeIterator = righe.listIterator();
	}

	/**
	 * 
	 * @param rg
	 * @return
	 */
	public void update(RigaLavoro rg) {
		while (this.righeIterator.hasNext()) {
			if (this.righeIterator.next().getId() == rg.getId()) {
				this.righeIterator.set(rg);
			}
		}
	}

	/**
	 * 
	 * @param rg
	 * @return
	 */
	public void delete(RigaLavoro rg) {
		while (this.righeIterator.hasNext()) {
			if (this.righeIterator.next().getId() == rg.getId())
				this.righeIterator.remove();
		}
	}

	/**
	 * 
	 * @param rg
	 * @return
	 */
	public void add(RigaLavoro rg) {
		this.righeIterator.add(rg);
	}
	
	public ArrayList<RigaLavoro> getRigheLavoro(){
		return this.righe;
	}

}