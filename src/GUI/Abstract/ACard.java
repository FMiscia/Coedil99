package GUI.Abstract;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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
	public JSeparator createSeparator(int orientation, Color foreground, Color background, Dimension preferredSize) {
		JSeparator separator = new JSeparator();
		separator.setOrientation(orientation);
		separator.setForeground(foreground);
		separator.setBackground(background);
		separator.setPreferredSize(preferredSize);
		return separator;
	}

}