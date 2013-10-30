package coedil99.model;

import java.util.ListIterator;

import org.orm.PersistentException;

import coedil99.controller.OttimizzatoreHandler;
import coedil99.persistentModel.Distinta;
import coedil99.persistentModel.IPersistentModel;
import coedil99.persistentModel.RigaLavoro;
import coedil99.persistentModel.StandardOttimizzatoreStrategy;

public class MDistinta implements IModel{

	private Distinta distinta;


	/**
	 * 
	 * @param d
	 * @return 
	 */
	public MDistinta(Distinta d) {
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
		@SuppressWarnings("unchecked")
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
		MRigaLavoro origalavoro = new MRigaLavoro(rg);
		if(origalavoro.isSaved()){
			try {
				rg.delete();
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @return 
	 */
	public void creaDDO() {
		OttimizzatoreHandler standardOtt = new OttimizzatoreHandler(new StandardOttimizzatoreStrategy(),this.distinta);
		this.distinta.setDdo(standardOtt.Ottimizza());
		try {
			this.distinta.save();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return 
	 */
	public boolean hasDdo() {
		// TODO Auto-generated method stub
		return (this.distinta.getDdo() != null);
	}

	@Override
	public IPersistentModel getModel() {
		return this.distinta;
	}

	@Override
	public void setModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		
	}

}