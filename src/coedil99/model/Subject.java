package coedil99.model;

import java.util.ArrayList;


public abstract class Subject {

	protected ArrayList<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * 
	 * @param obj
	 * @return 
	 */
	public abstract void Attach(Observer obj);

	/**
	 * 
	 * @param obj
	 * @return 
	 */
	public abstract void Detach(Observer obj);

	/**
	 * 
	 * @return 
	 */
	public abstract void Notify();

}