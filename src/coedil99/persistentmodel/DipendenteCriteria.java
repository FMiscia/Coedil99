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
import org.orm.criteria.*;

public class DipendenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression username;
	public final StringExpression pwd;
	public final IntegerExpression level;
	
	public DipendenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		username = new StringExpression("username", this);
		pwd = new StringExpression("pwd", this);
		level = new IntegerExpression("level", this);
	}
	
	public DipendenteCriteria(PersistentSession session) {
		this(session.createCriteria(Dipendente.class));
	}
	
	public DipendenteCriteria() throws PersistentException {
		this(coedil99.persistentmodel.Coedil99ingdelsoftwarePersistentManager.instance().getSession());
	}
	
	public Dipendente uniqueDipendente() {
		return (Dipendente) super.uniqueResult();
	}
	
	public Dipendente[] listDipendente() {
		java.util.List list = super.list();
		return (Dipendente[]) list.toArray(new Dipendente[list.size()]);
	}
}

