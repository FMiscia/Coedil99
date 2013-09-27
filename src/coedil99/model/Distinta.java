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
package coedil99.model;

import coedil99.AOttimizzatoreStrategy;
import coedil99.StandardOttimizzatoreStrategy;
import coedil99.controller.OttimizzatoreHandler;
import coedil99.operation.ODistinta;
import coedil99.operation.ODocumentoOttimizzazione;

public class Distinta {
	private ODistinta oDistinta;
	
	public Distinta() {
		this.oDistinta = new ODistinta(this);
	}
	
	public boolean save() {
		try {
			coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete() {
		try {
			coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean refresh() {
		try {
			coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean evict() {
		try {
			coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private java.util.List this_getList (int key) {
		if (key == coedil99.model.ORMConstants.KEY_DISTINTA_LAVORI) {
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
	
	private coedil99.model.DocumentoOttimizzazione ddo;
	
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
	
	public ODistinta getODistinta(){
		return this.oDistinta;
	}
	
	public void setDdo(coedil99.model.DocumentoOttimizzazione value) {
		this.ddo = value;
	}
	
	public coedil99.model.DocumentoOttimizzazione getDdo() {
		return ddo;
	}
	
	private void setORM_Lavori(java.util.List value) {
		this.ORM_lavori = value;
	}
	
	private java.util.List getORM_Lavori() {
		return ORM_lavori;
	}
	
	private coedil99.model.RigaLavoroListCollection lavori = new coedil99.model.RigaLavoroListCollection(this, _ormAdapter, coedil99.model.ORMConstants.KEY_DISTINTA_LAVORI, coedil99.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private static int count;
	
	public void creaDDO() {
		OttimizzatoreHandler oh = new OttimizzatoreHandler(new StandardOttimizzatoreStrategy());
		this.ddo = oh.eseguiOttimizzazione(this);
		this.ddo.save();
		this.save();
	}
	
	public ODocumentoOttimizzazione getOddo() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}

	public coedil99.model.RigaLavoroListCollection getLavori() {
		return lavori;
	}

	public void setLavori(coedil99.model.RigaLavoroListCollection lavori) {
		this.lavori = lavori;
	}
	
	public void eliminaRigaLavoro(RigaLavoro rg){
		this.lavori.remove(rg);
		rg.delete();
		this.save();
	}
	
}