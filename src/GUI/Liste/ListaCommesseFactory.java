package GUI.Liste;

import org.orm.PersistentException;

import GUI.Abstract.ALista;

public class ListaCommesseFactory extends ListaFactory {
	
	private static ListaCommesseFactory instance = null;
	
	private ListaCommesseFactory(){};
	
	@Override
	public ALista makeLista() {
		// TODO Auto-generated method stub
		return new ListaCommesse();
	}
	
	@Override
	public ALista makeLista(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static ListaCommesseFactory getInstance(){
		if(instance == null)
			instance = new ListaCommesseFactory();
		return instance;
	}

}
