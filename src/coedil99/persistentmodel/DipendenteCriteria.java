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
	public final StringExpression usr;
	public final StringExpression pwd;
	public final IntegerExpression level;
	public final IntegerExpression rdacongelate_visualizzate;
	public final IntegerExpression rdaattesa_visualizzate;
	public final IntegerExpression rdarifiutate_visualizzate;
	public final StringExpression name;
	public final StringExpression familyname;
	
	public DipendenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		usr = new StringExpression("usr", this);
		pwd = new StringExpression("pwd", this);
		level = new IntegerExpression("level", this);
		rdacongelate_visualizzate = new IntegerExpression("rdacongelate_visualizzate", this);
		rdaattesa_visualizzate = new IntegerExpression("rdaattesa_visualizzate", this);
		rdarifiutate_visualizzate = new IntegerExpression("rdarifiutate_visualizzate", this);
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

