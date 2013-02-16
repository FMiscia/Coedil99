package ElaboraDistinta;

import java.util.ArrayList;
import java.util.Iterator;

public class StandardOttimizzatoreStrategy implements IOttimizzatoreStrategy {

	public StandardOttimizzatoreStrategy() {
	}

	@Override
	public DocumentoOttimizzazione elaboraOttimizzazione(Distinta distinta) {

		ArrayList<Geometria> distitems = new ArrayList<Geometria>();
		ArrayList<Item> itemMag = new ArrayList<Item>();
		ArrayList<Item> sfridi = new ArrayList<Item>();
		Magazzino m = new Magazzino();
		ArrayList<Item> itm = new ArrayList<Item>(m.getItems().keySet());
		
		
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
					distitems.remove(j);
					// pseudo meno uno sul magazzino
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
					distitems.remove(j);
					sfridi.add(new Item(new Geometria(itm.get(i).getGeometria()
							.getAltezza(), itm.get(i).getGeometria().getBase(),
							offset), itm.get(i).getDescrizione()));
							// pseudo meno uno sul magazzino
				} /*else if ((equal(itm.get(i).getGeometria().getBase(),
						distitems.get(j).getBase(), itm.get(i).getGeometria()
								.getAltezza(), distitems.get(j).getAltezza()))) {
					offset = itm.get(i).getGeometria().getLunghezza()
							- distitems.get(j).getLunghezza();
					itemMag.add(itm.get(i));
					sfridi.add(new Item(new Geometria(itm.get(i).getGeometria()
							.getAltezza(), itm.get(i).getGeometria().getBase(),
							offset), itm.get(i).getDescrizione()));
					distitems.remove(j);
				}*/
			}

		}
	

		return new DocumentoOttimizzazione(itemMag);
	}

	public Boolean equal(float a, float b, float c, float e) {
		return (a == b && c == e);
	}

}