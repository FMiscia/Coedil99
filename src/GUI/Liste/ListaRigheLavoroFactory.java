package GUI.Liste;

import GUI.Abstract.ALista;

/**
 * 
 * @author francesco
 * Implementazione Factory di Abstract Factory
 */
public class ListaRigheLavoroFactory extends ListaFactory {

	private static ListaRigheLavoroFactory instance = null;
	
	private ListaRigheLavoroFactory(){};
	
	@Override
	public ALista makeLista() {
		return new ListaRigheLavoro();
	}
	
	@Override
	public ALista makeLista(String tipo)  {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static ListaRigheLavoroFactory getInstance(){
		if(instance == null)
			instance = new ListaRigheLavoroFactory();
		return instance;
	}


}
