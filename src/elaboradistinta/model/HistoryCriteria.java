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

public class HistoryCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public HistoryCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public HistoryCriteria(PersistentSession session) {
		this(session.createCriteria(History.class));
	}
	
	public HistoryCriteria() throws PersistentException {
		this(elaboradistinta.model.CoedilPersistentManager.instance().getSession());
	}
	
	public History uniqueHistory() {
		return (History) super.uniqueResult();
	}
	
	public History[] listHistory() {
		java.util.List list = super.list();
		return (History[]) list.toArray(new History[list.size()]);
	}
}

