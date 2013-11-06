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
public class Item implements coedil99.persistentmodel.IPersistentModel {
	public Item() {
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
		if (key == coedil99.persistentmodel.ORMConstants.KEY_ITEM_PRODUCTDESCRIPTION) {
			this.productDescription = (coedil99.persistentmodel.ProductDescription) owner;
		}
		
		else if (key == coedil99.persistentmodel.ORMConstants.KEY_ITEM_GEOMETRIA) {
			this.geometria = (coedil99.persistentmodel.Geometria) owner;
		}
		
		else if (key == coedil99.persistentmodel.ORMConstants.KEY_ITEM_HISTORY) {
			this.history = (coedil99.persistentmodel.History) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private coedil99.persistentmodel.ProductDescription productDescription;
	
	private coedil99.persistentmodel.Geometria geometria;
	
	private coedil99.persistentmodel.History history;
	
	private String descrizione;
	
	private Float prezzo;
	
	private String state;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setPrezzo(float value) {
		setPrezzo(new Float(value));
	}
	
	public void setPrezzo(Float value) {
		this.prezzo = value;
	}
	
	public Float getPrezzo() {
		return prezzo;
	}
	
	public void setState(String value) {
		this.state = value;
	}
	
	public String getState() {
		return state;
	}
	
	public void setProductDescription(coedil99.persistentmodel.ProductDescription value) {
		this.productDescription = value;
	}
	
	public coedil99.persistentmodel.ProductDescription getProductDescription() {
		return productDescription;
	}
	
	public void setGeometria(coedil99.persistentmodel.Geometria value) {
		this.geometria = value;
	}
	
	public coedil99.persistentmodel.Geometria getGeometria() {
		return geometria;
	}
	
	public void setHistory(coedil99.persistentmodel.History value) {
		this.history = value;
	}
	
	public coedil99.persistentmodel.History getHistory() {
		return history;
	}
	
	public Item(coedil99.persistentmodel.Geometria g, String d) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
