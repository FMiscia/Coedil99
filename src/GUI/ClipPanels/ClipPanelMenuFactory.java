package GUI.ClipPanels;

import GUI.Abstract.AClipPanel;

public class ClipPanelMenuFactory extends ClipPanelFactory {

	private static ClipPanelMenuFactory instance = null;
	
	private ClipPanelMenuFactory(){};
	
	@Override
	public AClipPanel makeClipPanel() {
		// TODO Auto-generated method stub
		return new ClipPanelMenu();
	}
	
	public static ClipPanelMenuFactory getInstance(){
		if(instance == null)
			instance = new ClipPanelMenuFactory();
		return instance;
	}

}
