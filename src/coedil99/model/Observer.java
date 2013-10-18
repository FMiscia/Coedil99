package coedil99.model;

import java.util.ArrayList;

import coedil99.controller.GestisciRDAHandler;

public abstract class Observer {
	
	protected ArrayList<Subject> subjects = new ArrayList<Subject>();
	

	public abstract ArrayList<Subject> getSubject();
	public abstract void setSubject(ArrayList<Subject> s);

	/**
	 * 
	 * @return 
	 */
	public abstract void Update();

}