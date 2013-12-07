package coedil99.model;

import java.util.ListIterator;

import org.orm.PersistentException;

import coedil99.controller.OttimizzatoreHandler;
import coedil99.persistentmodel.Distinta;
import coedil99.persistentmodel.DistintaFactory;
import coedil99.persistentmodel.IPersistentModel;
import coedil99.persistentmodel.RigaLavoro;

public class MDistinta implements IModel{

	private Distinta distinta;


	/**
	 * Costruttore
	 */
	public MDistinta() {
		this.distinta = DistintaFactory.createDistinta();
		//MRigaLavoro riga = new MRigaLavoro();
		//this.distinta.lavori.add(riga.getPersistentModel());
	}
	
	/**
	 * Costruttore
	 * @param ID
	 */
	public MDistinta(int ID){
		try {
			this.distinta = DistintaFactory.loadDistintaByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void addRigaLavoro(RigaLavoro rg) {
		this.distinta.lavori.add(rg);
	}

	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void modificaRigaLavoro(RigaLavoro rg) {
		@SuppressWarnings("unchecked")
		ListIterator<RigaLavoro> righeIterator = (ListIterator<RigaLavoro>) this.distinta.lavori.getIterator();;
		while (righeIterator.hasNext()) {
			if (righeIterator.next().getID() == rg.getID()) {
				this.distinta.lavori.set(righeIterator.previousIndex(), rg);
			}
		}
	}

	/**
	 * 
	 * @param rg
	 * @return 
	 */
	public void eliminaRigaLavoro(RigaLavoro rg) {
		this.distinta.lavori.remove(rg);
		MRigaLavoro origalavoro = new MRigaLavoro(rg.getID());
		if(origalavoro.isSaved()){
			try {
				rg.delete();
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @return 
	 */
	public void creaDDO() {
			OttimizzatoreHandler ott = new OttimizzatoreHandler(new StandardOttimizzatoreStrategy(), this);
			this.distinta.setDdo(ott.Ottimizza().getPersistentModel());
			this.save();
	}

	/**
	 * 
	 * @return 
	 */
	public boolean hasDdo() {
		return (this.distinta.getDdo() != null);
	}
	
	public Distinta getPersistentModel(){
		return this.distinta;
	}

	@Override
	public void setPersistentModel(IPersistentModel m) {
		this.distinta = (Distinta)m;
		
	}

	@Override
	public void save() {
		try {
			this.distinta.save();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete() {
		try {
			this.distinta.delete();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}