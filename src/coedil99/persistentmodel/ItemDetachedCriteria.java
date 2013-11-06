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
import org.orm.criteria.FloatExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

public class ItemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final FloatExpression prezzo;
	public final StringExpression state;
	
	public ItemDetachedCriteria() {
		super(coedil99.persistentmodel.Item.class, coedil99.persistentmodel.ItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
	}
	
	public ItemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.persistentmodel.ItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
	}
	
	public ProductDescriptionDetachedCriteria createProductDescriptionCriteria() {
		return new ProductDescriptionDetachedCriteria(createCriteria("productDescription"));
	}
	
	public GeometriaDetachedCriteria createGeometriaCriteria() {
		return new GeometriaDetachedCriteria(createCriteria("geometria"));
	}
	
	public HistoryDetachedCriteria createHistoryCriteria() {
		return new HistoryDetachedCriteria(createCriteria("history"));
	}
	
	public Item uniqueItem(PersistentSession session) {
		return (Item) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Item[] listItem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Item[]) list.toArray(new Item[list.size()]);
	}
}

