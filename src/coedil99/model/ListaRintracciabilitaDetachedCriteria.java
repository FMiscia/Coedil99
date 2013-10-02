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

public class ListaRintracciabilitaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public ListaRintracciabilitaDetachedCriteria() {
		super(coedil99.model.ListaRintracciabilita.class, coedil99.model.ListaRintracciabilitaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ListaRintracciabilitaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.model.ListaRintracciabilitaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ListaRintracciabilita uniqueListaRintracciabilita(PersistentSession session) {
		return (ListaRintracciabilita) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ListaRintracciabilita[] listListaRintracciabilita(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ListaRintracciabilita[]) list.toArray(new ListaRintracciabilita[list.size()]);
	}
}

