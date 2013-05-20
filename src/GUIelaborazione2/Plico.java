package GUIelaborazione2;

import javax.swing.JScrollPane;

public abstract class Plico extends JScrollPane {
	
	public Plico(){
		super();
	}
	
	abstract public void load();
	abstract public void load(Object o);
}
