package coedil99;

import java.util.ArrayList;

import coedil99.model.Distinta;
import coedil99.model.DocumentoOttimizzazione;


public class Ottimizzatore {

	private AOttimizzatoreStrategy strategia;
	private Distinta distinta;

	public Ottimizzatore(AOttimizzatoreStrategy strategy,Distinta d) {
		
		this.strategia = strategy;
		this.distinta = d;

	}

	public DocumentoOttimizzazione Ottimizza() {
		return this.strategia.elaboraOttimizzazione(this.distinta);
	}

}
