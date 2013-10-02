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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.IntegerExpression;

public class DocumentoOttimizzazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public DocumentoOttimizzazioneDetachedCriteria() {
		super(coedil99.model.DocumentoOttimizzazione.class, coedil99.model.DocumentoOttimizzazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public DocumentoOttimizzazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.model.DocumentoOttimizzazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ItemDetachedCriteria createItemsCriteria() {
		return new ItemDetachedCriteria(createCriteria("ORM_Items"));
	}
	
	public DocumentoOttimizzazione uniqueDocumentoOttimizzazione(PersistentSession session) {
		return (DocumentoOttimizzazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public DocumentoOttimizzazione[] listDocumentoOttimizzazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (DocumentoOttimizzazione[]) list.toArray(new DocumentoOttimizzazione[list.size()]);
	}
}

