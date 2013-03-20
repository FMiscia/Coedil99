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

public class RigheLavoroCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public RigheLavoroCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public RigheLavoroCriteria(PersistentSession session) {
		this(session.createCriteria(RigheLavoro.class));
	}
	
	public RigheLavoroCriteria() throws PersistentException {
		this(elaboradistinta.model.CoedilPersistentManager.instance().getSession());
	}
	
	public elaboradistinta.model.RigaLavoroCriteria createRigheCriteria() {
		return new elaboradistinta.model.RigaLavoroCriteria(createCriteria("ORM_Righe"));
	}
	
	public RigheLavoro uniqueRigheLavoro() {
		return (RigheLavoro) super.uniqueResult();
	}
	
	public RigheLavoro[] listRigheLavoro() {
		java.util.List list = super.list();
		return (RigheLavoro[]) list.toArray(new RigheLavoro[list.size()]);
	}
}

