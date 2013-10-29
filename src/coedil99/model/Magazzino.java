package coedil99.model;

import java.util.ArrayList;
import java.util.HashMap;

import coedil99.controller.GestisciMagazzinoHandler;
import coedil99.controller.GestisciRDAHandler;

public class Magazzino extends Observer implements IModelComponent{

	private static Magazzino instance = null;

	private java.util.HashMap<Item, Integer> items = new HashMap<Item, Integer>();
	private String name;

	public java.util.HashMap<Item, Integer> getItems() {
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
	private Magazzino() {
        /*Startup*/
        Item item1 = new Item(new Geometria(23,50,400),"Listelli Abete");
        item1.setHistory(new History());
        Item item2 = new Item(new Geometria(23,50,300),"Listelli Scemi");
        item2.setHistory(new History());
        Item item3 = new Item(new Geometria(23,50,200),"Pannelli Stupidi");
        item3.setHistory(new History());
        Item item4 = new Item(new Geometria(23,50,100),"Pannelli Biricchini");
        item4.setHistory(new History());
        
        this.items.put(item1,4);
        this.items.put(item2,3);
        this.items.put(item3,2);
        this.items.put(item4,1);
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
		ArrayList<RigaRDA> righe = null;
		if (this.getSubject() == null
				|| (this.getSubject() != null && !(this.getSubject()
						.equals(GestisciRDAHandler.getInstance().getArrayRDA())))) {
			this.setSubject(new ArrayList<Subject>(GestisciRDAHandler.getInstance().getArrayRDA()));
			for (Subject rda : this.getSubject()) {
				if (((RDA) rda).getState() == GestisciRDAHandler.ATTESA_CONFERMA) {
					righe = new ArrayList<RigaRDA>(
							((RDA) rda).righeRDA.getCollection());
					for (RigaRDA temp : righe) {
						Item i = ItemFactory.createItem();
						i.setGeometria(temp.getDescription().getGeometria());
						i.setProductDescription(temp.getDescription());
						i.setDescrizione(temp.getDescription().getEssenza());
						i.setState(GestisciMagazzinoHandler.RICHIESTO);
					}
				}
			}
		}

	}

	public static Magazzino getInstance() {
		if (instance == null)
			instance = new Magazzino();
		return instance;
	}

}