package coedil99.operation;

import coedil99.model.Commessa;
import coedil99.model.IModelComponent;
import coedil99.model.Ordine;

public class OOrdine implements IOperation{

	private Ordine ordine;

	public OOrdine(Ordine o) {
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
	public IModelComponent getModel() {
		return ordine;
	}

	@Override
	public void setModel(IModelComponent m) {
		// TODO Auto-generated method stub
		
	}

}