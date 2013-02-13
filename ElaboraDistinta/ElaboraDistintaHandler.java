package ElaboraDistinta;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ElaboraDistintaHandler {

	GestisciMagazzinoHandler cmagazzino;
	IOttimizzatoreStrategy sottimizzatore;
	List<Distinta> distinte;
	ListIterator<Distinta> it;
	GestisciCommessaHandler ccommessa;
	private static ElaboraDistintaHandler instance = null;
	
	private ElaboraDistintaHandler(){
		this.distinte = new ArrayList<Distinta>();
		this.it = this.distinte.listIterator();
		this.ccommessa = GestisciCommessaHandler.getInstance();
	}

	/**
	 * 
	 * @param distinta
	 * @return 
	 */
	public void modificaDistinta(Distinta distinta) {
		while(it.hasNext()){
			if(it.next().getId() == distinta.getId())
				distinte.set(it.previousIndex(), distinta);
				
		}
	}

	/**
	 * 
	 * @param commessa
	 * @return 
	 */
	public void add(Distinta distinta, int idCommessa) {
		this.distinte.add(distinta);
		this.ccommessa.associaDistinta(distinta, idCommessa);
		
	}

	/**
	 * 
	 * @param distinta
	 * @return Boolean
	 */
	public Boolean removeFromList(Distinta distinta) {
		return this.distinte.remove(distinta);
	}
	
	/**
	 * 
	 * @param distinta
	 * @param idCommessa
	 */
	public void removeFromCommessa(Distinta distinta, int idCommessa){
		this.ccommessa.eliminaDistinta(idCommessa);
		this.distinte.remove(distinta);
	}

	/**
	 * 
	 * @return 
	 */
	public void elaboraDDO(int idCommessa) {
		this.sottimizzatore = new StandardOttimizzatoreStrategy();
		this.sottimizzatore.elaboraOttimizzazione(this.ccommessa.getCommessaById(idCommessa).distinta);
	}
	
	/*
	 * Singleton
	 */
	public static ElaboraDistintaHandler getInstance(){
		if (ElaboraDistintaHandler.instance == null)
			ElaboraDistintaHandler.instance = new ElaboraDistintaHandler();
		
		return instance;
	}
	
	

}