package coedil99.model;

import java.util.ArrayList;

public class Magazzino implements Observer {

	ArrayList<RDA> rdaSubjects;
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
		throw new UnsupportedOperationException();
	}

	@Override
	public Subject getSubject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

}