package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroOttimizzazioneFactory extends RiquadroFactory {

	private static RiquadroFactory instance;
	
	private RiquadroOttimizzazioneFactory(){};
	
	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return new RiquadroOttimizzazione("Ottimizzazione");
	}
	
	public static RiquadroFactory getInstance(){
		if(instance == null)
			return new RiquadroOttimizzazioneFactory();
		else return instance;
	}

}
