package ElaboraDistinta;

public class StandardOttimizzatoreStrategy implements IOttimizzatoreStrategy {

	private ElaboraDistintaHandler cdistinta;
	
	
	public StandardOttimizzatoreStrategy(){
		this.setElaboraDistintaHandler();
	}
	
	@Override
	public DocumentoOttimizzazione elaboraOttimizzazione(
			Distinta distinta) {
		
		return null;
	}

	@Override
	/*Con il Singleton prendiamo il controllore esistente*/
	public void setElaboraDistintaHandler() {
		this.cdistinta = ElaboraDistintaHandler.getInstance();
		
	}
}