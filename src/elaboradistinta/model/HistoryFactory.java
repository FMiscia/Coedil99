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

public class HistoryFactory {
	public static History loadHistoryByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadHistoryByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History getHistoryByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getHistoryByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History loadHistoryByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadHistoryByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History getHistoryByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getHistoryByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History loadHistoryByORMID(PersistentSession session, int ID) {
		try {
			return (History) session.load(elaboradistinta.model.History.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History getHistoryByORMID(PersistentSession session, int ID) {
		try {
			return (History) session.get(elaboradistinta.model.History.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History loadHistoryByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (History) session.load(elaboradistinta.model.History.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History getHistoryByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (History) session.get(elaboradistinta.model.History.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History[] listHistoryByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listHistoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History[] listHistoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listHistoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History[] listHistoryByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.History as History");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (History[]) list.toArray(new History[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History[] listHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.History as History");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (History[]) list.toArray(new History[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History loadHistoryByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadHistoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History loadHistoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadHistoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static History loadHistoryByQuery(PersistentSession session, String condition, String orderBy) {
		History[] historys = listHistoryByQuery(session, condition, orderBy);
		if (historys != null && historys.length > 0)
			return historys[0];
		else
			return null;
	}
	
	public static History loadHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		History[] historys = listHistoryByQuery(session, condition, orderBy, lockMode);
		if (historys != null && historys.length > 0)
			return historys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHistoryByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateHistoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateHistoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateHistoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateHistoryByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.History as History");
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
	
	public static java.util.Iterator iterateHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.History as History");
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
	
	public static History createHistory() {
		return new elaboradistinta.model.History();
	}
	
	public static History loadHistoryByCriteria(HistoryCriteria historyCriteria) {
		History[] historys = listHistoryByCriteria(historyCriteria);
		if(historys == null || historys.length == 0) {
			return null;
		}
		return historys[0];
	}
	
	public static History[] listHistoryByCriteria(HistoryCriteria historyCriteria) {
		return historyCriteria.listHistory();
	}
}
