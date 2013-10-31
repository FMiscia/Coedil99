package coedil99.model;

import coedil99.persistentmodel.IPersistentModel;

/**
 * Pattern Strategy
 * 
 * @author francesco
 */
public abstract class AOttimizzatoreStrategy implements IPersistentModel {

	/**
	 * 
	 * @return 
	 */
	protected AOttimizzatoreStrategy() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param distinta
	 * @return ddo:DocumentoOttimizzazione
	 */
	public abstract MDocumentoOttimizzazione elaboraOttimizzazione(MDistinta distinta);

}