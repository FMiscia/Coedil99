package coedil99.model;

import java.util.ArrayList;

import coedil99.controller.GestisciMagazzinoHandler;
import coedil99.controller.GestisciRDAHandler;

public class Magazzino extends Observer {

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
	public Magazzino() {
		this.subjects = new ArrayList<Subject>(GestisciRDAHandler.getInstance().getArrayRDA());
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
		for (RDA rda : GestisciRDAHandler.getInstance().getArrayRDA()) {
			if (rda.getState() == GestisciRDAHandler.ATTESA_CONFERMA) {
				righe = new ArrayList<RigaRDA>(rda.righeRDA.getCollection());
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