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
public class RigaLavoro implements coedil99.persistentmodel.IPersistentModel {
	public RigaLavoro() {
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
	
	private void this_setOwner(Object owner, int key) {
		if (key == coedil99.persistentmodel.ORMConstants.KEY_RIGALAVORO_GEOMETRIA) {
			this.geometria = (coedil99.persistentmodel.Geometria) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private coedil99.persistentmodel.Geometria geometria;
	
	private boolean capitello;
	
	private String profiloCapitello;
	
	private String note;
	
	private int numero;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCapitello(boolean value) {
		this.capitello = value;
	}
	
	public boolean getCapitello() {
		return capitello;
	}
	
	public void setProfiloCapitello(String value) {
		this.profiloCapitello = value;
	}
	
	public String getProfiloCapitello() {
		return profiloCapitello;
	}
	
	public void setNote(String value) {
		this.note = value;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNumero(int value) {
		this.numero = value;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setGeometria(coedil99.persistentmodel.Geometria value) {
		this.geometria = value;
	}
	
	public coedil99.persistentmodel.Geometria getGeometria() {
		return geometria;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
