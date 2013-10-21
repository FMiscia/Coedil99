package coedil99.controller;

import coedil99.model.AOttimizzatoreStrategy;
import coedil99.model.Distinta;
import coedil99.model.DocumentoOttimizzazione;



public class OttimizzatoreHandler {

	private AOttimizzatoreStrategy strategia;
	private Distinta distinta;

	/**
	 * Costruttore
	 * 
	 * @param strategy
	 * @param d
	 */
	public OttimizzatoreHandler(AOttimizzatoreStrategy strategy,Distinta d) {
		
		this.strategia = strategy;
		this.distinta = d;

	}

	/**
	 * Ottimizza in base alla strategia
	 * 
	 * @return ddo:DocumentoOttimizzazione
	 */
	public DocumentoOttimizzazione Ottimizza() {
		return this.strategia.elaboraOttimizzazione(this.distinta);
	}

}
