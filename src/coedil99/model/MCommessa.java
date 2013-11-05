package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.CatalogoFornitoreFactory;
import coedil99.persistentmodel.Commessa;
import coedil99.persistentmodel.CommessaFactory;
import coedil99.persistentmodel.IPersistentModel;

public class MCommessa implements IModel{

	private Commessa commessa;

	/**
	 * Costruttore
	 * 
	 */
	public MCommessa() {
		this.commessa = CommessaFactory.createCommessa();
	}
	
	/**
	 * Costruttore
	 * @param ID
	 */
	public MCommessa(int ID){
		try {
			this.commessa = CommessaFactory
					.getCommessaByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	
	public Commessa getPersistentModel() {
		// TODO Auto-generated method stub
		return this.commessa;
	}

	
	/**
	 * Save Model
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			this.commessa.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setPersistentModel(IPersistentModel m) {
		this.commessa = (Commessa)m;
		
	}

	@Override
	public void delete() {
		try {
			this.commessa.deleteAndDissociate();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void setCodiceInterno() {
		this.commessa.setCodiceInterno(
				this.commessa.getOrdine().getAnno().toString()+"-"+
				this.commessa.getOrdine().getNumeroOrdine()+"-"+
				this.commessa.getOrdine().getCliente().getNumeroCommessaCliente());
		
	}
	

}