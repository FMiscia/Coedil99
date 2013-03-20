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
import java.util.List;

public class Ordine {
	public Ordine() {
	}
	
	public static Ordine loadOrdineByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadOrdineByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine getOrdineByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getOrdineByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadOrdineByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine getOrdineByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getOrdineByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByORMID(PersistentSession session, int ID) {
		try {
			return (Ordine) session.load(elaboradistinta.model.Ordine.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine getOrdineByORMID(PersistentSession session, int ID) {
		try {
			return (Ordine) session.get(elaboradistinta.model.Ordine.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Ordine) session.load(elaboradistinta.model.Ordine.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine getOrdineByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Ordine) session.get(elaboradistinta.model.Ordine.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine[] listOrdineByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listOrdineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine[] listOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listOrdineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine[] listOrdineByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Ordine as Ordine");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Ordine[]) list.toArray(new Ordine[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine[] listOrdineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Ordine as Ordine");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Ordine[]) list.toArray(new Ordine[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadOrdineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadOrdineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByQuery(PersistentSession session, String condition, String orderBy) {
		Ordine[] ordines = listOrdineByQuery(session, condition, orderBy);
		if (ordines != null && ordines.length > 0)
			return ordines[0];
		else
			return null;
	}
	
	public static Ordine loadOrdineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Ordine[] ordines = listOrdineByQuery(session, condition, orderBy, lockMode);
		if (ordines != null && ordines.length > 0)
			return ordines[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateOrdineByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateOrdineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateOrdineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateOrdineByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Ordine as Ordine");
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
	
	public static java.util.Iterator iterateOrdineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Ordine as Ordine");
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
	
	public static Ordine loadOrdineByCriteria(OrdineCriteria ordineCriteria) {
		Ordine[] ordines = listOrdineByCriteria(ordineCriteria);
		if(ordines == null || ordines.length == 0) {
			return null;
		}
		return ordines[0];
	}
	
	public static Ordine[] listOrdineByCriteria(OrdineCriteria ordineCriteria) {
		return ordineCriteria.listOrdine();
	}
	
	public static Ordine createOrdine() {
		return new elaboradistinta.model.Ordine();
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
	
	private java.util.List this_getList (int key) {
		if (key == elaboradistinta.model.ORMConstants.KEY_ORDINE_COMMESSE) {
			return ORM_commesse;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	
	private int ID;
	
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
	
	private void setORM_Commesse(java.util.List value) {
		this.ORM_commesse = value;
	}
	
	private java.util.List getORM_Commesse() {
		return ORM_commesse;
	}
	
	public final elaboradistinta.model.CommessaListCollection commesse = new elaboradistinta.model.CommessaListCollection(this, _ormAdapter, elaboradistinta.model.ORMConstants.KEY_ORDINE_COMMESSE, elaboradistinta.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private static int counter = 0;
	
	private Boolean isDateNull() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Ordine(elaboradistinta.model.Cliente c, String og, Integer anno) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	private void checkDate(elaboradistinta.model.Commessa c) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
