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
package coedil99.persistentmodel;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RigaRDACriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression quantity;
	
	public RigaRDACriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		quantity = new IntegerExpression("quantity", this);
	}
	
	public RigaRDACriteria(PersistentSession session) {
		this(session.createCriteria(RigaRDA.class));
	}
	
	public RigaRDACriteria() throws PersistentException {
		this(coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession());
	}
	
	public RDACriteria createRDACriteria() {
		return new RDACriteria(createCriteria("RDA"));
	}
	
	public ProductDescriptionCriteria createDescriptionCriteria() {
		return new ProductDescriptionCriteria(createCriteria("description"));
	}
	
	public RigaRDA uniqueRigaRDA() {
		return (RigaRDA) super.uniqueResult();
	}
	
	public RigaRDA[] listRigaRDA() {
		java.util.List list = super.list();
		return (RigaRDA[]) list.toArray(new RigaRDA[list.size()]);
	}
}

