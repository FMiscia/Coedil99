package GUI.Liste;

import GUI.Abstract.ALista;

public class ListaRDAFactory extends ListaFactory {

	private static ListaRDAFactory instance = null;
	
	private ListaRDAFactory(){};
	
	@Override
	public ALista makeLista() {
		// TODO Auto-generated method stub
		return new ListaRDA();
	}
	
	public static ListaRDAFactory getInstance(){
		if(instance == null)
			instance = new ListaRDAFactory();
		return instance;
	}


}
