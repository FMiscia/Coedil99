package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

/**
 * Factory riquadro ottimizzazione
 * 
 * @author Simone
 *
 */
public class RiquadroOttimizzazioneFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroOttimizzazioneFactory() {
	};

	@Override
	public ARiquadro makeRiquadro() {
		return new RiquadroOttimizzazione("Ottimizzazione");
	}

	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroOttimizzazioneFactory();
		return instance;
	}

}
