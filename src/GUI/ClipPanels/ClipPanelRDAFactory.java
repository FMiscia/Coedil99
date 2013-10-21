package GUI.ClipPanels;

import GUI.Abstract.AClipPanel;

/**
 * 
 * @author francesco
 * 
 * Implementazione Factory di Abstract Factory
 */
public class ClipPanelRDAFactory extends ClipPanelFactory {

	private static ClipPanelRDAFactory instance = null;

	private  ClipPanelRDAFactory() {
	};

	@Override
	public AClipPanel makeClipPanel() {
		// TODO Auto-generated method stub
		return new ClipPanelRDA();
	}

	public static ClipPanelRDAFactory getInstance() {
		if (instance == null)
			instance = new ClipPanelRDAFactory();
		return instance;
	}

}
