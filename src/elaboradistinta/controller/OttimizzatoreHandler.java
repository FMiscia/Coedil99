package elaboradistinta.controller;

import elaboradistinta.AOttimizzatoreStrategy;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.DocumentoOttimizzazione;

public class OttimizzatoreHandler {

	private AOttimizzatoreStrategy instance;

	
	public OttimizzatoreHandler(AOttimizzatoreStrategy s){
		this.instance = s;
	}
	
	public DocumentoOttimizzazione eseguiOttimizzazione(Distinta distinta){
		return this.instance.elaboraOttimizzazione(distinta);
	}
}
