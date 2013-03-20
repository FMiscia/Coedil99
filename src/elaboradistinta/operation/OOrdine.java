package elaboradistinta.operation;

import elaboradistinta.model.Commessa;
import elaboradistinta.model.Ordine;

public class OOrdine {
	
	private Ordine ordine;

	public OOrdine(Ordine o) {
		this.ordine = o;
	}
	
	public Ordine getOrdine() {
		return ordine;
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

}
