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

import elaboradistinta.operation.OItem;

public class Item {
	public Item() {
	}
	
	public boolean save() {
		try {
			elaboradistinta.model.Coedil99ingdelsoftwarePersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete() {
		try {
			elaboradistinta.model.Coedil99ingdelsoftwarePersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean refresh() {
		try {
			elaboradistinta.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean evict() {
		try {
			elaboradistinta.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == elaboradistinta.model.ORMConstants.KEY_ITEM_HISTORY) {
			this.history = (elaboradistinta.model.History) owner;
		}
		
		else if (key == elaboradistinta.model.ORMConstants.KEY_ITEM_GEOMETRIA) {
			this.geometria = (elaboradistinta.model.Geometria) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private elaboradistinta.model.Geometria geometria;
	
	private elaboradistinta.model.History history;
	
	private String descrizione;
	
	private Float prezzo;
	
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
	
	public void setHistory(elaboradistinta.model.History value) {
		this.history = value;
	}
	
	public elaboradistinta.model.History getHistory() {
		return history;
	}
	
	public void setGeometria(elaboradistinta.model.Geometria value) {
		this.geometria = value;
	}
	
	public elaboradistinta.model.Geometria getGeometria() {
		return geometria;
	}
	
	public Item(elaboradistinta.model.Geometria g, String d) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public OItem getOItem() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
