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

import org.orm.*;
import org.hibernate.Query;

import elaboradistinta.operation.ODistinta;

import java.util.List;

public class Commessa {
	public Commessa() {
	}
	
	public static Commessa loadCommessaByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadCommessaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa getCommessaByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getCommessaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa loadCommessaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadCommessaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa getCommessaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getCommessaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa loadCommessaByORMID(PersistentSession session, int ID) {
		try {
			return (Commessa) session.load(elaboradistinta.model.Commessa.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa getCommessaByORMID(PersistentSession session, int ID) {
		try {
			return (Commessa) session.get(elaboradistinta.model.Commessa.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa loadCommessaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Commessa) session.load(elaboradistinta.model.Commessa.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa getCommessaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Commessa) session.get(elaboradistinta.model.Commessa.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa[] listCommessaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listCommessaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa[] listCommessaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listCommessaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa[] listCommessaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Commessa as Commessa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Commessa[]) list.toArray(new Commessa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa[] listCommessaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Commessa as Commessa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Commessa[]) list.toArray(new Commessa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa loadCommessaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadCommessaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa loadCommessaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadCommessaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa loadCommessaByQuery(PersistentSession session, String condition, String orderBy) {
		Commessa[] commessas = listCommessaByQuery(session, condition, orderBy);
		if (commessas != null && commessas.length > 0)
			return commessas[0];
		else
			return null;
	}
	
	public static Commessa loadCommessaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Commessa[] commessas = listCommessaByQuery(session, condition, orderBy, lockMode);
		if (commessas != null && commessas.length > 0)
			return commessas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCommessaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateCommessaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateCommessaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateCommessaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateCommessaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Commessa as Commessa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateCommessaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Commessa as Commessa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Commessa loadCommessaByCriteria(CommessaCriteria commessaCriteria) {
		Commessa[] commessas = listCommessaByCriteria(commessaCriteria);
		if(commessas == null || commessas.length == 0) {
			return null;
		}
		return commessas[0];
	}
	
	public static Commessa[] listCommessaByCriteria(CommessaCriteria commessaCriteria) {
		return commessaCriteria.listCommessa();
	}
	
	public static Commessa createCommessa() {
		return new elaboradistinta.model.Commessa();
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
	
	private void this_setOwner(Object owner, int key) {
		if (key == elaboradistinta.model.ORMConstants.KEY_COMMESSA_LDR) {
			this.ldr = (elaboradistinta.model.ListaRintracciabilita) owner;
		}
		
		else if (key == elaboradistinta.model.ORMConstants.KEY_COMMESSA_DISTINTA) {
			this.distinta = (elaboradistinta.model.Distinta) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private elaboradistinta.model.Distinta distinta;
	
	private elaboradistinta.model.ListaRintracciabilita ldr;
	
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
	
	public void setLdr(elaboradistinta.model.ListaRintracciabilita value) {
		this.ldr = value;
	}
	
	public elaboradistinta.model.ListaRintracciabilita getLdr() {
		return ldr;
	}
	
	public void setDistinta(elaboradistinta.model.Distinta value) {
		this.distinta = value;
	}
	
	public elaboradistinta.model.Distinta getDistinta() {
		return distinta;
	}
	
	/**
	 * dipendente
	 */
	private static int counter = 0;
	
	public Commessa(elaboradistinta.model.Ordine o, elaboradistinta.model.Distinta d, String es, java.util.Calendar s, java.util.Calendar e, String orario, String desc, String resp) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Integer getOrdineId() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public java.util.Calendar getScadenza() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setScadenza(java.util.Calendar scadenza) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public ODistinta getOdistinta() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
