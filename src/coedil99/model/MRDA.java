package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentModel.IPersistentModel;
import coedil99.persistentModel.RDA;
import coedil99.persistentModel.RDAFactory;
import coedil99.persistentModel.RigaLavoro;
import coedil99.persistentModel.RigaLavoroFactory;


public class MRDA implements IModel{
	
	private RDA rda;

	/**
	 * Costruttore senza parametro
	 * 
	 */
	public MRDA() {
		this.rda = RDAFactory.createRDA();
	}

	/**
	 * Costruttore
	 * @param ID
	 * 
	 */
	public MRDA(int ID) {
		try {
			this.rda = RDAFactory
					.getRDAByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

		
	@Override
	public void setPersistentModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		this.rda = (RDA) m;
	}
	
	public RDA getPersistentModel(){
		return this.rda;
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			this.rda.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}


}