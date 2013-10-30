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
public class ProductDescription implements IPersistentModel{
	public ProductDescription() {
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
	
	public boolean deleteAndDissociate()throws PersistentException {
		try {
			if(getCatalogoFornitore() != null) {
				getCatalogoFornitore().productDescription.remove(this);
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
			if(getCatalogoFornitore() != null) {
				getCatalogoFornitore().productDescription.remove(this);
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
		if (key == coedil99.persistentModel.ORMConstants.KEY_PRODUCTDESCRIPTION_CATALOGOFORNITORE) {
			this.catalogoFornitore = (coedil99.persistentModel.CatalogoFornitore) owner;
		}
		
		else if (key == coedil99.persistentModel.ORMConstants.KEY_PRODUCTDESCRIPTION_GEOMETRIA) {
			this.geometria = (coedil99.persistentModel.Geometria) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private coedil99.persistentModel.Geometria geometria;
	
	private coedil99.persistentModel.CatalogoFornitore catalogoFornitore;
	
	private String essenza;
	
	private float prezzo;
	
	private int pezzi_per_pacco;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setEssenza(String value) {
		this.essenza = value;
	}
	
	public String getEssenza() {
		return essenza;
	}
	
	public void setPrezzo(float value) {
		this.prezzo = value;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setPezzi_per_pacco(int value) {
		this.pezzi_per_pacco = value;
	}
	
	public int getPezzi_per_pacco() {
		return pezzi_per_pacco;
	}
	
	public void setCatalogoFornitore(coedil99.persistentModel.CatalogoFornitore value) {
		if (catalogoFornitore != null) {
			catalogoFornitore.productDescription.remove(this);
		}
		if (value != null) {
			value.productDescription.add(this);
		}
	}
	
	public coedil99.persistentModel.CatalogoFornitore getCatalogoFornitore() {
		return catalogoFornitore;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_CatalogoFornitore(coedil99.persistentModel.CatalogoFornitore value) {
		this.catalogoFornitore = value;
	}
	
	private coedil99.persistentModel.CatalogoFornitore getORM_CatalogoFornitore() {
		return catalogoFornitore;
	}
	
	public void setGeometria(coedil99.persistentModel.Geometria value) {
		this.geometria = value;
	}
	
	public coedil99.persistentModel.Geometria getGeometria() {
		return geometria;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
