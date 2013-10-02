package GUI;

import javax.swing.JPanel;

public abstract class Plico extends JPanel {
	
	public Plico(){
		super();
	}
	
	abstract public void load();
	abstract public void load(int id);
}
