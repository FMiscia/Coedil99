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
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.FloatExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

public class ItemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final FloatExpression prezzo;
	public final StringExpression state;
	
	public ItemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		descrizione = new StringExpression("descrizione", this);
		prezzo = new FloatExpression("prezzo", this);
		state = new StringExpression("state", this);
	}
	
	public ItemCriteria(PersistentSession session) {
		this(session.createCriteria(Item.class));
	}
	
	public ItemCriteria() throws PersistentException {
		this(coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession());
	}
	
	public ProductDescriptionCriteria createProductDescriptionCriteria() {
		return new ProductDescriptionCriteria(createCriteria("productDescription"));
	}
	
	public GeometriaCriteria createGeometriaCriteria() {
		return new GeometriaCriteria(createCriteria("geometria"));
	}
	
	public HistoryCriteria createHistoryCriteria() {
		return new HistoryCriteria(createCriteria("history"));
	}
	
	public Item uniqueItem() {
		return (Item) super.uniqueResult();
	}
	
	public Item[] listItem() {
		java.util.List list = super.list();
		return (Item[]) list.toArray(new Item[list.size()]);
	}
}

