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
import org.orm.criteria.*;

public class DipendenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression username;
	public final StringExpression password;
	public final IntegerExpression level;
	
	public DipendenteDetachedCriteria() {
		super(coedil99.persistentmodel.Dipendente.class, coedil99.persistentmodel.DipendenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		level = new IntegerExpression("level", this.getDetachedCriteria());
	}
	
	public DipendenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.persistentmodel.DipendenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		level = new IntegerExpression("level", this.getDetachedCriteria());
	}
	
	public Dipendente uniqueDipendente(PersistentSession session) {
		return (Dipendente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Dipendente[] listDipendente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Dipendente[]) list.toArray(new Dipendente[list.size()]);
	}
}

