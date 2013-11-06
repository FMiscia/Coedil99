package coedil99.model;

import java.util.ArrayList;

/**
 * 
 * @author francesco
 *
 * Pattern Observer
 */
public abstract class Subject {

	protected ArrayList<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * 
	 * @param obj:Observer
	 * @return 
	 */
	public abstract void Attach(Observer obj);

	/**
	 * 
	 * @param obj:Observer
	 * @return 
	 */
	public abstract void Detach(Observer obj);

	/**
	 * Utilizzato per lanciare gli Update degli Observer
	 * @return 
	 */
	public abstract void Notify();

}