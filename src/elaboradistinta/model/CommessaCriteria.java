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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommessaCriteria extends AbstractORMCriteria {
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
	
	public CommessaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		codiceInterno = new StringExpression("codiceInterno", this);
		elementoStrutturale = new StringExpression("elementoStrutturale", this);
		scadenzaCommessa = new DateExpression("scadenzaCommessa", this);
		emissioneCommessa = new DateExpression("emissioneCommessa", this);
		fineCommessa = new DateExpression("fineCommessa", this);
		inizioProduzione = new DateExpression("inizioProduzione", this);
		scadenzaProduzione = new DateExpression("scadenzaProduzione", this);
		fineProduzione = new DateExpression("fineProduzione", this);
		ritardoProduzione = new IntegerExpression("ritardoProduzione", this);
		primaConsegna = new DateExpression("primaConsegna", this);
		ritardoConsegna = new IntegerExpression("ritardoConsegna", this);
		orario = new StringExpression("orario", this);
		descrizione = new StringExpression("descrizione", this);
		responsabile = new StringExpression("responsabile", this);
	}
	
	public CommessaCriteria(PersistentSession session) {
		this(session.createCriteria(Commessa.class));
	}
	
	public CommessaCriteria() throws PersistentException {
		this(elaboradistinta.model.CoedilPersistentManager.instance().getSession());
	}
	
	public DistintaCriteria createDistintaCriteria() {
		return new DistintaCriteria(createCriteria("distinta"));
	}
	
	public ListaRintracciabilitaCriteria createLdrCriteria() {
		return new ListaRintracciabilitaCriteria(createCriteria("ldr"));
	}
	
	public Commessa uniqueCommessa() {
		return (Commessa) super.uniqueResult();
	}
	
	public Commessa[] listCommessa() {
		java.util.List list = super.list();
		return (Commessa[]) list.toArray(new Commessa[list.size()]);
	}
}

