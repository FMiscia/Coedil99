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
public class CatalogoFornitore {
	public CatalogoFornitore() {
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
			coedil99.persistentmodel.ProductDescription[] lProductDescriptions = productDescription.toArray();
			for(int i = 0; i < lProductDescriptions.length; i++) {
				lProductDescriptions[i].setCatalogoFornitore(null);
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
			coedil99.persistentmodel.ProductDescription[] lProductDescriptions = productDescription.toArray();
			for(int i = 0; i < lProductDescriptions.length; i++) {
				lProductDescriptions[i].setCatalogoFornitore(null);
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
		if (key == coedil99.persistentmodel.ORMConstants.KEY_CATALOGOFORNITORE_PRODUCTDESCRIPTION) {
			return ORM_productDescription;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	
	private int ID;
	
	private String name;
	
	private java.util.List ORM_productDescription = new java.util.ArrayList();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	private void setORM_ProductDescription(java.util.List value) {
		this.ORM_productDescription = value;
	}
	
	private java.util.List getORM_ProductDescription() {
		return ORM_productDescription;
	}
	
	public final coedil99.persistentmodel.ProductDescriptionListCollection productDescription = new coedil99.persistentmodel.ProductDescriptionListCollection(this, _ormAdapter, coedil99.persistentmodel.ORMConstants.KEY_CATALOGOFORNITORE_PRODUCTDESCRIPTION, coedil99.persistentmodel.ORMConstants.KEY_PRODUCTDESCRIPTION_CATALOGOFORNITORE, coedil99.persistentmodel.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}