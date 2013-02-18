package ElaboraDistinta;

public class OttimizzatoreHandler {

	private AOttimizzatoreStrategy instance;

	
	public OttimizzatoreHandler(AOttimizzatoreStrategy s){
		this.instance = s;
	}
	
	public DocumentoOttimizzazione eseguiOttimizzazione(Distinta distinta){
		return this.instance.elaboraOttimizzazione(distinta);
	}
}
