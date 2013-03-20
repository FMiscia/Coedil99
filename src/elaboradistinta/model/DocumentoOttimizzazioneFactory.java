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

public class DocumentoOttimizzazioneFactory {
	public static DocumentoOttimizzazione loadDocumentoOttimizzazioneByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadDocumentoOttimizzazioneByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione getDocumentoOttimizzazioneByORMID(int ID) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getDocumentoOttimizzazioneByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione loadDocumentoOttimizzazioneByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadDocumentoOttimizzazioneByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione getDocumentoOttimizzazioneByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return getDocumentoOttimizzazioneByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione loadDocumentoOttimizzazioneByORMID(PersistentSession session, int ID) {
		try {
			return (DocumentoOttimizzazione) session.load(elaboradistinta.model.DocumentoOttimizzazione.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione getDocumentoOttimizzazioneByORMID(PersistentSession session, int ID) {
		try {
			return (DocumentoOttimizzazione) session.get(elaboradistinta.model.DocumentoOttimizzazione.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione loadDocumentoOttimizzazioneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (DocumentoOttimizzazione) session.load(elaboradistinta.model.DocumentoOttimizzazione.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione getDocumentoOttimizzazioneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (DocumentoOttimizzazione) session.get(elaboradistinta.model.DocumentoOttimizzazione.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione[] listDocumentoOttimizzazioneByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listDocumentoOttimizzazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione[] listDocumentoOttimizzazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return listDocumentoOttimizzazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione[] listDocumentoOttimizzazioneByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.DocumentoOttimizzazione as DocumentoOttimizzazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (DocumentoOttimizzazione[]) list.toArray(new DocumentoOttimizzazione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione[] listDocumentoOttimizzazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.DocumentoOttimizzazione as DocumentoOttimizzazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (DocumentoOttimizzazione[]) list.toArray(new DocumentoOttimizzazione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione loadDocumentoOttimizzazioneByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadDocumentoOttimizzazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione loadDocumentoOttimizzazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return loadDocumentoOttimizzazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DocumentoOttimizzazione loadDocumentoOttimizzazioneByQuery(PersistentSession session, String condition, String orderBy) {
		DocumentoOttimizzazione[] documentoOttimizzaziones = listDocumentoOttimizzazioneByQuery(session, condition, orderBy);
		if (documentoOttimizzaziones != null && documentoOttimizzaziones.length > 0)
			return documentoOttimizzaziones[0];
		else
			return null;
	}
	
	public static DocumentoOttimizzazione loadDocumentoOttimizzazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		DocumentoOttimizzazione[] documentoOttimizzaziones = listDocumentoOttimizzazioneByQuery(session, condition, orderBy, lockMode);
		if (documentoOttimizzaziones != null && documentoOttimizzaziones.length > 0)
			return documentoOttimizzaziones[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDocumentoOttimizzazioneByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateDocumentoOttimizzazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateDocumentoOttimizzazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = elaboradistinta.model.CoedilPersistentManager.instance().getSession();
			return iterateDocumentoOttimizzazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateDocumentoOttimizzazioneByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.DocumentoOttimizzazione as DocumentoOttimizzazione");
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
	
	public static java.util.Iterator iterateDocumentoOttimizzazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From elaboradistinta.model.DocumentoOttimizzazione as DocumentoOttimizzazione");
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
	
	public static DocumentoOttimizzazione createDocumentoOttimizzazione() {
		return new elaboradistinta.model.DocumentoOttimizzazione();
	}
	
	public static DocumentoOttimizzazione loadDocumentoOttimizzazioneByCriteria(DocumentoOttimizzazioneCriteria documentoOttimizzazioneCriteria) {
		DocumentoOttimizzazione[] documentoOttimizzaziones = listDocumentoOttimizzazioneByCriteria(documentoOttimizzazioneCriteria);
		if(documentoOttimizzaziones == null || documentoOttimizzaziones.length == 0) {
			return null;
		}
		return documentoOttimizzaziones[0];
	}
	
	public static DocumentoOttimizzazione[] listDocumentoOttimizzazioneByCriteria(DocumentoOttimizzazioneCriteria documentoOttimizzazioneCriteria) {
		return documentoOttimizzazioneCriteria.listDocumentoOttimizzazione();
	}
}
