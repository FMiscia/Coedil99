package coedil99.controller;

import java.util.HashMap;

import coedil99.model.AOttimizzatoreStrategy;
import coedil99.model.MDistinta;
import coedil99.model.MDocumentoOttimizzazione;
import coedil99.model.StandardOttimizzatoreStrategy;

public class OttimizzatoreHandler {

	private coedil99.model.AOttimizzatoreStrategy strategia;
	private MDistinta distinta;

	public static HashMap<String, AOttimizzatoreStrategy> ottimizzatori;
	static {
		ottimizzatori = new HashMap<String, AOttimizzatoreStrategy>();
		ottimizzatori.put("Standard", new StandardOttimizzatoreStrategy());
	}

	/**
	 * Costruttore
	 * 
	 * @param strategy
	 * @param d
	 */
	public OttimizzatoreHandler(coedil99.model.AOttimizzatoreStrategy strategy,
			MDistinta d) {

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
