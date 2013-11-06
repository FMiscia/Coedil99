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

import org.orm.PersistentException;
public class RigaRDA implements coedil99.persistentmodel.IPersistentModel {
	public RigaRDA() {
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
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			if(getRDA() != null) {
				getRDA().righeRDA.remove(this);
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
			if(getRDA() != null) {
				getRDA().righeRDA.remove(this);
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
	
	private void this_setOwner(Object owner, int key) {
		if (key == coedil99.persistentmodel.ORMConstants.KEY_RIGARDA_RDA) {
			this.RDA = (coedil99.persistentmodel.RDA) owner;
		}
		
		else if (key == coedil99.persistentmodel.ORMConstants.KEY_RIGARDA_DESCRIPTION) {
			this.description = (coedil99.persistentmodel.ProductDescription) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private coedil99.persistentmodel.RDA RDA;
	
	private coedil99.persistentmodel.ProductDescription description;
	
	private int quantity;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setQuantity(int value) {
		this.quantity = value;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setRDA(coedil99.persistentmodel.RDA value) {
		if (RDA != null) {
			RDA.righeRDA.remove(this);
		}
		if (value != null) {
			value.righeRDA.add(this);
		}
	}
	
	public coedil99.persistentmodel.RDA getRDA() {
		return RDA;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_RDA(coedil99.persistentmodel.RDA value) {
		this.RDA = value;
	}
	
	private coedil99.persistentmodel.RDA getORM_RDA() {
		return RDA;
	}
	
	public void setDescription(coedil99.persistentmodel.ProductDescription value) {
		this.description = value;
	}
	
	public coedil99.persistentmodel.ProductDescription getDescription() {
		return description;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
