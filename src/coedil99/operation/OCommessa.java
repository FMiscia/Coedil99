package coedil99.operation;

import coedil99.model.Commessa;
import coedil99.model.IModelComponent;

public class OCommessa implements IOperation{

	private Commessa commessa;

	/**
	 * 
	 * @param c
	 * @return 
	 */
	public OCommessa(Commessa c) {
		this.commessa = c;
	}

	@Override
	public IModelComponent getModel() {
		return this.commessa;
	}

	@Override
	public void setModel(IModelComponent m) {
		// TODO Auto-generated method stub
		
	}

}