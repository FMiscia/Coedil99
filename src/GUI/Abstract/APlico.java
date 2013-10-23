package GUI.Abstract;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class APlico extends JPanel {
	
	public APlico(){
		super();
		this.setBackground(new Color(50,0,0));
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
}
