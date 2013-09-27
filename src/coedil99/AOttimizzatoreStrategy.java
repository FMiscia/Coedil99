package coedil99;

import coedil99.model.Distinta;
import coedil99.model.DocumentoOttimizzazione;

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