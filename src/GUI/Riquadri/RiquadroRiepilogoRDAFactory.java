package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroRiepilogoRDAFactory extends RiquadroFactory {

	private static RiquadroFactory instance = null;

	private RiquadroRiepilogoRDAFactory() {
	};


	public static RiquadroFactory getInstance() {
		if (instance == null)
			instance = new RiquadroRiepilogoRDAFactory();
		return instance;
	}


	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return null;
	}


}
