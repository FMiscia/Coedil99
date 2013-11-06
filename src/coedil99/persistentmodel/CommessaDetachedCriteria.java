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
import org.orm.criteria.DateExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

public class CommessaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression codiceInterno;
	public final StringExpression elementoStrutturale;
	public final DateExpression scadenzaCommessa;
	public final DateExpression emissioneCommessa;
	public final DateExpression fineCommessa;
	public final DateExpression inizioProduzione;
	public final DateExpression scadenzaProduzione;
	public final DateExpression fineProduzione;
	public final IntegerExpression ritardoProduzione;
	public final DateExpression primaConsegna;
	public final IntegerExpression ritardoConsegna;
	public final StringExpression orario;
	public final StringExpression descrizione;
	public final StringExpression responsabile;
	
	public CommessaDetachedCriteria() {
		super(coedil99.persistentmodel.Commessa.class, coedil99.persistentmodel.CommessaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		codiceInterno = new StringExpression("codiceInterno", this.getDetachedCriteria());
		elementoStrutturale = new StringExpression("elementoStrutturale", this.getDetachedCriteria());
		scadenzaCommessa = new DateExpression("scadenzaCommessa", this.getDetachedCriteria());
		emissioneCommessa = new DateExpression("emissioneCommessa", this.getDetachedCriteria());
		fineCommessa = new DateExpression("fineCommessa", this.getDetachedCriteria());
		inizioProduzione = new DateExpression("inizioProduzione", this.getDetachedCriteria());
		scadenzaProduzione = new DateExpression("scadenzaProduzione", this.getDetachedCriteria());
		fineProduzione = new DateExpression("fineProduzione", this.getDetachedCriteria());
		ritardoProduzione = new IntegerExpression("ritardoProduzione", this.getDetachedCriteria());
		primaConsegna = new DateExpression("primaConsegna", this.getDetachedCriteria());
		ritardoConsegna = new IntegerExpression("ritardoConsegna", this.getDetachedCriteria());
		orario = new StringExpression("orario", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		responsabile = new StringExpression("responsabile", this.getDetachedCriteria());
	}
	
	public CommessaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.persistentmodel.CommessaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		codiceInterno = new StringExpression("codiceInterno", this.getDetachedCriteria());
		elementoStrutturale = new StringExpression("elementoStrutturale", this.getDetachedCriteria());
		scadenzaCommessa = new DateExpression("scadenzaCommessa", this.getDetachedCriteria());
		emissioneCommessa = new DateExpression("emissioneCommessa", this.getDetachedCriteria());
		fineCommessa = new DateExpression("fineCommessa", this.getDetachedCriteria());
		inizioProduzione = new DateExpression("inizioProduzione", this.getDetachedCriteria());
		scadenzaProduzione = new DateExpression("scadenzaProduzione", this.getDetachedCriteria());
		fineProduzione = new DateExpression("fineProduzione", this.getDetachedCriteria());
		ritardoProduzione = new IntegerExpression("ritardoProduzione", this.getDetachedCriteria());
		primaConsegna = new DateExpression("primaConsegna", this.getDetachedCriteria());
		ritardoConsegna = new IntegerExpression("ritardoConsegna", this.getDetachedCriteria());
		orario = new StringExpression("orario", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		responsabile = new StringExpression("responsabile", this.getDetachedCriteria());
	}
	
	public DistintaDetachedCriteria createDistintaCriteria() {
		return new DistintaDetachedCriteria(createCriteria("distinta"));
	}
	
	public ListaRintracciabilitaDetachedCriteria createLdrCriteria() {
		return new ListaRintracciabilitaDetachedCriteria(createCriteria("ldr"));
	}
	
	public OrdineDetachedCriteria createOrdineCriteria() {
		return new OrdineDetachedCriteria(createCriteria("ordine"));
	}
	
	public Commessa uniqueCommessa(PersistentSession session) {
		return (Commessa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Commessa[] listCommessa(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Commessa[]) list.toArray(new Commessa[list.size()]);
	}
}

