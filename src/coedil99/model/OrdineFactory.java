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

import java.util.List;

import org.hibernate.Query;
import org.orm.PersistentSession;

public class OrdineFactory {
	public static Ordine loadOrdineByORMID(int ID) {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadOrdineByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine getOrdineByORMID(int ID) {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getOrdineByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadOrdineByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine getOrdineByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getOrdineByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByORMID(PersistentSession session, int ID) {
		try {
			return (Ordine) session.load(coedil99.model.Ordine.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine getOrdineByORMID(PersistentSession session, int ID) {
		try {
			return (Ordine) session.get(coedil99.model.Ordine.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Ordine) session.load(coedil99.model.Ordine.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine getOrdineByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Ordine) session.get(coedil99.model.Ordine.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine[] listOrdineByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listOrdineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine[] listOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listOrdineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine[] listOrdineByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.model.Ordine as Ordine");
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
		StringBuffer sb = new StringBuffer("From coedil99.model.Ordine as Ordine");
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
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadOrdineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Ordine loadOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
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
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateOrdineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateOrdineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateOrdineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateOrdineByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.model.Ordine as Ordine");
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
		StringBuffer sb = new StringBuffer("From coedil99.model.Ordine as Ordine");
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
	
	public static Ordine createOrdine() {
		return new coedil99.model.Ordine();
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
}
