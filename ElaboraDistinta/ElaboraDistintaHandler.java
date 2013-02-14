package ElaboraDistinta;

import java.util.ArrayList;
import java.util.ListIterator;

public class ElaboraDistintaHandler {

	GestisciMagazzinoHandler cmagazzino;
	IOttimizzatoreStrategy sottimizzatore;
	ArrayList<Distinta> distinte;
	private static ElaboraDistintaHandler instance;
	
	private ElaboraDistintaHandler(){
		this.distinte = new ArrayList<Distinta>();
	}

	/**
	 * 
	 * @param distinta
	 * @return 
	 */
	public void modificaDistinta(Distinta distinta) {
		ListIterator<Distinta> it = this.distinte.listIterator();
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
		GestisciCommessaHandler c = GestisciCommessaHandler.getInstance();
		c.getCommessaById(idCommessa).setDistinta(distinta);
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
		GestisciCommessaHandler.getInstance().eliminaDistinta(idCommessa);
		this.distinte.remove(distinta);
	}

	/**
	 * 
	 * @return 
	 */
	public void elaboraDDO(int idCommessa) {
		this.sottimizzatore = new StandardOttimizzatoreStrategy();
		this.sottimizzatore.elaboraOttimizzazione(GestisciCommessaHandler.getInstance().getCommessaById(idCommessa).distinta);
	}
	
	/*
	 * Singleton
	 */
	public static ElaboraDistintaHandler getInstance(){
		if (ElaboraDistintaHandler.instance == null){
			ElaboraDistintaHandler.instance = new ElaboraDistintaHandler();
		}
		return ElaboraDistintaHandler.instance;
	}
	
	

}