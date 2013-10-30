package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentModel.IPersistentModel;
import coedil99.persistentModel.RigaRDA;
import coedil99.persistentModel.RigaRDAFactory;

public class MRigaRDA implements IModel {

	private RigaRDA rigarda;
	
	/**
	 * Costruttore
	 */
	public MRigaRDA(){
		this.rigarda = RigaRDAFactory.createRigaRDA();
	}
	
	/**
	 * Costruttore
	 * @param ID
	 */
	public MRigaRDA(int ID){
		try {
			this.rigarda = RigaRDAFactory.loadRigaRDAByORMID(ID);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void setPersistentModel(IPersistentModel m) {
		this.rigarda = (RigaRDA)m;

	}
	
	public RigaRDA getPersistentModel(){
		return this.rigarda;
	}

	@Override
	public void save() {
		try {
			this.rigarda.save();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete() {
		try {
			this.rigarda.deleteAndDissociate();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
