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

import org.orm.*;
public class Cliente implements IModelComponent{
	public Cliente() {
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
			coedil99.model.Ordine[] lOrdinis = ordini.toArray();
			for(int i = 0; i < lOrdinis.length; i++) {
				lOrdinis[i].setCliente(null);
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
			coedil99.model.Ordine[] lOrdinis = ordini.toArray();
			for(int i = 0; i < lOrdinis.length; i++) {
				lOrdinis[i].setCliente(null);
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
		if (key == coedil99.model.ORMConstants.KEY_CLIENTE_ORDINI) {
			return ORM_ordini;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	
	private int ID;
	
	private coedil99.model.Cantiere cantiere;
	
	private String name;
	
	private Integer numeroCommessaCliente;
	
	private java.util.List ORM_ordini = new java.util.ArrayList();
	
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
	
	public void setNumeroCommessaCliente(int value) {
		setNumeroCommessaCliente(new Integer(value));
	}
	
	public void setNumeroCommessaCliente(Integer value) {
		this.numeroCommessaCliente = value;
	}
	
	public Integer getNumeroCommessaCliente() {
		return numeroCommessaCliente;
	}
	
	public void setCantiere(coedil99.model.Cantiere value) {
		this.cantiere = value;
	}
	
	public coedil99.model.Cantiere getCantiere() {
		return cantiere;
	}
	
	private void setORM_Ordini(java.util.List value) {
		this.ORM_ordini = value;
	}
	
	private java.util.List getORM_Ordini() {
		return ORM_ordini;
	}
	
	public final coedil99.model.OrdineListCollection ordini = new coedil99.model.OrdineListCollection(this, _ormAdapter, coedil99.model.ORMConstants.KEY_CLIENTE_ORDINI, coedil99.model.ORMConstants.KEY_ORDINE_CLIENTE, coedil99.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public Cliente(String n, coedil99.model.Cantiere c) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
