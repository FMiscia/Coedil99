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
package coedil99.persistentmodel;

import org.orm.*;
public class Distinta implements coedil99.persistentmodel.IPersistentModel {
	public Distinta() {
	}
	
	public boolean save() throws PersistentException {
		try {
			coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private java.util.List this_getList (int key) {
		if (key == coedil99.persistentmodel.ORMConstants.KEY_DISTINTA_LAVORI) {
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
	
	private coedil99.persistentmodel.DocumentoOttimizzazione ddo;
	
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
	
	public void setDdo(coedil99.persistentmodel.DocumentoOttimizzazione value) {
		this.ddo = value;
	}
	
	public coedil99.persistentmodel.DocumentoOttimizzazione getDdo() {
		return ddo;
	}
	
	private void setORM_Lavori(java.util.List value) {
		this.ORM_lavori = value;
	}
	
	private java.util.List getORM_Lavori() {
		return ORM_lavori;
	}
	
	public final coedil99.persistentmodel.RigaLavoroListCollection lavori = new coedil99.persistentmodel.RigaLavoroListCollection(this, _ormAdapter, coedil99.persistentmodel.ORMConstants.KEY_DISTINTA_LAVORI, coedil99.persistentmodel.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private static int count;
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
