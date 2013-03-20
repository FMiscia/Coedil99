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

public class DistintaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public DistintaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public DistintaCriteria(PersistentSession session) {
		this(session.createCriteria(Distinta.class));
	}
	
	public DistintaCriteria() throws PersistentException {
		this(elaboradistinta.model.CoedilPersistentManager.instance().getSession());
	}
	
	public DocumentoOttimizzazioneCriteria createDdoCriteria() {
		return new DocumentoOttimizzazioneCriteria(createCriteria("ddo"));
	}
	
	public RigheLavoroCriteria createLavoriCriteria() {
		return new RigheLavoroCriteria(createCriteria("lavori"));
	}
	
	public Distinta uniqueDistinta() {
		return (Distinta) super.uniqueResult();
	}
	
	public Distinta[] listDistinta() {
		java.util.List list = super.list();
		return (Distinta[]) list.toArray(new Distinta[list.size()]);
	}
}

