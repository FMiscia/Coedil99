package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

/**
 * Factory riquadro dati cliente consegna
 * 
 * @author Simone
 *
 */
public class RiquadroDatiClienteConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroDatiClienteConsegnaFactory() {
	};

	@Override
	public ARiquadro makeRiquadro() {
		return new RiquadroDatiClienteConsegna("Dati Cliente");
	}

	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroDatiClienteConsegnaFactory();
		return instance;
	}

}
