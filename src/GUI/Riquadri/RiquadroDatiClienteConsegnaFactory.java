package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroDatiClienteConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroDatiClienteConsegnaFactory() {
	};

	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return new RiquadroDatiClienteConsegna("Dati Cliente");
	}

	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroDatiClienteConsegnaFactory();
		return instance;
	}

}
