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

import java.util.Date;

import org.orm.*;

import coedil99.controller.GestisciRDAHandler;
public class RDA extends coedil99.model.Subject {
	public RDA() {
		this.date = new Date();
		this.state = GestisciRDAHandler.CONGELATA;
	}
	
	public boolean save() throws PersistentException {
		try {
			coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean delete() throws PersistentException {
		try {
			coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh() throws PersistentException {
		try {
			coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean evict() throws PersistentException {
		try {
			coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			coedil99.model.RigaRDA[] lRigheRDAs = righeRDA.toArray();
			for(int i = 0; i < lRigheRDAs.length; i++) {
				lRigheRDAs[i].setRDA(null);
			}
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session)throws PersistentException {
		try {
			coedil99.model.RigaRDA[] lRigheRDAs = righeRDA.toArray();
			for(int i = 0; i < lRigheRDAs.length; i++) {
				lRigheRDAs[i].setRDA(null);
			}
			try {
				session.delete(this);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	private java.util.List this_getList (int key) {
		if (key == coedil99.model.ORMConstants.KEY_RDA_RIGHERDA) {
			return ORM_righeRDA;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	
	private int ID;
	
	private String state;
	
	private java.util.Date date;
	
	private java.util.List ORM_righeRDA = new java.util.ArrayList();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setState(String value) {
		this.state = value;
	}
	
	public String getState() {
		return state;
	}
	
	public void setDate(java.util.Date value) {
		this.date = value;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	private void setORM_RigheRDA(java.util.List value) {
		this.ORM_righeRDA = value;
	}
	
	private java.util.List getORM_RigheRDA() {
		return ORM_righeRDA;
	}
	
	public final coedil99.model.RigaRDAListCollection righeRDA = new coedil99.model.RigaRDAListCollection(this, _ormAdapter, coedil99.model.ORMConstants.KEY_RDA_RIGHERDA, coedil99.model.ORMConstants.KEY_RIGARDA_RDA, coedil99.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}

	@Override
	public void Attach(Observer obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Detach(Observer obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Notify() {
		// TODO Auto-generated method stub
		
	}
	
}
