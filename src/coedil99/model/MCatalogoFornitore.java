package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.CatalogoFornitore;
import coedil99.persistentmodel.CatalogoFornitoreFactory;
import coedil99.persistentmodel.IPersistentModel;

/**
 * 
 * @author francesco
 * 
 */

public class MCatalogoFornitore implements IModel {

	 private CatalogoFornitore catalogoFornitore;
	/**
	 * Costruttore senza parametro
	 * 
	 */
	public MCatalogoFornitore() {
		this.catalogoFornitore = CatalogoFornitoreFactory.createCatalogoFornitore();
	}

	/**
	 * Costruttore
	 * @param ID
	 * 
	 */
	public MCatalogoFornitore(int ID) {
		try {
			this.catalogoFornitore = CatalogoFornitoreFactory
					.getCatalogoFornitoreByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save() {
		try {
			this.catalogoFornitore.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	
	public CatalogoFornitore getPersistentModel() {
		return this.catalogoFornitore;
	}
	
	@Override
	public void delete(){
		try {
			this.catalogoFornitore.deleteAndDissociate();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setPersistentModel(IPersistentModel m) {
		this.catalogoFornitore = (CatalogoFornitore)m;
		
	}
	




}
