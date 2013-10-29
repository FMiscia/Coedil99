package coedil99.operation;

import coedil99.model.CatalogoFornitore;
import coedil99.model.IModelComponent;

/**
 * 
 * @author francesco
 *
 */

public class OCatalogoFornitore implements IOperation{
	
	private CatalogoFornitore catalogoFornitore;

	public CatalogoFornitore getCommessa() {
		return this.catalogoFornitore;
	}

	/**
	 * 
	 * @param c
	 * @return 
	 */
	public OCatalogoFornitore(CatalogoFornitore c) {
		this.catalogoFornitore = c;
	}

	public CatalogoFornitore getModel() {
		return this.catalogoFornitore;
	}
}