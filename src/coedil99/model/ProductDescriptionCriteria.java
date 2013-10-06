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

public class ProductDescriptionCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression essenza;
	public final FloatExpression prezzo;
	public final IntegerExpression pezzi_per_pacco;
	
	public ProductDescriptionCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		essenza = new StringExpression("essenza", this);
		prezzo = new FloatExpression("prezzo", this);
		pezzi_per_pacco = new IntegerExpression("pezzi_per_pacco", this);
	}
	
	public ProductDescriptionCriteria(PersistentSession session) {
		this(session.createCriteria(ProductDescription.class));
	}
	
	public ProductDescriptionCriteria() throws PersistentException {
		this(coedil99.model.Coedil99ingdelsoftwarePersistentManager.instance().getSession());
	}
	
	public GeometriaCriteria createGeometriaCriteria() {
		return new GeometriaCriteria(createCriteria("geometria"));
	}
	
	public CatalogoFornitoreCriteria createCatalogoFornitoreCriteria() {
		return new CatalogoFornitoreCriteria(createCriteria("catalogoFornitore"));
	}
	
	public ProductDescription uniqueProductDescription() {
		return (ProductDescription) super.uniqueResult();
	}
	
	public ProductDescription[] listProductDescription() {
		java.util.List list = super.list();
		return (ProductDescription[]) list.toArray(new ProductDescription[list.size()]);
	}
}

