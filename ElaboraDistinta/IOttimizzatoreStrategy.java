package ElaboraDistinta;

public interface IOttimizzatoreStrategy {

	ElaboraDistintaHandler getCdistinta();

	/**
	 * 
	 * @param righelavoro
	 * @return 
	 */
	abstract DocumentoOttimizzazione elaboraOttimizzazione(List<RigaLavoro> righelavoro);

}