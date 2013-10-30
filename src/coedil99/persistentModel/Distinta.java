/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package coedil99.persistentModel;

import org.orm.*;

import coedil99.model.MDistinta;
import coedil99.model.MDocumentoOttimizzazione;
public class Distinta implements IPersistentModel{
	public Distinta() {
	}
	
	public boolean save() throws PersistentException {
		try {
			coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private java.util.List this_getList (int key) {
		if (key == coedil99.persistentModel.ORMConstants.KEY_DISTINTA_LAVORI) {
			return ORM_lavori;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	
	private int ID;
	
	private coedil99.persistentModel.DocumentoOttimizzazione ddo;
	
	private java.util.List ORM_lavori = new java.util.ArrayList();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDdo(coedil99.persistentModel.DocumentoOttimizzazione value) {
		this.ddo = value;
	}
	
	public coedil99.persistentModel.DocumentoOttimizzazione getDdo() {
		return ddo;
	}
	
	private void setORM_Lavori(java.util.List value) {
		this.ORM_lavori = value;
	}
	
	private java.util.List getORM_Lavori() {
		return ORM_lavori;
	}
	
	public final coedil99.persistentModel.RigaLavoroListCollection lavori = new coedil99.persistentModel.RigaLavoroListCollection(this, _ormAdapter, coedil99.persistentModel.ORMConstants.KEY_DISTINTA_LAVORI, coedil99.persistentModel.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private static int count;
		
	public String toString() {
		return String.valueOf(getID());
	}
	
	public RigaLavoroListCollection getLavori() {
		// TODO Auto-generated method stub
		return this.lavori;
	}
	
}
