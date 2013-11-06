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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class DipendenteFactory {
	public static Dipendente loadDipendenteByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadDipendenteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente getDipendenteByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getDipendenteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente loadDipendenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadDipendenteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente getDipendenteByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getDipendenteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente loadDipendenteByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Dipendente) session.load(coedil99.persistentmodel.Dipendente.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente getDipendenteByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Dipendente) session.get(coedil99.persistentmodel.Dipendente.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente loadDipendenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dipendente) session.load(coedil99.persistentmodel.Dipendente.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente getDipendenteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dipendente) session.get(coedil99.persistentmodel.Dipendente.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente[] listDipendenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listDipendenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente[] listDipendenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listDipendenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente[] listDipendenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.Dipendente as Dipendente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Dipendente[]) list.toArray(new Dipendente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente[] listDipendenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.Dipendente as Dipendente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Dipendente[]) list.toArray(new Dipendente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente loadDipendenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadDipendenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente loadDipendenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadDipendenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dipendente loadDipendenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Dipendente[] dipendentes = listDipendenteByQuery(session, condition, orderBy);
		if (dipendentes != null && dipendentes.length > 0)
			return dipendentes[0];
		else
			return null;
	}
	
	public static Dipendente loadDipendenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Dipendente[] dipendentes = listDipendenteByQuery(session, condition, orderBy, lockMode);
		if (dipendentes != null && dipendentes.length > 0)
			return dipendentes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDipendenteByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateDipendenteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDipendenteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateDipendenteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDipendenteByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.Dipendente as Dipendente");
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
	
	public static java.util.Iterator iterateDipendenteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.Dipendente as Dipendente");
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
	
	public static Dipendente createDipendente() {
		return new coedil99.persistentmodel.Dipendente();
	}
	

}
