package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroDatiAziendaliFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroDatiAziendaliFactory() {
	};

	@Override
	public ARiquadro makeRiquadro() {
		return new RiquadroDatiAziendali("Dati Aziendali");

	}

	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroDatiAziendaliFactory();
		return instance;
	}

}
