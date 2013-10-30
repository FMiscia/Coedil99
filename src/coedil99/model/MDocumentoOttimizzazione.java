package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentModel.DistintaFactory;
import coedil99.persistentModel.DocumentoOttimizzazione;
import coedil99.persistentModel.DocumentoOttimizzazioneFactory;
import coedil99.persistentModel.IPersistentModel;

public class MDocumentoOttimizzazione implements IModel {

	private DocumentoOttimizzazione ddo;

	/**
	 * Costruttore
	 */
	public MDocumentoOttimizzazione() {
		this.ddo = DocumentoOttimizzazioneFactory
				.createDocumentoOttimizzazione();
	}
	
	/**
	 * Costruttore
	 * @param ID
	 */
	public MDocumentoOttimizzazione(int ID){
		try {
			this.ddo = DocumentoOttimizzazioneFactory
					.getDocumentoOttimizzazioneByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < this.ddo.items.size(); ++i) {
			MItem oitem = new MItem(this.ddo.items.get(i).getID());
			s = s + oitem.toString() + "\n";
		}
		return s;

	}

	public String stampaDDO() {
		String s = "";
		for (int i = 0; i < this.ddo.items.size(); ++i) {
			MItem oi = new MItem(this.ddo.items.get(i).getID());
			s = s + oi.toString();
		}
		return s;
	}

	@Override
	public void setPersistentModel(IPersistentModel m) {
		this.ddo = (DocumentoOttimizzazione)m;

	}

	@Override
	public void save() {
		try {
			this.ddo.save(); 
		} catch (PersistentException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete() {
		try {
			this.ddo.delete();					
		} catch (PersistentException e) {
			e.printStackTrace();
		}

	}

}