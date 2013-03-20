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

public class CantiereCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression indirizzo;
	
	public CantiereCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		indirizzo = new StringExpression("indirizzo", this);
	}
	
	public CantiereCriteria(PersistentSession session) {
		this(session.createCriteria(Cantiere.class));
	}
	
	public CantiereCriteria() throws PersistentException {
		this(elaboradistinta.model.CoedilPersistentManager.instance().getSession());
	}
	
	public Cantiere uniqueCantiere() {
		return (Cantiere) super.uniqueResult();
	}
	
	public Cantiere[] listCantiere() {
		java.util.List list = super.list();
		return (Cantiere[]) list.toArray(new Cantiere[list.size()]);
	}
}

