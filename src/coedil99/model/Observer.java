package coedil99.model;

import java.util.ArrayList;


/**
 * 
 * @author francesco
 * 
 * Pattern Observer utilizzato per aggionrare lo stato delle merci a seconda dello stato
 * delle RDA e perfornire notifiche all'utente sullo stato delle RDA
 *
 */
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