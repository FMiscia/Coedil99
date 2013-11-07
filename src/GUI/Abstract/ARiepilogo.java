package GUI.Abstract;

import javax.swing.JPanel;

/**
 * Classe astratta per i riepiloghi
 * @author Simone
 *
 */
public abstract class ARiepilogo extends JPanel {
	
	public ARiepilogo(){
		super();
	};
	
	/**
	 * Aggiorna il pannello
	 */
	public abstract void refresh();

}
