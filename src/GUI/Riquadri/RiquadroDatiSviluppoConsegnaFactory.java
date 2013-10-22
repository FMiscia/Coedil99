package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

/**
 * Factory riquadro dati sviluppo consenga
 * 
 * @author Simone
 */
public class RiquadroDatiSviluppoConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	/**
	 * Costruttore
	 */
	private RiquadroDatiSviluppoConsegnaFactory() {
	};

	/**
	 * Crea il riquadro
	 */
	@Override
	public ARiquadro makeRiquadro() {
		return new RiquadroDatiSviluppoConsegna("Dati Sviluppo");
	}

	/**
	 * Singleton
	 * @return RiquadroDatiSviluppoConsegnaFactory
	 */
	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroDatiSviluppoConsegnaFactory();
		return instance;
	}

}
