package ElaboraDistinta;

import java.util.List;

public class GestisciMagazzinoHandler implements ICommessaListener {

	ElaboraDistintaHandler cdistinta;
	Magazzino[] magazzino;

	/**
	 * 
	 * @param items
	 * @return 
	 */
	public void responseQuantity(List<Item> items) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ddo
	 * @return 
	 */
	public void update(DocumentoOttimizzazione ddo) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onPropertyEvent(Commessa commessa, String value) {
		// TODO Auto-generated method stub
		
	}

}