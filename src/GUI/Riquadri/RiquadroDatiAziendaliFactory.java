package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroDatiAziendaliFactory extends RiquadroFactory {
	
	private static RiquadroFactory instance;
	
	private RiquadroDatiAziendaliFactory(){};
	
	@Override
	public ARiquadro makeRiquadro() {
		return new RiquadroDatiAziendali("Dati Aziendali");
		
	}
	
	public static RiquadroFactory getInstance(){
		if(instance == null)
			return new RiquadroDatiAziendaliFactory();
		else return instance;
	}

}
