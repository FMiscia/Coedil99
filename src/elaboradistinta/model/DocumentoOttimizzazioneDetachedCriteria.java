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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DocumentoOttimizzazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public DocumentoOttimizzazioneDetachedCriteria() {
		super(elaboradistinta.model.DocumentoOttimizzazione.class, elaboradistinta.model.DocumentoOttimizzazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public DocumentoOttimizzazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, elaboradistinta.model.DocumentoOttimizzazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public elaboradistinta.model.ItemDetachedCriteria createItemsCriteria() {
		return new elaboradistinta.model.ItemDetachedCriteria(createCriteria("ORM_Items"));
	}
	
	public DocumentoOttimizzazione uniqueDocumentoOttimizzazione(PersistentSession session) {
		return (DocumentoOttimizzazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public DocumentoOttimizzazione[] listDocumentoOttimizzazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (DocumentoOttimizzazione[]) list.toArray(new DocumentoOttimizzazione[list.size()]);
	}
}

