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
import org.orm.criteria.*;

public class GeometriaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final FloatExpression base;
	public final FloatExpression altezza;
	public final FloatExpression lunghezza;
	
	public GeometriaDetachedCriteria() {
		super(coedil99.model.Geometria.class, coedil99.model.GeometriaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		base = new FloatExpression("base", this.getDetachedCriteria());
		altezza = new FloatExpression("altezza", this.getDetachedCriteria());
		lunghezza = new FloatExpression("lunghezza", this.getDetachedCriteria());
	}
	
	public GeometriaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.model.GeometriaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		base = new FloatExpression("base", this.getDetachedCriteria());
		altezza = new FloatExpression("altezza", this.getDetachedCriteria());
		lunghezza = new FloatExpression("lunghezza", this.getDetachedCriteria());
	}
	
	public Geometria uniqueGeometria(PersistentSession session) {
		return (Geometria) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Geometria[] listGeometria(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Geometria[]) list.toArray(new Geometria[list.size()]);
	}
}
