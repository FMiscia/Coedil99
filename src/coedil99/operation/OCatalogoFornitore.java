package coedil99.operation;

import coedil99.model.CatalogoFornitore;

/**
 * 
 * @author francesco
 *
 */

public class OCatalogoFornitore {
	
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
}