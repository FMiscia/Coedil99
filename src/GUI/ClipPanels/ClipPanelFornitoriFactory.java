package GUI.ClipPanels;

import GUI.Abstract.AClipPanel;

/**
 * Factory del Clip Panel per il plico dei Fornitori
 * @author Simone
 *
 */
public class ClipPanelFornitoriFactory extends ClipPanelFactory {

	private static ClipPanelFornitoriFactory instance = null;

	private  ClipPanelFornitoriFactory() {
	};

	@Override
	public AClipPanel makeClipPanel() {
		return new ClipPanelFornitori();
	}

	/**
	 * Singleton
	 * 
	 * @return ClipPanelFornitoriFactory
	 */
	public static ClipPanelFornitoriFactory getInstance() {
		if (instance == null)
			instance = new ClipPanelFornitoriFactory();
		return instance;
	}

}