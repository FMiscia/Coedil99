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

public class OrdineCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression ordineGestionale;
	public final DateExpression dataInizio;
	public final DateExpression dataScadenza;
	public final DateExpression dataFine;
	public final IntegerExpression anno;
	public final IntegerExpression numeroOrdine;
	public final StringExpression OC;
	
	public OrdineCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		ordineGestionale = new StringExpression("ordineGestionale", this);
		dataInizio = new DateExpression("dataInizio", this);
		dataScadenza = new DateExpression("dataScadenza", this);
		dataFine = new DateExpression("dataFine", this);
		anno = new IntegerExpression("anno", this);
		numeroOrdine = new IntegerExpression("numeroOrdine", this);
		OC = new StringExpression("OC", this);
	}
	
	public OrdineCriteria(PersistentSession session) {
		this(session.createCriteria(Ordine.class));
	}
	
	public OrdineCriteria() throws PersistentException {
		this(elaboradistinta.model.CoedilPersistentManager.instance().getSession());
	}
	
	public elaboradistinta.model.CommessaCriteria createCommesseCriteria() {
		return new elaboradistinta.model.CommessaCriteria(createCriteria("ORM_Commesse"));
	}
	
	public Ordine uniqueOrdine() {
		return (Ordine) super.uniqueResult();
	}
	
	public Ordine[] listOrdine() {
		java.util.List list = super.list();
		return (Ordine[]) list.toArray(new Ordine[list.size()]);
	}
}

