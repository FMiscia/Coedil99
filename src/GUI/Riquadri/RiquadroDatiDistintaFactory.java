package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroDatiDistintaFactory extends RiquadroFactory {

	private static RiquadroFactory instance;
	
	private RiquadroDatiDistintaFactory(){};
	
	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return new RiquadroDatiDistinta("Riga Lavoro");
	}
	
	public static RiquadroFactory getInstance(){
		if(instance == null)
			return new RiquadroDatiDistintaFactory();
		else return instance;
	}

}
