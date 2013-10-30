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

public class CatalogoFornitoreFactory {
	public static CatalogoFornitore loadCatalogoFornitoreByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadCatalogoFornitoreByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore getCatalogoFornitoreByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getCatalogoFornitoreByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore loadCatalogoFornitoreByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadCatalogoFornitoreByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore getCatalogoFornitoreByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getCatalogoFornitoreByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore loadCatalogoFornitoreByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (CatalogoFornitore) session.load(coedil99.persistentModel.CatalogoFornitore.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore getCatalogoFornitoreByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (CatalogoFornitore) session.get(coedil99.persistentModel.CatalogoFornitore.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore loadCatalogoFornitoreByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CatalogoFornitore) session.load(coedil99.persistentModel.CatalogoFornitore.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore getCatalogoFornitoreByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CatalogoFornitore) session.get(coedil99.persistentModel.CatalogoFornitore.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore[] listCatalogoFornitoreByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listCatalogoFornitoreByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore[] listCatalogoFornitoreByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listCatalogoFornitoreByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore[] listCatalogoFornitoreByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Coedil99.persistentModel.CatalogoFornitore as CatalogoFornitore");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (CatalogoFornitore[]) list.toArray(new CatalogoFornitore[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore[] listCatalogoFornitoreByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Coedil99.persistentModel.CatalogoFornitore as CatalogoFornitore");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (CatalogoFornitore[]) list.toArray(new CatalogoFornitore[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore loadCatalogoFornitoreByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadCatalogoFornitoreByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore loadCatalogoFornitoreByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadCatalogoFornitoreByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CatalogoFornitore loadCatalogoFornitoreByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CatalogoFornitore[] catalogoFornitores = listCatalogoFornitoreByQuery(session, condition, orderBy);
		if (catalogoFornitores != null && catalogoFornitores.length > 0)
			return catalogoFornitores[0];
		else
			return null;
	}
	
	public static CatalogoFornitore loadCatalogoFornitoreByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CatalogoFornitore[] catalogoFornitores = listCatalogoFornitoreByQuery(session, condition, orderBy, lockMode);
		if (catalogoFornitores != null && catalogoFornitores.length > 0)
			return catalogoFornitores[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCatalogoFornitoreByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateCatalogoFornitoreByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCatalogoFornitoreByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateCatalogoFornitoreByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCatalogoFornitoreByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Coedil99.persistentModel.CatalogoFornitore as CatalogoFornitore");
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
	
	public static java.util.Iterator iterateCatalogoFornitoreByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Coedil99.persistentModel.CatalogoFornitore as CatalogoFornitore");
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
	
	public static CatalogoFornitore createCatalogoFornitore() {
		return new coedil99.persistentModel.CatalogoFornitore();
	}
	
	public static CatalogoFornitore loadCatalogoFornitoreByCriteria(CatalogoFornitoreCriteria catalogoFornitoreCriteria) {
		CatalogoFornitore[] catalogoFornitores = listCatalogoFornitoreByCriteria(catalogoFornitoreCriteria);
		if(catalogoFornitores == null || catalogoFornitores.length == 0) {
			return null;
		}
		return catalogoFornitores[0];
	}
	
	public static CatalogoFornitore[] listCatalogoFornitoreByCriteria(CatalogoFornitoreCriteria catalogoFornitoreCriteria) {
		return catalogoFornitoreCriteria.listCatalogoFornitore();
	}
}
