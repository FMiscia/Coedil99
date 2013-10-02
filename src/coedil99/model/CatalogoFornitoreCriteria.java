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
import org.orm.criteria.*;

public class CatalogoFornitoreCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public CatalogoFornitoreCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public CatalogoFornitoreCriteria(PersistentSession session) {
		this(session.createCriteria(CatalogoFornitore.class));
	}
	
	public CatalogoFornitoreCriteria() throws PersistentException {
		this(coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession());
	}
	
	public coedil99.model.ProductDescriptionCriteria createProductDescriptionCriteria() {
		return new coedil99.model.ProductDescriptionCriteria(createCriteria("ORM_ProductDescription"));
	}
	
	public CatalogoFornitore uniqueCatalogoFornitore() {
		return (CatalogoFornitore) super.uniqueResult();
	}
	
	public CatalogoFornitore[] listCatalogoFornitore() {
		java.util.List list = super.list();
		return (CatalogoFornitore[]) list.toArray(new CatalogoFornitore[list.size()]);
	}
}
