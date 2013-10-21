package GUI.Abstract;

import javax.swing.JPanel;

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
	 * @param AbstractList: Abstrac Facroty della lista che lo conterrà
	 */
	public ACard(ALista AbstractList) {

	}

	/**
	 * Metodo per il caricamento delle informazioni nella card
	 * 
	 * @param o: Oggetto generico
	 */
	public abstract void load(Object o);

}