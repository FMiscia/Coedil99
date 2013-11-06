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
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

public class CantiereDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression indirizzo;
	
	public CantiereDetachedCriteria() {
		super(coedil99.persistentmodel.Cantiere.class, coedil99.persistentmodel.CantiereCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		indirizzo = new StringExpression("indirizzo", this.getDetachedCriteria());
	}
	
	public CantiereDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.persistentmodel.CantiereCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		indirizzo = new StringExpression("indirizzo", this.getDetachedCriteria());
	}
	
	public Cantiere uniqueCantiere(PersistentSession session) {
		return (Cantiere) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cantiere[] listCantiere(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cantiere[]) list.toArray(new Cantiere[list.size()]);
	}
}

