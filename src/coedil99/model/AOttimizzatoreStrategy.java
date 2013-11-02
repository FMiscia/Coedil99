package coedil99.model;

import coedil99.persistentmodel.IPersistentModel;

/**
 * Pattern Strategy
 * 
 * @author francesco
 */
public abstract class AOttimizzatoreStrategy {

	/**
	 * 
	 * @return 
	 */
	protected AOttimizzatoreStrategy() {
	}

	/**
	 * 
	 * @param distinta
	 * @return ddo:DocumentoOttimizzazione
	 */
	public abstract MDocumentoOttimizzazione elaboraOttimizzazione(MDistinta distinta);

}