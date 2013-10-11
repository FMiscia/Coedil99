package GUI.ClipPanels;

import GUI.Abstract.AClipPanel;

public class ClipPanelProgrammaLavoriFactory extends ClipPanelFactory {

	private static ClipPanelProgrammaLavoriFactory instance = null;

	private ClipPanelProgrammaLavoriFactory(){};

	@Override
	public AClipPanel makeClipPanel() {
		// TODO Auto-generated method stub
		return new ClipPanelProgrammaLavori();
	}

	public static ClipPanelProgrammaLavoriFactory getInstance() {
		if (instance == null)
			instance = new ClipPanelProgrammaLavoriFactory();
		return instance;
	}

}
