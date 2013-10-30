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
package coedil99.persistentModel;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RDADetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression state;
	public final DateExpression date;
	
	public RDADetachedCriteria() {
		super(coedil99.persistentModel.RDA.class, coedil99.persistentModel.RDACriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		date = new DateExpression("date", this.getDetachedCriteria());
	}
	
	public RDADetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.persistentModel.RDACriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		date = new DateExpression("date", this.getDetachedCriteria());
	}
	
	public RigaRDADetachedCriteria createRigheRDACriteria() {
		return new RigaRDADetachedCriteria(createCriteria("ORM_RigheRDA"));
	}
	
	public RDA uniqueRDA(PersistentSession session) {
		return (RDA) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RDA[] listRDA(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RDA[]) list.toArray(new RDA[list.size()]);
	}
}

