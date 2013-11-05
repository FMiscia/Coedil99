package GUI;

import javax.swing.JPanel;

public class CommercialePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static CommercialePanel instance = null;
	
	
	/**
	 * Singleton
	 * 
	 * @return CommercialePanel
	 */
	public static CommercialePanel getInstance() {
		if (CommercialePanel.instance == null)
			CommercialePanel.instance = new CommercialePanel();
		return CommercialePanel.instance;
	}
}
