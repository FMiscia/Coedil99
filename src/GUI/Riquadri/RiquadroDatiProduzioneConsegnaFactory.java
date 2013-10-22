package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

/**
 * Factory riquadro dati produzione consenga
 * 
 * @author Simone
 *
 */
public class RiquadroDatiProduzioneConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroDatiProduzioneConsegnaFactory() {
	};

	@Override
	public ARiquadro makeRiquadro() {
		return new RiquadroDatiProduzioneConsegna("Dati Produzione");
	}

	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroDatiProduzioneConsegnaFactory();
		return instance;
	}

}
