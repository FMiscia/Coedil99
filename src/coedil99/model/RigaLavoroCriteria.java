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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.BooleanExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

public class RigaLavoroCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression capitello;
	public final StringExpression profiloCapitello;
	public final StringExpression note;
	public final IntegerExpression numero;
	
	public RigaLavoroCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		capitello = new BooleanExpression("capitello", this);
		profiloCapitello = new StringExpression("profiloCapitello", this);
		note = new StringExpression("note", this);
		numero = new IntegerExpression("numero", this);
	}
	
	public RigaLavoroCriteria(PersistentSession session) {
		this(session.createCriteria(RigaLavoro.class));
	}
	
	public RigaLavoroCriteria() throws PersistentException {
		this(coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession());
	}
	
	public GeometriaCriteria createGeometriaCriteria() {
		return new GeometriaCriteria(createCriteria("geometria"));
	}
	
	public RigaLavoro uniqueRigaLavoro() {
		return (RigaLavoro) super.uniqueResult();
	}
	
	public RigaLavoro[] listRigaLavoro() {
		java.util.List list = super.list();
		return (RigaLavoro[]) list.toArray(new RigaLavoro[list.size()]);
	}
}

