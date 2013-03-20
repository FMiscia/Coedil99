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

public class RigaLavoroDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression capitello;
	public final StringExpression profiloCapitello;
	public final StringExpression note;
	public final IntegerExpression numero;
	
	public RigaLavoroDetachedCriteria() {
		super(elaboradistinta.model.RigaLavoro.class, elaboradistinta.model.RigaLavoroCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		capitello = new BooleanExpression("capitello", this.getDetachedCriteria());
		profiloCapitello = new StringExpression("profiloCapitello", this.getDetachedCriteria());
		note = new StringExpression("note", this.getDetachedCriteria());
		numero = new IntegerExpression("numero", this.getDetachedCriteria());
	}
	
	public RigaLavoroDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, elaboradistinta.model.RigaLavoroCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		capitello = new BooleanExpression("capitello", this.getDetachedCriteria());
		profiloCapitello = new StringExpression("profiloCapitello", this.getDetachedCriteria());
		note = new StringExpression("note", this.getDetachedCriteria());
		numero = new IntegerExpression("numero", this.getDetachedCriteria());
	}
	
	public elaboradistinta.model.GeometriaDetachedCriteria createGeometriaCriteria() {
		return new elaboradistinta.model.GeometriaDetachedCriteria(createCriteria("geometria"));
	}
	
	public RigaLavoro uniqueRigaLavoro(PersistentSession session) {
		return (RigaLavoro) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RigaLavoro[] listRigaLavoro(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RigaLavoro[]) list.toArray(new RigaLavoro[list.size()]);
	}
}

