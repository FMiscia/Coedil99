package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.Dipendente;
import coedil99.persistentmodel.DipendenteFactory;
import coedil99.persistentmodel.IPersistentModel;
public class MDipendente implements IModel {

	private Dipendente dipendente;
	/**
	 * Costruttore senza parametri
	 *
	 */
	public MDipendente(){
		this.dipendente = DipendenteFactory.createDipendente();
	}
	
	/**
	 * Costruttore con parametro
	 * @param ID
	 */
	public MDipendente(int ID){
		try {
			this.dipendente = DipendenteFactory.getDipendenteByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setPersistentModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		this.dipendente = (Dipendente) m;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			this.dipendente.save();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		try {
			this.dipendente.delete();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
