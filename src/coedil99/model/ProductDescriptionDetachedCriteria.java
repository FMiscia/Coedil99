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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.IntegerExpression;

public class ProductDescriptionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public ProductDescriptionDetachedCriteria() {
		super(coedil99.model.ProductDescription.class, coedil99.model.ProductDescriptionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ProductDescriptionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.model.ProductDescriptionCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public coedil99.model.CatalogoFornitoreDetachedCriteria createCatalogoFornitoreCriteria() {
		return new coedil99.model.CatalogoFornitoreDetachedCriteria(createCriteria("catalogoFornitore"));
	}
	
	public ProductDescription uniqueProductDescription(PersistentSession session) {
		return (ProductDescription) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ProductDescription[] listProductDescription(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ProductDescription[]) list.toArray(new ProductDescription[list.size()]);
	}
}

