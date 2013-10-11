package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroDatiSviluppoConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance;
	
	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return new RiquadroDatiSviluppoConsegna("Dati Sviluppo");
	}
	
	public static RiquadroFactory getInstance(){
		if(instance == null)
			return new RiquadroDatiSviluppoConsegnaFactory();
		else return instance;
	}

}
