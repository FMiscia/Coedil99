package coedil99.controller;

import coedil99.model.AOttimizzatoreStrategy;
import coedil99.model.Distinta;
import coedil99.model.DocumentoOttimizzazione;

public class OttimizzatoreHandler {

	private AOttimizzatoreStrategy instance;

	
	public OttimizzatoreHandler(AOttimizzatoreStrategy s){
		this.instance = s;
	}
	
	public DocumentoOttimizzazione eseguiOttimizzazione(Distinta distinta){
		return this.instance.elaboraOttimizzazione(distinta);
	}
}
