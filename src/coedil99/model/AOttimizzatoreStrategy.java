package coedil99.model;

/**
 * Pattern Strategy
 * 
 * @author francesco
 *
 */
public abstract class AOttimizzatoreStrategy implements IModelComponent{

	
	protected AOttimizzatoreStrategy(){
		
	}
	/**
	 * 
	 * @param distinta
	 * @return ddo:DocumentoOttimizzazione
	 */
	public abstract DocumentoOttimizzazione elaboraOttimizzazione(Distinta distinta);

}