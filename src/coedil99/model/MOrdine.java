package coedil99.model;

import org.orm.PersistentException;

import coedil99.persistentmodel.Commessa;
import coedil99.persistentmodel.IPersistentModel;
import coedil99.persistentmodel.Ordine;
import coedil99.persistentmodel.OrdineFactory;

public class MOrdine implements IModel{

	private Ordine ordine;

	/**
	 * Costruttore senza parametro
	 * 
	 */
	public MOrdine() {
		this.ordine = OrdineFactory.createOrdine();
	}

	/**
	 * Costruttore
	 * @param ID
	 * 
	 */
	public MOrdine(int ID) {
		try {
			this.ordine = OrdineFactory
					.getOrdineByORMID(ID);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	private Boolean isDateNull(){
		return (this.ordine.getDataFine() == null); 
	}
	
	public void addCommessa( Commessa c ){
		this.ordine.commesse.add(c);
		if(this.isDateNull()){
			this.ordine.setDataInizio(c.getEmissioneCommessa());
			this.ordine.setDataScadenza(c.getScadenzaCommessa());
		}else
			this.checkDate(c);
	}
	

	private void checkDate(Commessa c) {
		if(c.getEmissioneCommessa().compareTo(this.ordine.getDataInizio())<0){
			this.ordine.setDataInizio(c.getEmissioneCommessa());
		}
		if(c.getScadenzaCommessa().compareTo(this.ordine.getDataScadenza())>0){
			this.ordine.setDataScadenza(c.getFineCommessa());
		}
		
	}

	@Override
	public void setPersistentModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		this.ordine = (Ordine) m;
	}

	public Ordine getPersistentModel(){
		return this.ordine;
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			this.ordine.save();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		try {
			this.ordine.deleteAndDissociate();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}