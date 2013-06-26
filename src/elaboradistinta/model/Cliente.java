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

public class Cliente {
	public Cliente() {
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
	
	public boolean deleteAndDissociate() {
		try {
			elaboradistinta.model.Ordine[] lOrdinis = ordini.toArray();
			for(int i = 0; i < lOrdinis.length; i++) {
				lOrdinis[i].setCliente(null);
			}
			return delete();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAndDissociate(org.orm.PersistentSession session) {
		try {
			elaboradistinta.model.Ordine[] lOrdinis = ordini.toArray();
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
			return false;
		}
	}
	
	private java.util.List this_getList (int key) {
		if (key == elaboradistinta.model.ORMConstants.KEY_CLIENTE_ORDINI) {
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
	
	private elaboradistinta.model.Cantiere cantiere;
	
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
	
	public void setCantiere(elaboradistinta.model.Cantiere value) {
		this.cantiere = value;
	}
	
	public elaboradistinta.model.Cantiere getCantiere() {
		return cantiere;
	}
	
	private void setORM_Ordini(java.util.List value) {
		this.ORM_ordini = value;
	}
	
	private java.util.List getORM_Ordini() {
		return ORM_ordini;
	}
	
	public final elaboradistinta.model.OrdineListCollection ordini = new elaboradistinta.model.OrdineListCollection(this, _ormAdapter, elaboradistinta.model.ORMConstants.KEY_CLIENTE_ORDINI, elaboradistinta.model.ORMConstants.KEY_ORDINE_CLIENTE, elaboradistinta.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public Cliente(String n, elaboradistinta.model.Cantiere c) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
