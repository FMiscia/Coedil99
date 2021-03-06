package ElaboraDistinta;

import java.util.ArrayList;
import java.util.Iterator;

import ElaboraDistinta.Model.Distinta;
import ElaboraDistinta.Model.DocumentoOttimizzazione;
import ElaboraDistinta.Model.Geometria;
import ElaboraDistinta.Model.Item;
import ElaboraDistinta.Model.Magazzino;
import ElaboraDistinta.Model.RigaLavoro;
import ElaboraDistinta.Operation.OMagazzino;



public class StandardOttimizzatoreStrategy extends AOttimizzatoreStrategy {

	public StandardOttimizzatoreStrategy() {
	}

	@Override
	public DocumentoOttimizzazione elaboraOttimizzazione(Distinta distinta) {

		ArrayList<Geometria> distitems = new ArrayList<Geometria>();
		ArrayList<Item> itemMag = new ArrayList<Item>();
		ArrayList<Item> sfridi = new ArrayList<Item>();
		OMagazzino m = new OMagazzino(new Magazzino());
		ArrayList<Item> itm = new ArrayList<Item>(m.getMagazzino().getItems().keySet());
		
		
		float offset;
		Iterator<RigaLavoro> it = distinta.getRigheLavoro().iterator();
		while (it.hasNext()) {
			distitems.add(it.next().getGeometria());
		}

		for (int i = 0; i < itm.size(); i++) {
			for (int j = 0; j < distitems.size(); j++) {
				if ((equal(itm.get(i).getGeometria().getBase(), distitems
						.get(j).getBase(), itm.get(i).getGeometria()
						.getAltezza(), distitems.get(j).getAltezza()))
						&& ((itm.get(i).getGeometria().getLunghezza()
								- distitems.get(j).getLunghezza()) <= 100)) {
					itemMag.add(itm.get(i));
					m.removeItem(itm.get(i));
					distitems.remove(j);
				}

			}
		}
		for (int i = 0; i < itm.size(); i++) {
			for (int j = 0; j < distitems.size(); j++) {
				if ((equal(itm.get(i).getGeometria().getBase(), distitems
						.get(j).getBase(), itm.get(i).getGeometria()
						.getAltezza(), distitems.get(j).getAltezza()))
						&& ((offset = itm.get(i).getGeometria().getLunghezza()
								- distitems.get(j).getLunghezza()) <= 200)) {
					itemMag.add(itm.get(i));
					m.removeItem(itm.get(i));
					distitems.remove(j);
					m.addItem(new Item(new Geometria(itm.get(i).getGeometria()
							.getAltezza(), itm.get(i).getGeometria().getBase(),
							offset), itm.get(i).getDescrizione()));
				}
			}

		}
		
	

		return new DocumentoOttimizzazione(itemMag);
	}

	public Boolean equal(float a, float b, float c, float e) {
		return (a == b && c == e);
	}

}