package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

/**
 * Factory riquadro dati sviluppo consenga
 * 
 * @author Simone
 *
 */
public class RiquadroDatiSviluppoConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroDatiSviluppoConsegnaFactory() {
	};

	@Override
	public ARiquadro makeRiquadro() {
		return new RiquadroDatiSviluppoConsegna("Dati Sviluppo");
	}

	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroDatiSviluppoConsegnaFactory();
		return instance;
	}

}
