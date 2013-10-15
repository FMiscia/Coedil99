package coedil99.model;

import java.util.ArrayList;

import coedil99.controller.GestisciMagazzinoHandler;
import coedil99.controller.GestisciRDAHandler;

public class Magazzino extends Observer {

	private static Magazzino instance = null;
	
	private java.util.HashMap<Item, Integer> items;
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
	 * 
	 * @return
	 */
	private Magazzino() {
	}

	@Override
	public ArrayList<Subject> getSubject() {
		return this.subjects;
	}
	
	@Override
	public void setSubject(ArrayList<Subject> s) {
		this.subjects = s;
		
	}

	@Override
	public void Update() {
		ArrayList<RigaRDA> righe = null;
		this.setSubject(new ArrayList<Subject>(GestisciRDAHandler.getInstance().getArrayRDA()));
		for (Subject rda : this.getSubject()) {
			if (((RDA)rda).getState() == GestisciRDAHandler.ATTESA_CONFERMA) {
				righe = new ArrayList<RigaRDA>(((RDA)rda).righeRDA.getCollection());
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
	
	public static Magazzino getInstance(){
		if(instance == null)
			instance = new Magazzino();
		return instance;
	}


}