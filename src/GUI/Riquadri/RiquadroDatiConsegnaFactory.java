package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroDatiConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance;
	
	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return new RiquadroDatiConsegna("Dati Consegna");
	}
	
	public static RiquadroFactory getInstance(){
		if(instance == null)
			return new RiquadroDatiConsegnaFactory();
		else return instance;
	}

}
