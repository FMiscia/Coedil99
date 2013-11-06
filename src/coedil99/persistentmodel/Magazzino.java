package coedil99.persistentmodel;

import java.util.ArrayList;
import java.util.HashMap;

public class Magazzino {

	private java.util.HashMap<Item, Integer> items = new HashMap<Item, Integer>();
	private String name;
	ArrayList<RDA> rdaSubjects;
	private static Magazzino instance = null;

	public java.util.HashMap<Item, Integer> getItems() {
		return this.items;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Magazzino getInstance() {
		return this.instance;
	}

	/**
	 * Costruttore privato: inseriamo alcuni item, per consentire un minimo
	 * di ottimizzazione
	 */
	private Magazzino() {
		throw new UnsupportedOperationException();
	}

}