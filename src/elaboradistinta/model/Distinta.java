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

import elaboradistinta.operation.ODocumentoOttimizzazione;
import elaboradistinta.operation.ORigheLavoro;

import java.util.List;

public class Distinta {
	public Distinta() {
	}
	
	public static Distinta loadDistintaByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta getDistintaByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta loadDistintaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta getDistintaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta loadDistintaByORMID(PersistentSession session, int ID) {
		try {
			return (Distinta) session.load(elaboradistinta.model.Distinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta getDistintaByORMID(PersistentSession session, int ID) {
		try {
			return (Distinta) session.get(elaboradistinta.model.Distinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta loadDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Distinta) session.load(elaboradistinta.model.Distinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta getDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Distinta) session.get(elaboradistinta.model.Distinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta[] listDistintaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta[] listDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Distinta as Distinta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Distinta[]) list.toArray(new Distinta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Distinta as Distinta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Distinta[]) list.toArray(new Distinta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta loadDistintaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta loadDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy) {
		Distinta[] distintas = listDistintaByQuery(session, condition, orderBy);
		if (distintas != null && distintas.length > 0)
			return distintas[0];
		else
			return null;
	}
	
	public static Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Distinta[] distintas = listDistintaByQuery(session, condition, orderBy, lockMode);
		if (distintas != null && distintas.length > 0)
			return distintas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDistintaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateDistintaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Distinta as Distinta");
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
	
	public static java.util.Iterator iterateDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Distinta as Distinta");
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
	
	public static Distinta loadDistintaByCriteria(DistintaCriteria distintaCriteria) {
		Distinta[] distintas = listDistintaByCriteria(distintaCriteria);
		if(distintas == null || distintas.length == 0) {
			return null;
		}
		return distintas[0];
	}
	
	public static Distinta[] listDistintaByCriteria(DistintaCriteria distintaCriteria) {
		return distintaCriteria.listDistinta();
	}
	
	public static Distinta createDistinta() {
		return new elaboradistinta.model.Distinta();
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
	
	private int ID;
	
	private elaboradistinta.model.DocumentoOttimizzazione ddo;
	
	private elaboradistinta.model.RigheLavoro lavori;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLavori(elaboradistinta.model.RigheLavoro value) {
		this.lavori = value;
	}
	
	public elaboradistinta.model.RigheLavoro getLavori() {
		return lavori;
	}
	
	public void setDdo(elaboradistinta.model.DocumentoOttimizzazione value) {
		this.ddo = value;
	}
	
	public elaboradistinta.model.DocumentoOttimizzazione getDdo() {
		return ddo;
	}
	
	private static int count;
	
	public void creaDDO() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public ORigheLavoro getORigheLavoro() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public ODocumentoOttimizzazione getOddo() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
