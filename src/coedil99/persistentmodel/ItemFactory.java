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

public class ItemFactory {
	public static Item loadItemByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadItemByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item getItemByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getItemByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item loadItemByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadItemByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item getItemByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return getItemByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item loadItemByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Item) session.load(coedil99.persistentmodel.Item.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item getItemByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Item) session.get(coedil99.persistentmodel.Item.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item loadItemByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Item) session.load(coedil99.persistentmodel.Item.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item getItemByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Item) session.get(coedil99.persistentmodel.Item.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item[] listItemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listItemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item[] listItemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return listItemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item[] listItemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.Item as Item");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Item[]) list.toArray(new Item[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item[] listItemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.Item as Item");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Item[]) list.toArray(new Item[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item loadItemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadItemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item loadItemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return loadItemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Item loadItemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Item[] items = listItemByQuery(session, condition, orderBy);
		if (items != null && items.length > 0)
			return items[0];
		else
			return null;
	}
	
	public static Item loadItemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Item[] items = listItemByQuery(session, condition, orderBy, lockMode);
		if (items != null && items.length > 0)
			return items[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateItemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateItemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateItemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession();
			return iterateItemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateItemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.Item as Item");
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
	
	public static java.util.Iterator iterateItemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From coedil99.persistentmodel.Item as Item");
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
	
	public static Item createItem() {
		return new coedil99.persistentmodel.Item();
	}
	
	public static Item loadItemByCriteria(ItemCriteria itemCriteria) {
		Item[] items = listItemByCriteria(itemCriteria);
		if(items == null || items.length == 0) {
			return null;
		}
		return items[0];
	}
	
	public static Item[] listItemByCriteria(ItemCriteria itemCriteria) {
		return itemCriteria.listItem();
	}
}
