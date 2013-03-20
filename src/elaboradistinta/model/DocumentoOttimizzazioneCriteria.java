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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DocumentoOttimizzazioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public DocumentoOttimizzazioneCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public DocumentoOttimizzazioneCriteria(PersistentSession session) {
		this(session.createCriteria(DocumentoOttimizzazione.class));
	}
	
	public DocumentoOttimizzazioneCriteria() throws PersistentException {
		this(elaboradistinta.model.CoedilPersistentManager.instance().getSession());
	}
	
	public elaboradistinta.model.ItemCriteria createItemsCriteria() {
		return new elaboradistinta.model.ItemCriteria(createCriteria("ORM_Items"));
	}
	
	public DocumentoOttimizzazione uniqueDocumentoOttimizzazione() {
		return (DocumentoOttimizzazione) super.uniqueResult();
	}
	
	public DocumentoOttimizzazione[] listDocumentoOttimizzazione() {
		java.util.List list = super.list();
		return (DocumentoOttimizzazione[]) list.toArray(new DocumentoOttimizzazione[list.size()]);
	}
}

