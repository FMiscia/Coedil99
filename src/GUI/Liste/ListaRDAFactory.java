package GUI.Liste;

import GUI.Abstract.ALista;

/**
 * 
 * @author francesco
 *
 * Implementazione Factory di Abstract Factory
 */
public class ListaRDAFactory extends ListaFactory {

	private static ListaRDAFactory instance = null;
	
	private ListaRDAFactory(){};
	
	@Override
	public ALista makeLista() {
		return null;
		// TODO Auto-generated method stub
	}
	
	@Override
	public ALista makeLista(String tipo)  {
		// TODO Auto-generated method stub
		return new ListaRDA(tipo);
	}
	
	public static ListaRDAFactory getInstance(){
		if(instance == null)
			instance = new ListaRDAFactory();
		return instance;
	}




}
