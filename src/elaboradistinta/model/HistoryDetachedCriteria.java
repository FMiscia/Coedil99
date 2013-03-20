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

public class HistoryDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public HistoryDetachedCriteria() {
		super(elaboradistinta.model.History.class, elaboradistinta.model.HistoryCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public HistoryDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, elaboradistinta.model.HistoryCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public History uniqueHistory(PersistentSession session) {
		return (History) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public History[] listHistory(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (History[]) list.toArray(new History[list.size()]);
	}
}

