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
package elaboradistinta.model;

import elaboradistinta.operation.ODocumentoOttimizzazione;
import elaboradistinta.operation.ORigheLavoro;

public class Distinta {
	public Distinta() {
	}
	
	public boolean save() {
		try {
			elaboradistinta.model.CoedilPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete() {
		try {
			elaboradistinta.model.CoedilPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean refresh() {
		try {
			elaboradistinta.model.CoedilPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean evict() {
		try {
			elaboradistinta.model.CoedilPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private int ID;
	
	private elaboradistinta.model.DocumentoOttimizzazione ddo;
	
	private elaboradistinta.model.RigheLavoro lavori;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLavori(elaboradistinta.model.RigheLavoro value) {
		this.lavori = value;
	}
	
	public elaboradistinta.model.RigheLavoro getLavori() {
		return lavori;
	}
	
	public void setDdo(elaboradistinta.model.DocumentoOttimizzazione value) {
		this.ddo = value;
	}
	
	public elaboradistinta.model.DocumentoOttimizzazione getDdo() {
		return ddo;
	}
	
	private static int count;
	
	public void creaDDO() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public ORigheLavoro getORigheLavoro() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public ODocumentoOttimizzazione getOddo() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
