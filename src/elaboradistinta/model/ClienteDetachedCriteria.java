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

public class ClienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final IntegerExpression numeroCommessaCliente;
	
	public ClienteDetachedCriteria() {
		super(elaboradistinta.model.Cliente.class, elaboradistinta.model.ClienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		numeroCommessaCliente = new IntegerExpression("numeroCommessaCliente", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, elaboradistinta.model.ClienteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		numeroCommessaCliente = new IntegerExpression("numeroCommessaCliente", this.getDetachedCriteria());
	}
	
	public elaboradistinta.model.CantiereDetachedCriteria createCantiereCriteria() {
		return new elaboradistinta.model.CantiereDetachedCriteria(createCriteria("cantiere"));
	}
	
	public elaboradistinta.model.OrdineDetachedCriteria createOrdiniCriteria() {
		return new elaboradistinta.model.OrdineDetachedCriteria(createCriteria("ORM_Ordini"));
	}
	
	public Cliente uniqueCliente(PersistentSession session) {
		return (Cliente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cliente[] listCliente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cliente[]) list.toArray(new Cliente[list.size()]);
	}
}

