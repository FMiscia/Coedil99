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

public class ItemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final FloatExpression prezzo;
	
	public ItemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		descrizione = new StringExpression("descrizione", this);
		prezzo = new FloatExpression("prezzo", this);
	}
	
	public ItemCriteria(PersistentSession session) {
		this(session.createCriteria(Item.class));
	}
	
	public ItemCriteria() throws PersistentException {
		this(elaboradistinta.model.CoedilPersistentManager.instance().getSession());
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

