package coedil99.model;


public abstract class AOttimizzatoreStrategy {

	
	protected AOttimizzatoreStrategy(){
		
	}
	/**
	 * 
	 * @param distinta
	 * @return 
	 */
	public abstract DocumentoOttimizzazione elaboraOttimizzazione(Distinta distinta);

}