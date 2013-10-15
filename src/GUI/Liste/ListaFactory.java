package GUI.Liste;

import org.orm.PersistentException;

import GUI.Abstract.ALista;

public abstract class ListaFactory {

	public abstract ALista makeLista() throws PersistentException;
	
}
