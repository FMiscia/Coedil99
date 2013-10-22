package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

/**
 * Factory riquadro dati distinta
 * 
 * @author Simone
 *
 */
public class RiquadroDatiDistintaFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroDatiDistintaFactory() {
	};

	@Override
	public ARiquadro makeRiquadro() {
		return new RiquadroDatiDistinta("Riga Lavoro");
	}

	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroDatiDistintaFactory();
		return instance;
	}

}
