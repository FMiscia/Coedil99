package coedil99.operation;

import coedil99.model.IModelComponent;
import coedil99.model.RDA;


public class ORDA implements IOperation{
	
	private RDA rda;

	/**
	 * 
	 * @param c
	 * @return 
	 */
	public ORDA(RDA r) {
		this.rda = r;
	}

	@Override
	public IModelComponent getModel() {
		return this.rda;
	}
}