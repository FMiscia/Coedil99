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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ItemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final FloatExpression prezzo;
	
	public ItemDetachedCriteria() {
		super(elaboradistinta.model.Item.class, elaboradistinta.model.ItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
	}
	
	public ItemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, elaboradistinta.model.ItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
	}
	
	public elaboradistinta.model.GeometriaDetachedCriteria createGeometriaCriteria() {
		return new elaboradistinta.model.GeometriaDetachedCriteria(createCriteria("geometria"));
	}
	
	public elaboradistinta.model.HistoryDetachedCriteria createHistoryCriteria() {
		return new elaboradistinta.model.HistoryDetachedCriteria(createCriteria("history"));
	}
	
	public Item uniqueItem(PersistentSession session) {
		return (Item) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Item[] listItem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Item[]) list.toArray(new Item[list.size()]);
	}
}

