package ElaboraDistinta;

import java.util.ArrayList;
import ElaboraDistinta.Magazzino;

public class GestisciMagazzinoHandler implements ICommessaListener {
	public ElaboraDistintaHandler _cdistinta;
	public ArrayList<Magazzino> _magazzino = new ArrayList<Magazzino>();
	public Magazzino _unnamed_Magazzino_;

	public void responseQuantity(List<Item> aItems) {
		throw new UnsupportedOperationException();
	}

	public void update(DocumentoOttimizzazione aDdo) {
		throw new UnsupportedOperationException();
	}

	public void onPropertyEvent(Commessa aCommessa, String aValue) {
		throw new UnsupportedOperationException();
	}
}