package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroDatiSviluppoConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroDatiSviluppoConsegnaFactory() {
	};

	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return new RiquadroDatiSviluppoConsegna("Dati Sviluppo");
	}

	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroDatiSviluppoConsegnaFactory();
		return instance;
	}

}
