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

public class RigheLavoroFactory {
	public static RigheLavoro loadRigheLavoroByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadRigheLavoroByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro getRigheLavoroByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getRigheLavoroByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro loadRigheLavoroByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadRigheLavoroByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro getRigheLavoroByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getRigheLavoroByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro loadRigheLavoroByORMID(PersistentSession session, int ID) {
		try {
			return (RigheLavoro) session.load(elaboradistinta.model.RigheLavoro.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro getRigheLavoroByORMID(PersistentSession session, int ID) {
		try {
			return (RigheLavoro) session.get(elaboradistinta.model.RigheLavoro.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro loadRigheLavoroByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (RigheLavoro) session.load(elaboradistinta.model.RigheLavoro.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro getRigheLavoroByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (RigheLavoro) session.get(elaboradistinta.model.RigheLavoro.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro[] listRigheLavoroByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listRigheLavoroByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro[] listRigheLavoroByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listRigheLavoroByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro[] listRigheLavoroByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.RigheLavoro as RigheLavoro");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (RigheLavoro[]) list.toArray(new RigheLavoro[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro[] listRigheLavoroByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.RigheLavoro as RigheLavoro");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (RigheLavoro[]) list.toArray(new RigheLavoro[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro loadRigheLavoroByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadRigheLavoroByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro loadRigheLavoroByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadRigheLavoroByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigheLavoro loadRigheLavoroByQuery(PersistentSession session, String condition, String orderBy) {
		RigheLavoro[] righeLavoros = listRigheLavoroByQuery(session, condition, orderBy);
		if (righeLavoros != null && righeLavoros.length > 0)
			return righeLavoros[0];
		else
			return null;
	}
	
	public static RigheLavoro loadRigheLavoroByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		RigheLavoro[] righeLavoros = listRigheLavoroByQuery(session, condition, orderBy, lockMode);
		if (righeLavoros != null && righeLavoros.length > 0)
			return righeLavoros[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRigheLavoroByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateRigheLavoroByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateRigheLavoroByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateRigheLavoroByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateRigheLavoroByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.RigheLavoro as RigheLavoro");
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
	
	public static java.util.Iterator iterateRigheLavoroByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.RigheLavoro as RigheLavoro");
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
	
	public static RigheLavoro createRigheLavoro() {
		return new elaboradistinta.model.RigheLavoro();
	}
	
	public static RigheLavoro loadRigheLavoroByCriteria(RigheLavoroCriteria righeLavoroCriteria) {
		RigheLavoro[] righeLavoros = listRigheLavoroByCriteria(righeLavoroCriteria);
		if(righeLavoros == null || righeLavoros.length == 0) {
			return null;
		}
		return righeLavoros[0];
	}
	
	public static RigheLavoro[] listRigheLavoroByCriteria(RigheLavoroCriteria righeLavoroCriteria) {
		return righeLavoroCriteria.listRigheLavoro();
	}
}
