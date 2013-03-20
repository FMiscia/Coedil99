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

public class OrdineDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression ordineGestionale;
	public final DateExpression dataInizio;
	public final DateExpression dataScadenza;
	public final DateExpression dataFine;
	public final IntegerExpression anno;
	public final IntegerExpression numeroOrdine;
	public final StringExpression OC;
	
	public OrdineDetachedCriteria() {
		super(elaboradistinta.model.Ordine.class, elaboradistinta.model.OrdineCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		ordineGestionale = new StringExpression("ordineGestionale", this.getDetachedCriteria());
		dataInizio = new DateExpression("dataInizio", this.getDetachedCriteria());
		dataScadenza = new DateExpression("dataScadenza", this.getDetachedCriteria());
		dataFine = new DateExpression("dataFine", this.getDetachedCriteria());
		anno = new IntegerExpression("anno", this.getDetachedCriteria());
		numeroOrdine = new IntegerExpression("numeroOrdine", this.getDetachedCriteria());
		OC = new StringExpression("OC", this.getDetachedCriteria());
	}
	
	public OrdineDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, elaboradistinta.model.OrdineCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		ordineGestionale = new StringExpression("ordineGestionale", this.getDetachedCriteria());
		dataInizio = new DateExpression("dataInizio", this.getDetachedCriteria());
		dataScadenza = new DateExpression("dataScadenza", this.getDetachedCriteria());
		dataFine = new DateExpression("dataFine", this.getDetachedCriteria());
		anno = new IntegerExpression("anno", this.getDetachedCriteria());
		numeroOrdine = new IntegerExpression("numeroOrdine", this.getDetachedCriteria());
		OC = new StringExpression("OC", this.getDetachedCriteria());
	}
	
	public elaboradistinta.model.CommessaDetachedCriteria createCommesseCriteria() {
		return new elaboradistinta.model.CommessaDetachedCriteria(createCriteria("ORM_Commesse"));
	}
	
	public Ordine uniqueOrdine(PersistentSession session) {
		return (Ordine) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ordine[] listOrdine(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ordine[]) list.toArray(new Ordine[list.size()]);
	}
}

