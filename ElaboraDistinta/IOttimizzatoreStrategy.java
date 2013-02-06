package ElaboraDistinta;

import java.util.List;

public interface IOttimizzatoreStrategy {


	/**
	 * 
	 * @param righelavoro
	 * @return 
	 */
	abstract DocumentoOttimizzazione elaboraOttimizzazione(List<RigaLavoro> righelavoro);

}