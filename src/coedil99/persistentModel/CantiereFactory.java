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

public class CantiereFactory {
	public static Cantiere loadCantiereByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadCantiereByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere getCantiereByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getCantiereByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere loadCantiereByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadCantiereByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere getCantiereByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getCantiereByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere loadCantiereByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Cantiere) session.load(coedil99.persistentModel.Cantiere.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere getCantiereByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Cantiere) session.get(coedil99.persistentModel.Cantiere.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere loadCantiereByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Cantiere) session.load(coedil99.persistentModel.Cantiere.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere getCantiereByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Cantiere) session.get(coedil99.persistentModel.Cantiere.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere[] listCantiereByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listCantiereByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere[] listCantiereByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listCantiereByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere[] listCantiereByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.Cantiere as Cantiere");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Cantiere[]) list.toArray(new Cantiere[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere[] listCantiereByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.Cantiere as Cantiere");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Cantiere[]) list.toArray(new Cantiere[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere loadCantiereByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadCantiereByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere loadCantiereByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadCantiereByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Cantiere loadCantiereByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Cantiere[] cantieres = listCantiereByQuery(session, condition, orderBy);
		if (cantieres != null && cantieres.length > 0)
			return cantieres[0];
		else
			return null;
	}
	
	public static Cantiere loadCantiereByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Cantiere[] cantieres = listCantiereByQuery(session, condition, orderBy, lockMode);
		if (cantieres != null && cantieres.length > 0)
			return cantieres[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCantiereByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateCantiereByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCantiereByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateCantiereByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCantiereByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.Cantiere as Cantiere");
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
	
	public static java.util.Iterator iterateCantiereByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.Cantiere as Cantiere");
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
	
	public static Cantiere createCantiere() {
		return new coedil99.persistentModel.Cantiere();
	}
	
	public static Cantiere loadCantiereByCriteria(CantiereCriteria cantiereCriteria) {
		Cantiere[] cantieres = listCantiereByCriteria(cantiereCriteria);
		if(cantieres == null || cantieres.length == 0) {
			return null;
		}
		return cantieres[0];
	}
	
	public static Cantiere[] listCantiereByCriteria(CantiereCriteria cantiereCriteria) {
		return cantiereCriteria.listCantiere();
	}
}
