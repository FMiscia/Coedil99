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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class GeometriaFactory {
	public static Geometria loadGeometriaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadGeometriaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria getGeometriaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getGeometriaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria loadGeometriaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadGeometriaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria getGeometriaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getGeometriaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria loadGeometriaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Geometria) session.load(coedil99.model.Geometria.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria getGeometriaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Geometria) session.get(coedil99.model.Geometria.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria loadGeometriaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Geometria) session.load(coedil99.model.Geometria.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria getGeometriaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Geometria) session.get(coedil99.model.Geometria.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria[] listGeometriaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listGeometriaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria[] listGeometriaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listGeometriaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria[] listGeometriaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.Geometria as Geometria");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Geometria[]) list.toArray(new Geometria[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria[] listGeometriaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.Geometria as Geometria");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Geometria[]) list.toArray(new Geometria[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria loadGeometriaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadGeometriaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria loadGeometriaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadGeometriaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Geometria loadGeometriaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Geometria[] geometrias = listGeometriaByQuery(session, condition, orderBy);
		if (geometrias != null && geometrias.length > 0)
			return geometrias[0];
		else
			return null;
	}
	
	public static Geometria loadGeometriaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Geometria[] geometrias = listGeometriaByQuery(session, condition, orderBy, lockMode);
		if (geometrias != null && geometrias.length > 0)
			return geometrias[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateGeometriaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateGeometriaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGeometriaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateGeometriaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGeometriaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.Geometria as Geometria");
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
	
	public static java.util.Iterator iterateGeometriaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.Geometria as Geometria");
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
	
	public static Geometria createGeometria() {
		return new coedil99.model.Geometria();
	}
	
	public static Geometria loadGeometriaByCriteria(GeometriaCriteria geometriaCriteria) {
		Geometria[] geometrias = listGeometriaByCriteria(geometriaCriteria);
		if(geometrias == null || geometrias.length == 0) {
			return null;
		}
		return geometrias[0];
	}
	
	public static Geometria[] listGeometriaByCriteria(GeometriaCriteria geometriaCriteria) {
		return geometriaCriteria.listGeometria();
	}
}
