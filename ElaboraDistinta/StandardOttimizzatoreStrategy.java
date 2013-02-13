package ElaboraDistinta;

public class StandardOttimizzatoreStrategy implements IOttimizzatoreStrategy {

	private ElaboraDistintaHandler cdistinta;
	
	
	public StandardOttimizzatoreStrategy(){
		this.cdistinta = ElaboraDistintaHandler.getInstance();
	}
	
	@Override
	public DocumentoOttimizzazione elaboraOttimizzazione(
			Distinta distinta) {
		
		/*ottimizzazione*/
		
		return null;
	}

}