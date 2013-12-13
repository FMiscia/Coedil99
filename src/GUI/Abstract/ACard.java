package GUI.Abstract;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import GUI.ConfigGUI;

/**
 * Classe Astratta per la realizzazione delle card
 * 
 * @author Simone
 * 
 */
public abstract class ACard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Abstract Factory
	 * 
	 * @param AbstractList
	 *            : Abstrac Facroty della lista che lo conterr�
	 */
	public ACard(ALista AbstractList) {

	}

	/**
	 * Metodo per il caricamento delle informazioni nella card
	 * 
	 * @param o
	 *            : Oggetto generico
	 */
	public abstract void load(Object o);

	/**
	 * Metodo che crea un JSperator
	 * 
	 * @param orientation: Orientazione
	 * @param foreground: Colore del JSeparator
	 * @param background: Colore di background
	 * @param preferredSize: Dimensione
	 * @return JSeparator
	 */
	public JSeparator createSeparator(int orientation, Dimension preferredSize) {
		JSeparator separator = new JSeparator();
		separator.setOrientation(orientation);
		separator.setForeground(ConfigGUI.getInstance().getColoreBordoCard());
		separator.setBackground(ConfigGUI.getInstance().getColoreBordoCard());
		separator.setPreferredSize(preferredSize);
		return separator;
	}
	
	/**
	 * Cambia il colore di sfondo della card settandolo come selezionato
	 */
	public void selectCard(){
		this.setBackground(ConfigGUI.getInstance().getColoreSelezionato());
	}

}