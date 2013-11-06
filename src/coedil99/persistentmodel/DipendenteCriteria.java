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
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

public class DipendenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression pwd;
	public final StringExpression usr;
	public final IntegerExpression level;
	public final StringExpression name;
	public final StringExpression familyname;
	
	public DipendenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		pwd = new StringExpression("pwd", this);
		usr = new StringExpression("usr", this);
		level = new IntegerExpression("level", this);
		name = new StringExpression("name", this);
		familyname = new StringExpression("familyname", this);
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

