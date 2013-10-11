package GUI.Liste;

import GUI.Abstract.ALista;

public class ListaCommesseFactory extends ListaFactory {
	
	private static ListaCommesseFactory instance = null;
	
	private ListaCommesseFactory(){};
	
	@Override
	public ALista makeLista() {
		// TODO Auto-generated method stub
		return new ListaCommesse();
	}
	
	public static ListaCommesseFactory getInstance(){
		if(instance == null)
			instance = new ListaCommesseFactory();
		return instance;
	}

}
