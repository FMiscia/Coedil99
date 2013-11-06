package coedil99.model;

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