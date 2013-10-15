package GUI.Liste;

import GUI.Abstract.ALista;

public class ListaRDACongelateFactory extends ListaFactory {

	private static ListaRDACongelateFactory instance = null;
	
	private ListaRDACongelateFactory(){};
	
	@Override
	public ALista makeLista() {
		// TODO Auto-generated method stub
		return new ListaRDACongelate();
	}
	
	public static ListaRDACongelateFactory getInstance(){
		if(instance == null)
			instance = new ListaRDACongelateFactory();
		return instance;
	}


}
