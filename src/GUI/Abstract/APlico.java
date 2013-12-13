package GUI.Abstract;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class APlico extends JPanel {
	
	public APlico(){
		super();
	}
	
	/**
	 * Carica il plico 
	 */
	abstract public void load();
	
	/**
	 * Carica un plico in base ad un id
	 * @param id
	 */
	abstract public void load(int id);
	
	abstract public boolean isModifying();
}
