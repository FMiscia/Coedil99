package ElaboraDistinta;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RigheLavoro {

	List<RigaLavoro> riga;
	ListIterator<RigaLavoro> righeIterator;

	public RigheLavoro() {
		this.riga = new ArrayList<RigaLavoro>();
		this.righeIterator = riga.listIterator();
	}

	/**
	 * 
	 * @param rg
	 * @return
	 */
	public void update(RigaLavoro rg) {
		while (this.righeIterator.hasNext()) {
			if (this.righeIterator.next().getId() == rg.getId()) {
				this.riga.set(this.righeIterator.previousIndex(), rg);
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
		this.riga.add(rg);
	}

}