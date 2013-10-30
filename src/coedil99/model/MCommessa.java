package coedil99.model;

import coedil99.persistentModel.Commessa;
import coedil99.persistentModel.IPersistentModel;

public class MCommessa implements IModel{

	private Commessa commessa;

	/**
	 * 
	 * @param c
	 * @return 
	 */
	public MCommessa(Commessa c) {
		this.commessa = c;
	}

	@Override
	public IPersistentModel getModel() {
		return this.commessa;
	}

	@Override
	public void setModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		
	}

}