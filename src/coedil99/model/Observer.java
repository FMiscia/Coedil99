package coedil99.model;

public abstract class Observer {
	
	protected Subject subject;
	

	public abstract Subject getSubject();

	/**
	 * 
	 * @return 
	 */
	public abstract void Update();

}