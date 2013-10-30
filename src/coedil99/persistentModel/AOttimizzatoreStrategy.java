package coedil99.persistentModel;

/**
 * Pattern Strategy
 * 
 * @author francesco
 *
 */
public abstract class AOttimizzatoreStrategy implements IPersistentModel{

	
	protected AOttimizzatoreStrategy(){
		
	}
	/**
	 * 
	 * @param distinta
	 * @return ddo:DocumentoOttimizzazione
	 */
	public abstract DocumentoOttimizzazione elaboraOttimizzazione(Distinta distinta);

}