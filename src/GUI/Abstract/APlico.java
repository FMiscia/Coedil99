package GUI.Abstract;

import javax.swing.JPanel;

public abstract class APlico extends JPanel {
	
	public APlico(){
		super();
	}
	
	abstract public void load();
	abstract public void load(int id);
}
