package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.Cantiere;
import coedil99.persistentmodel.CantiereFactory;
import coedil99.persistentmodel.GeometriaFactory;
import coedil99.persistentmodel.IPersistentModel;

/**
 * 
 * @author francesco
 * 
 */
public class MCantiere implements IModel {

	private Cantiere cantiere;

	/**
	 * Costruttore
	 */
	public MCantiere() {
		this.cantiere = CantiereFactory.createCantiere();
	}

	/**
	 * Costruttore con load by ID
	 * 
	 * @param ID
	 */
	public MCantiere(int ID) {
		try {
			this.cantiere = CantiereFactory.getCantiereByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setPersistentModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		this.cantiere = (Cantiere) m;
	}

	public Cantiere getPersistentModel() {
		return this.cantiere;
	}

	/**
	 * Salva il cantiere
	 */
	@Override
	public void save() {
		try {
			this.cantiere.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Elimina il cantiere
	 */
	@Override
	public void delete() {
		try {
			this.cantiere.delete();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
