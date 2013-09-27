package coedil99.operation;

import java.util.ListIterator;

import coedil99.Ottimizzatore;
import coedil99.StandardOttimizzatoreStrategy;
import coedil99.model.Distinta;
import coedil99.model.RigaLavoro;

public class ODistinta {

	private Distinta distinta;

	public Distinta getDistinta() {
		return this.distinta;
	}

	/**
	 * 
	 * @param d
	 * @return 
	 */
	public ODistinta(Distinta d) {
		this.distinta = d;
	}

	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void addRigaLavoro(RigaLavoro rg) {
		this.distinta.getLavori().add(rg);
	}

	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void modificaRigaLavoro(RigaLavoro rg) {
		ListIterator<RigaLavoro> righeIterator = (ListIterator<RigaLavoro>) this.distinta.getLavori().getIterator();;
		while (righeIterator.hasNext()) {
			if (righeIterator.next().getID() == rg.getID()) {
				this.distinta.getLavori().set(righeIterator.previousIndex(), rg);
			}
		}
	}

	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void eliminaRigaLavoro(RigaLavoro rg) {
		this.distinta.getLavori().remove(rg);
	}

	/**
	 * 
	 * @return 
	 */
	public void creaDDO() {
		Ottimizzatore standardOtt = new Ottimizzatore(new StandardOttimizzatoreStrategy(),this.distinta);
		this.distinta.setDdo(standardOtt.Ottimizza());
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

}