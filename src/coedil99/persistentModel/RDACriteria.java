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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RDACriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression state;
	public final DateExpression date;
	
	public RDACriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		state = new StringExpression("state", this);
		date = new DateExpression("date", this);
	}
	
	public RDACriteria(PersistentSession session) {
		this(session.createCriteria(RDA.class));
	}
	
	public RDACriteria() throws PersistentException {
		this(coedil99.persistentModel.Coedil99ingdelsoftwarePersistentManager.instance().getSession());
	}
	
	public RigaRDACriteria createRigheRDACriteria() {
		return new RigaRDACriteria(createCriteria("ORM_RigheRDA"));
	}
	
	public RDA uniqueRDA() {
		return (RDA) super.uniqueResult();
	}
	
	public RDA[] listRDA() {
		java.util.List list = super.list();
		return (RDA[]) list.toArray(new RDA[list.size()]);
	}
}

