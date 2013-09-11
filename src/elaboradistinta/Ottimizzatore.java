package elaboradistinta;

import java.util.ArrayList;

import elaboradistinta.model.Distinta;
import elaboradistinta.model.DocumentoOttimizzazione;

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
