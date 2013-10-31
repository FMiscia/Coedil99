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
public class Commessa implements coedil99.persistentmodel.IPersistentModel {
	public Commessa() {
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
			if(getOrdine() != null) {
				getOrdine().commesse.remove(this);
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
			if(getOrdine() != null) {
				getOrdine().commesse.remove(this);
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
		if (key == coedil99.persistentmodel.ORMConstants.KEY_COMMESSA_DISTINTA) {
			this.distinta = (coedil99.persistentmodel.Distinta) owner;
		}
		
		else if (key == coedil99.persistentmodel.ORMConstants.KEY_COMMESSA_LDR) {
			this.ldr = (coedil99.persistentmodel.ListaRintracciabilita) owner;
		}
		
		else if (key == coedil99.persistentmodel.ORMConstants.KEY_COMMESSA_ORDINE) {
			this.ordine = (coedil99.persistentmodel.Ordine) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private coedil99.persistentmodel.Distinta distinta;
	
	private coedil99.persistentmodel.ListaRintracciabilita ldr;
	
	private coedil99.persistentmodel.Ordine ordine;
	
	private String codiceInterno;
	
	private String elementoStrutturale;
	
	private java.util.Date scadenzaCommessa;
	
	private java.util.Date emissioneCommessa;
	
	private java.util.Date fineCommessa;
	
	private java.util.Date inizioProduzione;
	
	private java.util.Date scadenzaProduzione;
	
	private java.util.Date fineProduzione;
	
	private Integer ritardoProduzione;
	
	private java.util.Date primaConsegna;
	
	private Integer ritardoConsegna;
	
	private String orario;
	
	private String descrizione;
	
	private String responsabile;
	
	public void setCodiceInterno(String value) {
		this.codiceInterno = value;
	}
	
	public String getCodiceInterno() {
		return codiceInterno;
	}
	
	public void setElementoStrutturale(String value) {
		this.elementoStrutturale = value;
	}
	
	public String getElementoStrutturale() {
		return elementoStrutturale;
	}
	
	public void setScadenzaCommessa(java.util.Date value) {
		this.scadenzaCommessa = value;
	}
	
	public java.util.Date getScadenzaCommessa() {
		return scadenzaCommessa;
	}
	
	/**
	 * sviluppo della commessa
	 */
	public void setEmissioneCommessa(java.util.Date value) {
		this.emissioneCommessa = value;
	}
	
	/**
	 * sviluppo della commessa
	 */
	public java.util.Date getEmissioneCommessa() {
		return emissioneCommessa;
	}
	
	/**
	 * sviluppo della commessa
	 */
	public void setFineCommessa(java.util.Date value) {
		this.fineCommessa = value;
	}
	
	/**
	 * sviluppo della commessa
	 */
	public java.util.Date getFineCommessa() {
		return fineCommessa;
	}
	
	/**
	 * sviluppo della commessa
	 */
	public void setInizioProduzione(java.util.Date value) {
		this.inizioProduzione = value;
	}
	
	/**
	 * sviluppo della commessa
	 */
	public java.util.Date getInizioProduzione() {
		return inizioProduzione;
	}
	
	public void setScadenzaProduzione(java.util.Date value) {
		this.scadenzaProduzione = value;
	}
	
	public java.util.Date getScadenzaProduzione() {
		return scadenzaProduzione;
	}
	
	public void setFineProduzione(java.util.Date value) {
		this.fineProduzione = value;
	}
	
	public java.util.Date getFineProduzione() {
		return fineProduzione;
	}
	
	public void setRitardoProduzione(int value) {
		setRitardoProduzione(new Integer(value));
	}
	
	public void setRitardoProduzione(Integer value) {
		this.ritardoProduzione = value;
	}
	
	public Integer getRitardoProduzione() {
		return ritardoProduzione;
	}
	
	/**
	 * giorni
	 */
	public void setPrimaConsegna(java.util.Date value) {
		this.primaConsegna = value;
	}
	
	/**
	 * giorni
	 */
	public java.util.Date getPrimaConsegna() {
		return primaConsegna;
	}
	
	public void setRitardoConsegna(int value) {
		setRitardoConsegna(new Integer(value));
	}
	
	public void setRitardoConsegna(Integer value) {
		this.ritardoConsegna = value;
	}
	
	public Integer getRitardoConsegna() {
		return ritardoConsegna;
	}
	
	/**
	 * giorni
	 */
	public void setOrario(String value) {
		this.orario = value;
	}
	
	/**
	 * giorni
	 */
	public String getOrario() {
		return orario;
	}
	
	/**
	 * consegna: del tipo Mattina o Pomeriggio
	 */
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	/**
	 * consegna: del tipo Mattina o Pomeriggio
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setResponsabile(String value) {
		this.responsabile = value;
	}
	
	public String getResponsabile() {
		return responsabile;
	}
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDistinta(coedil99.persistentmodel.Distinta value) {
		this.distinta = value;
	}
	
	public coedil99.persistentmodel.Distinta getDistinta() {
		return distinta;
	}
	
	public void setLdr(coedil99.persistentmodel.ListaRintracciabilita value) {
		this.ldr = value;
	}
	
	public coedil99.persistentmodel.ListaRintracciabilita getLdr() {
		return ldr;
	}
	
	public void setOrdine(coedil99.persistentmodel.Ordine value) {
		if (ordine != null) {
			ordine.commesse.remove(this);
		}
		if (value != null) {
			value.commesse.add(this);
		}
	}
	
	public coedil99.persistentmodel.Ordine getOrdine() {
		return ordine;
	}
	
	/**
	 * This method is for internal use only.
	 */
	private void setORM_Ordine(coedil99.persistentmodel.Ordine value) {
		this.ordine = value;
	}
	
	private coedil99.persistentmodel.Ordine getORM_Ordine() {
		return ordine;
	}
	
	/**
	 * dipendente
	 */
	private static int counter = 0;
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
