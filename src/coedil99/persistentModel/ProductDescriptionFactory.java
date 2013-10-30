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

public class ProductDescriptionFactory {
	public static ProductDescription loadProductDescriptionByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadProductDescriptionByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription getProductDescriptionByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getProductDescriptionByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription loadProductDescriptionByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadProductDescriptionByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription getProductDescriptionByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getProductDescriptionByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription loadProductDescriptionByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ProductDescription) session.load(coedil99.persistentModel.ProductDescription.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription getProductDescriptionByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ProductDescription) session.get(coedil99.persistentModel.ProductDescription.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription loadProductDescriptionByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ProductDescription) session.load(coedil99.persistentModel.ProductDescription.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription getProductDescriptionByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ProductDescription) session.get(coedil99.persistentModel.ProductDescription.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription[] listProductDescriptionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listProductDescriptionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription[] listProductDescriptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listProductDescriptionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription[] listProductDescriptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.ProductDescription as ProductDescription");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (ProductDescription[]) list.toArray(new ProductDescription[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription[] listProductDescriptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.ProductDescription as ProductDescription");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (ProductDescription[]) list.toArray(new ProductDescription[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription loadProductDescriptionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadProductDescriptionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription loadProductDescriptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadProductDescriptionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ProductDescription loadProductDescriptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ProductDescription[] productDescriptions = listProductDescriptionByQuery(session, condition, orderBy);
		if (productDescriptions != null && productDescriptions.length > 0)
			return productDescriptions[0];
		else
			return null;
	}
	
	public static ProductDescription loadProductDescriptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ProductDescription[] productDescriptions = listProductDescriptionByQuery(session, condition, orderBy, lockMode);
		if (productDescriptions != null && productDescriptions.length > 0)
			return productDescriptions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProductDescriptionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateProductDescriptionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductDescriptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateProductDescriptionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProductDescriptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.ProductDescription as ProductDescription");
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
	
	public static java.util.Iterator iterateProductDescriptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.model.ProductDescription as ProductDescription");
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
	
	public static ProductDescription createProductDescription() {
		return new coedil99.persistentModel.ProductDescription();
	}
	
	public static ProductDescription loadProductDescriptionByCriteria(ProductDescriptionCriteria productDescriptionCriteria) {
		ProductDescription[] productDescriptions = listProductDescriptionByCriteria(productDescriptionCriteria);
		if(productDescriptions == null || productDescriptions.length == 0) {
			return null;
		}
		return productDescriptions[0];
	}
	
	public static ProductDescription[] listProductDescriptionByCriteria(ProductDescriptionCriteria productDescriptionCriteria) {
		return productDescriptionCriteria.listProductDescription();
	}
}
