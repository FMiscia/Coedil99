package elaboradistinta;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import elaboradistinta.model.CoedilPersistentManager;
import elaboradistinta.model.Distinta;
import elaboradistinta.model.DocumentoOttimizzazione;
import elaboradistinta.model.DocumentoOttimizzazioneFactory;
import elaboradistinta.model.Geometria;
import elaboradistinta.model.GeometriaFactory;
import elaboradistinta.model.History;
import elaboradistinta.model.HistoryFactory;
import elaboradistinta.model.Item;
import elaboradistinta.model.ItemFactory;
import elaboradistinta.model.Magazzino;
import elaboradistinta.model.RigaLavoro;
import elaboradistinta.operation.OMagazzino;



public class StandardOttimizzatoreStrategy extends AOttimizzatoreStrategy {

	public StandardOttimizzatoreStrategy() {
	}

	@Override
	public DocumentoOttimizzazione elaboraOttimizzazione(Distinta distinta) {
		
		
		OMagazzino m = new OMagazzino(new Magazzino());
		//Geometrie presenti nella distinta
		ArrayList<Geometria> distitems = new ArrayList<Geometria>();
		//Item da aggiungere al DDO
		ArrayList<Item> ddoitem = new ArrayList<Item>();
		//Residui dei tagli
		ArrayList<Item> sfridi = new ArrayList<Item>();
		//Item presenti nel magazzino
		ArrayList<Item> itm = new ArrayList<Item>(m.getMagazzino().getItems().keySet());
		//Item da cancellare
		//ArrayList<Item> rem = new ArrayList<Item>();

		
		float offset;
		Iterator<RigaLavoro> it = distinta.getLavori().righe.getIterator();
		while (it.hasNext()) {
			distitems.add(it.next().getGeometria());
		}
		
		
		
		for (int i = 0; i < itm.size(); i++) {
			for (int j = 0; j < distitems.size(); j++) {
				if ((equal(itm.get(i).getGeometria().getBase(), distitems.get(j).getBase(), itm.get(i).getGeometria().getAltezza(), distitems.get(j).getAltezza()))
						&& ((itm.get(i).getGeometria().getLunghezza() - distitems.get(j).getLunghezza()) <= 100)) {
					ddoitem.add(itm.get(i));
					//rem.add(itm.get(i));
					itm.remove(i);
					//m.removeItem(itm.get(i));
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
								- distitems.get(j).getLunghezza()) >= 200)) {
					ddoitem.add(itm.get(i));
					//rem.add(itm.get(i));
					/*Geometria geom = GeometriaFactory.createGeometria();
					geom.setAltezza(itm.get(i).getGeometria().getAltezza());
					geom.setBase(itm.get(i).getGeometria().getBase());
					geom.setLunghezza(offset);
					geom.save();
					
					History h = HistoryFactory.createHistory();
					Item nuovoitem = ItemFactory.createItem();
					nuovoitem.setDescrizione(itm.get(i).getDescrizione());
					nuovoitem.setGeometria(geom);
					nuovoitem.setHistory(h);
					nuovoitem.save();*/
					
					//itm.get(i).getGeometria().setLunghezza(offset);
					//sfridi.add(itm.get(i));
					//itm.remove(i);
					distitems.remove(j);
					
					/*ddoitem.add(itm.get(i));
					m.removeItem(itm.get(i));
					distitems.remove(j);
					Geometria geom = GeometriaFactory.createGeometria();
					geom.setAltezza(itm.get(i).getGeometria().getAltezza());
					geom.setBase(itm.get(i).getGeometria().getBase());
					geom.setLunghezza(offset);
					geom.save();
					
					History h = HistoryFactory.createHistory();
					Item nuovoitem = ItemFactory.createItem();
					nuovoitem.setDescrizione(itm.get(i).getDescrizione());
					nuovoitem.setGeometria(geom);
					nuovoitem.setHistory(h);
					nuovoitem.save();
					//m.addItem(new Item(new Geometria(itm.get(i).getGeometria()
							//.getAltezza(), itm.get(i).getGeometria().getBase(),
							//offset), itm.get(i).getDescrizione()));*/
				}
			}

		}
	
		DocumentoOttimizzazione o = DocumentoOttimizzazioneFactory.createDocumentoOttimizzazione();
		JOptionPane.showMessageDialog(null,"Distinta Ottimizzata!");
		try {
			PersistentTransaction t = CoedilPersistentManager.instance().getSession().beginTransaction();
			for(int i=0; i<ddoitem.size(); ++i){
				o.items.add(ddoitem.get(i));
			}
			//for(int i=0; i<rem.size(); ++i){
			//	rem.get(i).delete();
			//}
			/*for(int i=0; i<sfridi.size(); ++i){
				Geometria geom = GeometriaFactory.createGeometria();
				geom.setAltezza(sfridi.get(i).getGeometria().getAltezza());
				geom.setBase(sfridi.get(i).getGeometria().getBase());
				geom.setLunghezza(sfridi.get(i).getGeometria().getLunghezza());
				geom.save();
				
				History h = HistoryFactory.createHistory();
				Item nuovoitem = ItemFactory.createItem();
				nuovoitem.setDescrizione(itm.get(i).getDescrizione());
				nuovoitem.setGeometria(geom);
				nuovoitem.setHistory(h);
				nuovoitem.save();
			}*/
			o.save();
			distinta.setDdo(o);
			distinta.save();
			
			t.commit();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		return o;
		

	}

	public Boolean equal(float a, float b, float c, float e) {
		return (a == b && c == e);
	}

}