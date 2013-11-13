package GUI.Liste;

import GUI.Abstract.ALista;

public class ListaProdottiFactory extends ListaFactory {

	private static ListaProdottiFactory instance = null;
	
	@Override
	public ALista makeLista() {
		return new ListaProdotti();
	}

	@Override
	public ALista makeLista(String tipo) {
		return null;
	}
	
	/**
	 * Singleton
	 * 
	 * @return instance
	 */
	public static ListaProdottiFactory getInstance(){
		if(instance == null)
			instance = new ListaProdottiFactory();
		return instance;
	}

}
