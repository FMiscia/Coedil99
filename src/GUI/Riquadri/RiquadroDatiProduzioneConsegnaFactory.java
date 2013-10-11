package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroDatiProduzioneConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance;

	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return new RiquadroDatiProduzioneConsegna("Dati Produzione");
	}
	
	public static RiquadroFactory getInstance(){
		if(instance == null)
			return new RiquadroDatiProduzioneConsegnaFactory();
		else return instance;
	}

}
