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
package coedil99.model;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.IntegerExpression;

public class DistintaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public DistintaDetachedCriteria() {
		super(coedil99.model.Distinta.class, coedil99.model.DistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public DistintaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.model.DistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public DocumentoOttimizzazioneDetachedCriteria createDdoCriteria() {
		return new DocumentoOttimizzazioneDetachedCriteria(createCriteria("ddo"));
	}
	
	public RigaLavoroDetachedCriteria createLavoriCriteria() {
		return new RigaLavoroDetachedCriteria(createCriteria("ORM_Lavori"));
	}
	
	public Distinta uniqueDistinta(PersistentSession session) {
		return (Distinta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Distinta[] listDistinta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Distinta[]) list.toArray(new Distinta[list.size()]);
	}
}

