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

public class DistintaFactory {
	public static Distinta loadDistintaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta getDistintaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta loadDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta getDistintaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta loadDistintaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Distinta) session.load(coedil99.persistentModel.Distinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta getDistintaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Distinta) session.get(coedil99.persistentModel.Distinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta loadDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Distinta) session.load(coedil99.persistentModel.Distinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta getDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Distinta) session.get(coedil99.persistentModel.Distinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta[] listDistintaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta[] listDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Coedil99.persistentModel.Distinta as Distinta");
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
			throw new PersistentException(e);
		}
	}
	
	public static Distinta[] listDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Coedil99.persistentModel.Distinta as Distinta");
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
			throw new PersistentException(e);
		}
	}
	
	public static Distinta loadDistintaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta loadDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Distinta[] distintas = listDistintaByQuery(session, condition, orderBy);
		if (distintas != null && distintas.length > 0)
			return distintas[0];
		else
			return null;
	}
	
	public static Distinta loadDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Distinta[] distintas = listDistintaByQuery(session, condition, orderBy, lockMode);
		if (distintas != null && distintas.length > 0)
			return distintas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDistintaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDistintaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Coedil99.persistentModel.Distinta as Distinta");
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
	
	public static java.util.Iterator iterateDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Coedil99.persistentModel.Distinta as Distinta");
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
	
	public static Distinta createDistinta() {
		return new coedil99.persistentModel.Distinta();
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
}
