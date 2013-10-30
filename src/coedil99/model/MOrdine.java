package coedil99.model;

import coedil99.persistentModel.Commessa;
import coedil99.persistentModel.IPersistentModel;
import coedil99.persistentModel.Ordine;

public class MOrdine implements IModel{

	private Ordine ordine;

	public MOrdine(Ordine o) {
		this.ordine = o;
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
	public IPersistentModel getModel() {
		return ordine;
	}

	@Override
	public void setModel(IPersistentModel m) {
		// TODO Auto-generated method stub
		
	}

}