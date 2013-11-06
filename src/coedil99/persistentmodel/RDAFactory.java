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

import java.util.List;

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public class RDAFactory {
	public static RDA loadRDAByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadRDAByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA getRDAByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getRDAByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA loadRDAByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadRDAByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA getRDAByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getRDAByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA loadRDAByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (RDA) session.load(coedil99.persistentmodel.RDA.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA getRDAByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (RDA) session.get(coedil99.persistentmodel.RDA.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA loadRDAByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RDA) session.load(coedil99.persistentmodel.RDA.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA getRDAByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RDA) session.get(coedil99.persistentmodel.RDA.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA[] listRDAByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listRDAByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA[] listRDAByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listRDAByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA[] listRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.RDA as RDA");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (RDA[]) list.toArray(new RDA[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA[] listRDAByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.RDA as RDA");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (RDA[]) list.toArray(new RDA[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA loadRDAByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadRDAByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA loadRDAByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadRDAByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RDA loadRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		RDA[] rDAs = listRDAByQuery(session, condition, orderBy);
		if (rDAs != null && rDAs.length > 0)
			return rDAs[0];
		else
			return null;
	}
	
	public static RDA loadRDAByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		RDA[] rDAs = listRDAByQuery(session, condition, orderBy, lockMode);
		if (rDAs != null && rDAs.length > 0)
			return rDAs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRDAByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateRDAByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRDAByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateRDAByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.RDA as RDA");
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
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRDAByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.RDA as RDA");
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
			throw new PersistentException(e);
		}
	}
	
	public static RDA createRDA() {
		return new coedil99.persistentmodel.RDA();
	}
	
	public static RDA loadRDAByCriteria(RDACriteria rDACriteria) {
		RDA[] rDAs = listRDAByCriteria(rDACriteria);
		if(rDAs == null || rDAs.length == 0) {
			return null;
		}
		return rDAs[0];
	}
	
	public static RDA[] listRDAByCriteria(RDACriteria rDACriteria) {
		return rDACriteria.listRDA();
	}
}
