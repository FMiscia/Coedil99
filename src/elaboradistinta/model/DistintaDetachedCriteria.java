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

public class DistintaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public DistintaDetachedCriteria() {
		super(elaboradistinta.model.Distinta.class, elaboradistinta.model.DistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public DistintaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, elaboradistinta.model.DistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public elaboradistinta.model.DocumentoOttimizzazioneDetachedCriteria createDdoCriteria() {
		return new elaboradistinta.model.DocumentoOttimizzazioneDetachedCriteria(createCriteria("ddo"));
	}
	
	public elaboradistinta.model.RigheLavoroDetachedCriteria createLavoriCriteria() {
		return new elaboradistinta.model.RigheLavoroDetachedCriteria(createCriteria("lavori"));
	}
	
	public Distinta uniqueDistinta(PersistentSession session) {
		return (Distinta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Distinta[] listDistinta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Distinta[]) list.toArray(new Distinta[list.size()]);
	}
}

