package coedil99.controller;

import coedil99.model.MDistinta;
import coedil99.model.MDocumentoOttimizzazione;
import coedil99.persistentmodel.*;




public class OttimizzatoreHandler {

	private coedil99.model.AOttimizzatoreStrategy strategia;
	private MDistinta distinta;
	private Distinta attribute;

	/**
	 * Costruttore
	 * 
	 * @param strategy
	 * @param d
	 */
	public OttimizzatoreHandler(coedil99.model.AOttimizzatoreStrategy strategy,MDistinta d) {
		
		this.strategia = strategy;
		this.distinta = d;

	}

	/**
	 * Ottimizza in base alla strategia
	 * 
	 * @return ddo:DocumentoOttimizzazione
	 */
	public MDocumentoOttimizzazione Ottimizza() {
		return this.strategia.elaboraOttimizzazione(this.distinta);
	}

}
