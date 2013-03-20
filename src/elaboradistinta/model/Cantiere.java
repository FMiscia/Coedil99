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

public class Cantiere {
	public Cantiere() {
	}
	
	public static Cantiere loadCantiereByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadCantiereByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere getCantiereByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getCantiereByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere loadCantiereByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadCantiereByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere getCantiereByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getCantiereByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere loadCantiereByORMID(PersistentSession session, int ID) {
		try {
			return (Cantiere) session.load(elaboradistinta.model.Cantiere.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere getCantiereByORMID(PersistentSession session, int ID) {
		try {
			return (Cantiere) session.get(elaboradistinta.model.Cantiere.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere loadCantiereByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Cantiere) session.load(elaboradistinta.model.Cantiere.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere getCantiereByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Cantiere) session.get(elaboradistinta.model.Cantiere.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere[] listCantiereByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listCantiereByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere[] listCantiereByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listCantiereByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere[] listCantiereByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Cantiere as Cantiere");
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
			return null;
		}
	}
	
	public static Cantiere[] listCantiereByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Cantiere as Cantiere");
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
			return null;
		}
	}
	
	public static Cantiere loadCantiereByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadCantiereByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere loadCantiereByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadCantiereByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cantiere loadCantiereByQuery(PersistentSession session, String condition, String orderBy) {
		Cantiere[] cantieres = listCantiereByQuery(session, condition, orderBy);
		if (cantieres != null && cantieres.length > 0)
			return cantieres[0];
		else
			return null;
	}
	
	public static Cantiere loadCantiereByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Cantiere[] cantieres = listCantiereByQuery(session, condition, orderBy, lockMode);
		if (cantieres != null && cantieres.length > 0)
			return cantieres[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCantiereByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateCantiereByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateCantiereByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateCantiereByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateCantiereByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Cantiere as Cantiere");
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
	
	public static java.util.Iterator iterateCantiereByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.Cantiere as Cantiere");
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
	
	public static Cantiere createCantiere() {
		return new elaboradistinta.model.Cantiere();
	}
	
	public boolean save() {
		try {
			elaboradistinta.model.CoedilPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete() {
		try {
			elaboradistinta.model.CoedilPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean refresh() {
		try {
			elaboradistinta.model.CoedilPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean evict() {
		try {
			elaboradistinta.model.CoedilPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private int ID;
	
	private String nome;
	
	private String indirizzo;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setIndirizzo(String value) {
		this.indirizzo = value;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public Cantiere(String nome, String indirizzo) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
