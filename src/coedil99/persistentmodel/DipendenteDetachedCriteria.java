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

public class DipendenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression pwd;
	public final StringExpression usr;
	public final IntegerExpression level;
	public final StringExpression name;
	public final StringExpression familyname;
	
	public DipendenteDetachedCriteria() {
		super(coedil99.persistentmodel.Dipendente.class, coedil99.persistentmodel.DipendenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		pwd = new StringExpression("pwd", this.getDetachedCriteria());
		usr = new StringExpression("usr", this.getDetachedCriteria());
		level = new IntegerExpression("level", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		familyname = new StringExpression("familyname", this.getDetachedCriteria());
	}
	
	public DipendenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.persistentmodel.DipendenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		pwd = new StringExpression("pwd", this.getDetachedCriteria());
		usr = new StringExpression("usr", this.getDetachedCriteria());
		level = new IntegerExpression("level", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		familyname = new StringExpression("familyname", this.getDetachedCriteria());
	}
	
	public Dipendente uniqueDipendente(PersistentSession session) {
		return (Dipendente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Dipendente[] listDipendente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Dipendente[]) list.toArray(new Dipendente[list.size()]);
	}
}

