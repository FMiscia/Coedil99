package coedil99.controller;

import coedil99.persistentmodel.AOttimizzatoreStrategy;
import coedil99.persistentmodel.Distinta;
import coedil99.persistentmodel.DocumentoOttimizzazione;



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
