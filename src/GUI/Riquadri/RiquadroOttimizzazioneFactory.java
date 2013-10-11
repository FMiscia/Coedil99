package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroOttimizzazioneFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroOttimizzazioneFactory() {
	};

	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return new RiquadroOttimizzazione("Ottimizzazione");
	}

	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroOttimizzazioneFactory();
		return instance;
	}

}
