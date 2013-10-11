package GUI.Riquadri;

import GUI.Abstract.ARiquadro;

public class RiquadroDatiClienteConsegnaFactory extends RiquadroFactory {

	private static RiquadroFactory instance;
	
	@Override
	public ARiquadro makeRiquadro() {
		// TODO Auto-generated method stub
		return new RiquadroDatiClienteConsegna("Dati Cliente");
	}
	
	public static RiquadroFactory getInstance(){
		if(instance == null)
			return new RiquadroDatiClienteConsegnaFactory();
		else return instance;
	}

}
