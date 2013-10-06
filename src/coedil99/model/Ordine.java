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
public class Ordine {
	public Ordine() {
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
			if(getCliente() != null) {
				getCliente().ordini.remove(this);
			}
			
			coedil99.model.Commessa[] lCommesses = commesse.toArray();
			for(int i = 0; i < lCommesses.length; i++) {
				lCommesses[i].setOrdine(null);
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
			if(getCliente() != null) {
				getCliente().ordini.remove(this);
			}
			
			coedil99.model.Commessa[] lCommesses = commesse.toArray();
			for(int i = 0; i < lCommesses.length; i++) {
				lCommesses[i].setOrdine(null);
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
		if (key == coedil99.model.ORMConstants.KEY_ORDINE_COMMESSE) {
			return ORM_commesse;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == coedil99.model.ORMConstants.KEY_ORDINE_CLIENTE) {
			this.cliente = (coedil99.model.Cliente) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private coedil99.model.Cliente cliente;
	
	private String ordineGestionale;
	
	private java.util.Date dataInizio;
	
	private java.util.Date dataScadenza;
	
	private java.util.Date dataFine;
	
	private Integer anno;
	
	private Integer numeroOrdine;
	
	private String OC;
	
	private java.util.List ORM_commesse = new java.util.ArrayList();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setOrdineGestionale(String value) {
		this.ordineGestionale = value;
	}
	
	public String getOrdineGestionale() {
		return ordineGestionale;
	}
	
	public void setDataInizio(java.util.Date value) {
		this.dataInizio = value;
	}
	
	public java.util.Date getDataInizio() {
		return dataInizio;
	}
	
	public void setDataScadenza(java.util.Date value) {
		this.dataScadenza = value;
	}
	
	public java.util.Date getDataScadenza() {
		return dataScadenza;
	}
	
	public void setDataFine(java.util.Date value) {
		this.dataFine = value;
	}
	
	public java.util.Date getDataFine() {
		return dataFine;
	}
	
	public void setAnno(int value) {
		setAnno(new Integer(value));
	}
	
	public void setAnno(Integer value) {
		this.anno = value;
	}
	
	public Integer getAnno() {
		return anno;
	}
	
	public void setNumeroOrdine(int value) {
		setNumeroOrdine(new Integer(value));
	}
	
	public void setNumeroOrdine(Integer value) {
		this.numeroOrdine = value;
	}
	
	public Integer getNumeroOrdine() {
		return numeroOrdine;
	}
	
	public void setOC(String value) {
		this.OC = value;
	}
	
	public String getOC() {
		return OC;
	}
	
	public void setCliente(coedil99.model.Cliente value) {
		if (cliente != null) {
			cliente.ordini.remove(this);
		}
		if (value != null) {
			value.ordini.add(this);
		}
	}
	
	public coedil99.model.Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Cliente(coedil99.model.Cliente value) {
		this.cliente = value;
	}
	
	private coedil99.model.Cliente getORM_Cliente() {
		return cliente;
	}
	
	private void setORM_Commesse(java.util.List value) {
		this.ORM_commesse = value;
	}
	
	private java.util.List getORM_Commesse() {
		return ORM_commesse;
	}
	
	public final coedil99.model.CommessaListCollection commesse = new coedil99.model.CommessaListCollection(this, _ormAdapter, coedil99.model.ORMConstants.KEY_ORDINE_COMMESSE, coedil99.model.ORMConstants.KEY_COMMESSA_ORDINE, coedil99.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private static int counter = 0;
	
	private Boolean isDateNull() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Ordine(coedil99.model.Cliente c, String og, Integer anno) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	private void checkDate(coedil99.model.Commessa c) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
