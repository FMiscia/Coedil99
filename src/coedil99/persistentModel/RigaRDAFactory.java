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
package coedil99.persistentModel;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class RigaRDAFactory {
	public static RigaRDA loadRigaRDAByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadRigaRDAByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA getRigaRDAByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getRigaRDAByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA loadRigaRDAByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadRigaRDAByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA getRigaRDAByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getRigaRDAByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA loadRigaRDAByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (RigaRDA) session.load(coedil99.persistentModel.RigaRDA.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA getRigaRDAByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (RigaRDA) session.get(coedil99.persistentModel.RigaRDA.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA loadRigaRDAByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RigaRDA) session.load(coedil99.persistentModel.RigaRDA.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA getRigaRDAByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RigaRDA) session.get(coedil99.persistentModel.RigaRDA.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA[] listRigaRDAByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listRigaRDAByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA[] listRigaRDAByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listRigaRDAByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA[] listRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.coedil99.persistentModel.RigaRDA as RigaRDA");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (RigaRDA[]) list.toArray(new RigaRDA[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA[] listRigaRDAByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentModel.RigaRDA as RigaRDA");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (RigaRDA[]) list.toArray(new RigaRDA[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA loadRigaRDAByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadRigaRDAByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA loadRigaRDAByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadRigaRDAByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RigaRDA loadRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		RigaRDA[] rigaRDAs = listRigaRDAByQuery(session, condition, orderBy);
		if (rigaRDAs != null && rigaRDAs.length > 0)
			return rigaRDAs[0];
		else
			return null;
	}
	
	public static RigaRDA loadRigaRDAByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		RigaRDA[] rigaRDAs = listRigaRDAByQuery(session, condition, orderBy, lockMode);
		if (rigaRDAs != null && rigaRDAs.length > 0)
			return rigaRDAs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRigaRDAByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateRigaRDAByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRigaRDAByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateRigaRDAByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRigaRDAByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentModel.RigaRDA as RigaRDA");
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
	
	public static java.util.Iterator iterateRigaRDAByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentModel.RigaRDA as RigaRDA");
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
	
	public static RigaRDA createRigaRDA() {
		return new coedil99.persistentModel.RigaRDA();
	}
	
	public static RigaRDA loadRigaRDAByCriteria(RigaRDACriteria rigaRDACriteria) {
		RigaRDA[] rigaRDAs = listRigaRDAByCriteria(rigaRDACriteria);
		if(rigaRDAs == null || rigaRDAs.length == 0) {
			return null;
		}
		return rigaRDAs[0];
	}
	
	public static RigaRDA[] listRigaRDAByCriteria(RigaRDACriteria rigaRDACriteria) {
		return rigaRDACriteria.listRigaRDA();
	}
}
