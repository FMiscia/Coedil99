package GUI.Liste;

import org.orm.PersistentException;

import GUI.Abstract.ALista;

/**
 * 
 * @author francesco
 *
 * Abstract Factory per la creazione di lista Commesse e lista RDA
 */
public abstract class ListaFactory {

	public abstract ALista makeLista();
	public abstract ALista makeLista(String tipo);
	
}
