package coedil99.model;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.orm.PersistentException;

import coedil99.persistentmodel.Geometria;
import coedil99.persistentmodel.History;
import coedil99.persistentmodel.HistoryFactory;
import coedil99.persistentmodel.RigaLavoro;

public class MinimizerOttimizzatoreStrategy extends AOttimizzatoreStrategy {

	public MinimizerOttimizzatoreStrategy() {
	}

	@Override
	public MDocumentoOttimizzazione elaboraOttimizzazione(MDistinta distinta) {
		
		// Geometrie presenti nella distinta
		ArrayList<Geometria> distitems = new ArrayList<Geometria>();
		// Item da aggiungere al DDO
		ArrayList<MItem> ddoitem = new ArrayList<MItem>();
		// Residui dei tagli
		ArrayList<MItem> sfridi = new ArrayList<MItem>();
		// Item presenti nel magazzino
		ArrayList<MItem> itm = new ArrayList<MItem>(MMagazzino.getInstance()
				.getItems().keySet());
		// Item da cancellare
		// ArrayList<Item> rem = new ArrayList<Item>();
		
		@SuppressWarnings("unchecked")
		Iterator<RigaLavoro> it = distinta.getPersistentModel().lavori
				.getIterator();
		while (it.hasNext()) {
			distitems.add(it.next().getGeometria());
		}

//		for (int i = 0; i < itm.size(); i++) {
//			for (int j = 0; j < distitems.size(); j++) {
//				if ((equal(itm.get(i).getPersistentModel().getGeometria()
//						.getBase(), distitems.get(j).getBase(), itm.get(i)
//						.getPersistentModel().getGeometria().getAltezza(),
//						distitems.get(j).getAltezza()))
//						&& ((itm.get(i).getPersistentModel().getGeometria()
//								.getLunghezza() - distitems.get(j)
//								.getLunghezza()) <= 100)) {
//					ddoitem.add(itm.get(i));
//					itm.remove(i);
//					distitems.remove(j);
//				}
//			}
//		}
//
//		for (int i = 0; i < itm.size(); i++) {
//			for (int j = 0; j < distitems.size(); j++) {
//				if ((equal(itm.get(i).getPersistentModel().getGeometria()
//						.getBase(), distitems.get(j).getBase(), itm.get(i)
//						.getPersistentModel().getGeometria().getAltezza(),
//						distitems.get(j).getAltezza()))
//						&& ((itm.get(i).getPersistentModel()
//								.getGeometria().getLunghezza()
//								- distitems.get(j).getLunghezza()) >= 200)) {
//					ddoitem.add(itm.get(i));
//					distitems.remove(j);
//
//				}
//			}
//
//		}
		
		for(int i=0; i<distitems.size(); ++i){
			MItem item = new MItem();
			MGeometria geom = new MGeometria();
			geom.getPersistentModel().setAltezza(distitems.get(i).getAltezza()/10);
			geom.getPersistentModel().setBase(distitems.get(i).getBase()/10);
			geom.getPersistentModel().setLunghezza(distitems.get(i).getLunghezza()/10);
			item.getPersistentModel().setGeometria(geom.getPersistentModel());
			item.getPersistentModel().setDescrizione("Listarelli");
			History h = HistoryFactory.createHistory();
			try {
				h.save();
			} catch (PersistentException e) {
				e.printStackTrace();
			}
			item.getPersistentModel().setHistory(h);
			geom.save();
			item.save();
			ddoitem.add(item);
		}

		MDocumentoOttimizzazione o = new MDocumentoOttimizzazione();
		JOptionPane.showMessageDialog(null, "Distinta Ottimizzata!");
		for (int i = 0; i < ddoitem.size(); ++i) {
			o.getPersistentModel().items.add(ddoitem.get(i)
					.getPersistentModel());
		}

		o.save();
		distinta.getPersistentModel().setDdo(o.getPersistentModel());
		distinta.save();

		return o;

	}

	public Boolean equal(float a, float b, float c, float e) {
		return (a == b && c == e);
	}

}