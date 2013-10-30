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

public class CatalogoFornitoreDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	
	public CatalogoFornitoreDetachedCriteria() {
		super(coedil99.persistentModel.CatalogoFornitore.class, coedil99.persistentModel.CatalogoFornitoreCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public CatalogoFornitoreDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.persistentModel.CatalogoFornitoreCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}
	
	public ProductDescriptionDetachedCriteria createProductDescriptionCriteria() {
		return new ProductDescriptionDetachedCriteria(createCriteria("ORM_ProductDescription"));
	}
	
	public CatalogoFornitore uniqueCatalogoFornitore(PersistentSession session) {
		return (CatalogoFornitore) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public CatalogoFornitore[] listCatalogoFornitore(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (CatalogoFornitore[]) list.toArray(new CatalogoFornitore[list.size()]);
	}
}

