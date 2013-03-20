package elaboradistinta;

import elaboradistinta.model.Distinta;
import elaboradistinta.model.DocumentoOttimizzazione;

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