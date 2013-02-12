package ElaboraDistinta;

import java.util.List;

public class ElaboraDistintaHandler {

	GestisciMagazzinoHandler cmagazzino;
	IOttimizzatoreStrategy sottimizzatore;
	List<Distinta> distinta;
	GestisciCommessaHandler ccommessa;
	private static ElaboraDistintaHandler instance = null;
	
	private ElaboraDistintaHandler(){
		
	}

	/**
	 * 
	 * @param distinta
	 * @return 
	 */
	public void modificaDistinta(Distinta distinta) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param commessa
	 * @return 
	 */
	public void creaNuovaDistinta(Commessa commessa) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param distinta
	 * @return 
	 */
	public void eliminaDistinta(Distinta distinta) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	public void elaboraDDO() {
		throw new UnsupportedOperationException();
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