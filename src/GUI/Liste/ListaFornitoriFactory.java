package GUI.Liste;

import GUI.Abstract.ALista;

/**
 * Implementazione Factory di Lista Factory
 * 
 * @author Simone
 *
 */
public class ListaFornitoriFactory extends ListaFactory {
	
	private static ListaFornitoriFactory instance = null;
	
	private ListaFornitoriFactory(){};
	
	@Override
	public ALista makeLista() {
		return new ListaFornitori();
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
	public static ListaFornitoriFactory getInstance(){
		if(instance == null)
			instance = new ListaFornitoriFactory();
		return instance;
	}


}
