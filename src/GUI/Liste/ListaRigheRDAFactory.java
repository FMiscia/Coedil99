package GUI.Liste;

import org.orm.PersistentException;

import GUI.Abstract.ALista;

public class ListaRigheRDAFactory extends ListaFactory {

	private static ListaRigheRDAFactory instance = null;
	
	private ListaRigheRDAFactory(){};
	
	@Override
	public ALista makeLista() {
		// TODO Auto-generated method stub
		return new ListaRigheRDA();
	}
	
	@Override
	public ALista makeLista(String tipo)  {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static ListaRigheRDAFactory getInstance(){
		if(instance == null)
			instance = new ListaRigheRDAFactory();
		return instance;
	}


}
