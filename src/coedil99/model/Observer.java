package coedil99.model;

public interface Observer {

	Subject getSubject();

	/**
	 * 
	 * @return 
	 */
	abstract void Update();

}