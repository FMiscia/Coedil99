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

public class RigaLavoro {
	public RigaLavoro() {
	}
	
	public static RigaLavoro loadRigaLavoroByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadRigaLavoroByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro getRigaLavoroByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getRigaLavoroByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro loadRigaLavoroByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadRigaLavoroByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro getRigaLavoroByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getRigaLavoroByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro loadRigaLavoroByORMID(PersistentSession session, int ID) {
		try {
			return (RigaLavoro) session.load(elaboradistinta.model.RigaLavoro.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro getRigaLavoroByORMID(PersistentSession session, int ID) {
		try {
			return (RigaLavoro) session.get(elaboradistinta.model.RigaLavoro.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro loadRigaLavoroByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (RigaLavoro) session.load(elaboradistinta.model.RigaLavoro.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro getRigaLavoroByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (RigaLavoro) session.get(elaboradistinta.model.RigaLavoro.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro[] listRigaLavoroByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listRigaLavoroByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro[] listRigaLavoroByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listRigaLavoroByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro[] listRigaLavoroByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.RigaLavoro as RigaLavoro");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (RigaLavoro[]) list.toArray(new RigaLavoro[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro[] listRigaLavoroByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.RigaLavoro as RigaLavoro");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (RigaLavoro[]) list.toArray(new RigaLavoro[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro loadRigaLavoroByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadRigaLavoroByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro loadRigaLavoroByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadRigaLavoroByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static RigaLavoro loadRigaLavoroByQuery(PersistentSession session, String condition, String orderBy) {
		RigaLavoro[] rigaLavoros = listRigaLavoroByQuery(session, condition, orderBy);
		if (rigaLavoros != null && rigaLavoros.length > 0)
			return rigaLavoros[0];
		else
			return null;
	}
	
	public static RigaLavoro loadRigaLavoroByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		RigaLavoro[] rigaLavoros = listRigaLavoroByQuery(session, condition, orderBy, lockMode);
		if (rigaLavoros != null && rigaLavoros.length > 0)
			return rigaLavoros[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRigaLavoroByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateRigaLavoroByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateRigaLavoroByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateRigaLavoroByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateRigaLavoroByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.RigaLavoro as RigaLavoro");
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
	
	public static java.util.Iterator iterateRigaLavoroByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.RigaLavoro as RigaLavoro");
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
	
	public static RigaLavoro loadRigaLavoroByCriteria(RigaLavoroCriteria rigaLavoroCriteria) {
		RigaLavoro[] rigaLavoros = listRigaLavoroByCriteria(rigaLavoroCriteria);
		if(rigaLavoros == null || rigaLavoros.length == 0) {
			return null;
		}
		return rigaLavoros[0];
	}
	
	public static RigaLavoro[] listRigaLavoroByCriteria(RigaLavoroCriteria rigaLavoroCriteria) {
		return rigaLavoroCriteria.listRigaLavoro();
	}
	
	public static RigaLavoro createRigaLavoro() {
		return new elaboradistinta.model.RigaLavoro();
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
	
	private void this_setOwner(Object owner, int key) {
		if (key == elaboradistinta.model.ORMConstants.KEY_RIGALAVORO_GEOMETRIA) {
			this.geometria = (elaboradistinta.model.Geometria) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private elaboradistinta.model.Geometria geometria;
	
	private boolean capitello;
	
	private String profiloCapitello;
	
	private String note;
	
	private int numero;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCapitello(boolean value) {
		this.capitello = value;
	}
	
	public boolean getCapitello() {
		return capitello;
	}
	
	public void setProfiloCapitello(String value) {
		this.profiloCapitello = value;
	}
	
	public String getProfiloCapitello() {
		return profiloCapitello;
	}
	
	public void setNote(String value) {
		this.note = value;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNumero(int value) {
		this.numero = value;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setGeometria(elaboradistinta.model.Geometria value) {
		this.geometria = value;
	}
	
	public elaboradistinta.model.Geometria getGeometria() {
		return geometria;
	}
	
	public RigaLavoro(int id, elaboradistinta.model.Geometria g, boolean c, String pc, String note, int n) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
