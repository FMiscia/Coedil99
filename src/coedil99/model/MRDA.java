package coedil99.model;

import coedil99.persistentModel.IPersistentModel;
import coedil99.persistentModel.RDA;


public class MRDA implements IModel{
	
	private RDA rda;

	/**
	 * 
	 * @param c
	 * @return 
	 */
	public MRDA(RDA r) {
		this.rda = r;
	}

	@Override
	public IPersistentModel getModel() {
		return this.rda;
	}

	@Override
	public void setModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		
	}
}