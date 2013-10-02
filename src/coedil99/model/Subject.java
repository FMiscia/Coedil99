package coedil99.model;


public interface Subject {

	/**
	 * 
	 * @param obj
	 * @return 
	 */
	public void Attach(Observer obj);

	/**
	 * 
	 * @param obj
	 * @return 
	 */
	public void Detach(Observer obj);

	/**
	 * 
	 * @return 
	 */
	public void Notify();

}