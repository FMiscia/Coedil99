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

public class RigheLavoroDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public RigheLavoroDetachedCriteria() {
		super(elaboradistinta.model.RigheLavoro.class, elaboradistinta.model.RigheLavoroCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public RigheLavoroDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, elaboradistinta.model.RigheLavoroCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public elaboradistinta.model.RigaLavoroDetachedCriteria createRigheCriteria() {
		return new elaboradistinta.model.RigaLavoroDetachedCriteria(createCriteria("ORM_Righe"));
	}
	
	public RigheLavoro uniqueRigheLavoro(PersistentSession session) {
		return (RigheLavoro) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RigheLavoro[] listRigheLavoro(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RigheLavoro[]) list.toArray(new RigheLavoro[list.size()]);
	}
}

