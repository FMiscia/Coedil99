package ElaboraDistinta;

import ElaboraDistinta.Model.Distinta;
import ElaboraDistinta.Model.DocumentoOttimizzazione;

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