package ElaboraDistinta;

public interface IOttimizzatoreStrategy {

	/**
	 * 
	 * @param righelavoro
	 * @return 
	 */
	abstract DocumentoOttimizzazione elaboraOttimizzazione(Distinta distinta);

	abstract void setElaboraDistintaHandler(); 

}