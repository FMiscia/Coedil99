package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentModel.CatalogoFornitore;
import coedil99.persistentModel.CatalogoFornitoreFactory;
import coedil99.persistentModel.IPersistentModel;
import coedil99.persistentModel.RigaLavoro;
import coedil99.persistentModel.RigaLavoroFactory;

public class MRigaLavoro implements IModel{

	private RigaLavoro rigalavoro;
	private boolean isSaved = false;

	/**
	 * Costruttore senza parametro
	 * 
	 */
	public MRigaLavoro() {
		this.rigalavoro = RigaLavoroFactory.createRigaLavoro();
	}

	/**
	 * Costruttore
	 * @param ID
	 * 
	 */
	public MRigaLavoro(int ID) {
		try {
			this.rigalavoro = RigaLavoroFactory
					.getRigaLavoroByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isSaved(){
		return this.isSaved;
	}

	@Override
	public void save() {
		try {
			this.rigalavoro.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setPersistentModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		this.rigalavoro = (RigaLavoro) m;
	}
	
	public RigaLavoro getPersistentModel(){
		return this.rigalavoro;
	}
	
}
