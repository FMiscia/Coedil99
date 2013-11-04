package coedil99.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import org.orm.PersistentException;

import coedil99.controller.GestisciMagazzinoHandler;
import coedil99.controller.GestisciRDAHandler;
import coedil99.model.Observer;
import coedil99.model.Subject;
import coedil99.persistentmodel.CommessaFactory;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemFactory;

public class MMagazzino extends Observer {

	private static MMagazzino instance = null;

	private java.util.HashMap<MItem, Integer> items = new HashMap<MItem, Integer>();
	private String name;

	public java.util.HashMap<MItem, Integer> getItems() {
		return this.items;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Costruttore privato: inseriamo alcuni item, per consentire un minimo 
	 * di ottimizzazione
	 */
	public MMagazzino() {
		Random rand = new Random();
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			items = new ArrayList<Item>(Arrays.asList(ItemFactory.listItemByQuery(null, "ID")));
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Item t: items){
			this.items.put(new MItem(t.getID()), rand.nextInt(20));
		}
        
	}

	@Override
	public ArrayList<Subject> getSubject() {
		return this.subjects;
	}

	@Override
	public void setSubject(ArrayList<Subject> s) {
		this.subjects = s;

	}

	/**
	 * Da controllare nell'iterazione per caso d'uso gestisci magazzino e invia RDA
	 */
	@Override
	public void Update() {
//		ArrayList<RigaRDA> righe = null;
//		if (this.getSubject() == null
//				|| (this.getSubject() != null && !(this.getSubject()
//						.equals(GestisciRDAHandler.getInstance().getArrayRDA())))) {
//			this.setSubject(new ArrayList<Subject>(GestisciRDAHandler.getInstance().getArrayRDA()));
//			for (Subject rda : this.getSubject()) {
//				if (((RDA) rda).getState() == GestisciRDAHandler.ATTESA_CONFERMA) {
//					righe = new ArrayList<RigaRDA>(
//							((RDA) rda).righeRDA.getCollection());
//					for (RigaRDA temp : righe) {
//						Item i = ItemFactory.createItem();
//						i.setGeometria(temp.getDescription().getGeometria());
//						i.setProductDescription(temp.getDescription());
//						i.setDescrizione(temp.getDescription().getEssenza());
//						i.setState(GestisciMagazzinoHandler.RICHIESTO);
//					}
//				}
//			}
//		}

	}

	public static MMagazzino getInstance() {
		if (instance == null)
			instance = new MMagazzino();
		return instance;
	}

}