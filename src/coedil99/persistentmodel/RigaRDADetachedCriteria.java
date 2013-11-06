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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.IntegerExpression;

public class RigaRDADetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression quantity;
	
	public RigaRDADetachedCriteria() {
		super(coedil99.persistentmodel.RigaRDA.class, coedil99.persistentmodel.RigaRDACriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		quantity = new IntegerExpression("quantity", this.getDetachedCriteria());
	}
	
	public RigaRDADetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.persistentmodel.RigaRDACriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		quantity = new IntegerExpression("quantity", this.getDetachedCriteria());
	}
	
	public RDADetachedCriteria createRDACriteria() {
		return new RDADetachedCriteria(createCriteria("RDA"));
	}
	
	public ProductDescriptionDetachedCriteria createDescriptionCriteria() {
		return new ProductDescriptionDetachedCriteria(createCriteria("description"));
	}
	
	public RigaRDA uniqueRigaRDA(PersistentSession session) {
		return (RigaRDA) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RigaRDA[] listRigaRDA(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RigaRDA[]) list.toArray(new RigaRDA[list.size()]);
	}
}

